package com.mboarder.data;
/*
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import android.util.Log;

import com.mboarder.bean.Topic;
import com.mboarder.bean.TopicPost;
import com.mboarder.string.TextViewString;

/**
 * 
 * Util file to fetch the webpages.
 * @author Luyi Wang
 * 
 */
public class FetchWebpage {

	private static final String TAG = "FetchWebPage";
	private static final String baseURL ="http://www.mitbbs.com";
	private static final String moibleBaseURL ="http://www.mitbbs.com/mobile/";
	
	private HtmlCleaner htmlCleaner ;
	
	public HtmlCleaner getHtmlCleaner() {
		return htmlCleaner;
	}

	public void setHtmlCleaner(HtmlCleaner htmlCleaner) {
		this.htmlCleaner = htmlCleaner;
	}

	private ArrayList<String> messageStringArray;
	private URL mitbbspageURL;

	public FetchWebpage(String mitbbspageAddress) throws Exception
	{
		
		this(new URL(mitbbspageAddress),new ArrayList<String>(),new HtmlCleaner());
	}
	
	public FetchWebpage(URL mitbbspageURL)
	{
		this(mitbbspageURL,new ArrayList<String>(),new HtmlCleaner());
	}
	
	public FetchWebpage(URL mitbbspageURL,ArrayList<String> messageStringArray, HtmlCleaner htmlCleaner) {
		this.mitbbspageURL = mitbbspageURL;
		this.messageStringArray = messageStringArray;
		this.htmlCleaner = htmlCleaner;
	}
	
	public ArrayList<String> getMessageStringArray() {
		return messageStringArray;
	}

	public void setMessageStringArray(ArrayList<String> messageStringArray) {
		this.messageStringArray = messageStringArray;
	}

	public URL getMitbbspageURL() {
		return mitbbspageURL;
	}

	public void setMitbbspageURL(URL mitbbspageURL) {
		this.mitbbspageURL = mitbbspageURL;
	}
	
	public ArrayList<URL> getBoardLinks(String mitbbspageAddress) throws Exception
	{
		return this.getBoardLinks(new URL(mitbbspageAddress));
	}
	
	public ArrayList<URL> getBoardLinks(URL mitbbspageURL)
	{
		return this.getBoardLinks(htmlCleaner,mitbbspageURL,"GB2312","sy_biaoti");
	}
/**
 * get previous page and next page for board, notice the parse get the second tag by (TagNode)nodes.get(1);
 * @param htmlCleaner
 * @param mitbbspageURL
 * @param encoding
 * @param tagName
 * @return
 */
	public ArrayList<URL> getBoardLinks(HtmlCleaner htmlCleaner, URL mitbbspageURL,String encoding, String tagName)
	{
		Log.i(TAG,"getBoardLinks");
		ArrayList<URL>  links = new ArrayList<URL>();
		try{
		URLConnection conn = mitbbspageURL.openConnection();
		TagNode node = htmlCleaner.clean(new InputStreamReader(conn
				.getInputStream(), encoding));
		List nodes = node.getElementListByAttValue("id",tagName,true,true);
		Log.i(TAG, "getBoardLinks nodes.length=" + String.valueOf(nodes.size()));
		
		TagNode pnode = (TagNode)nodes.get(1);
		List linklist = pnode.getElementListByName("a",true);
		for(int i=0;i<linklist.size();i++)
		{
			TagNode pre = (TagNode)linklist.get(i);
			links.add(new URL(moibleBaseURL+pre.getAttributeByName("href")));
		}
		if(links.size()<4 && links.size()==2)
		{
			URL obj = links.get(0);
			URL obj1 = links.get(1);
			
			links.set(0, null);
			links.add(1, null);
			links.add(2,obj);
			links.add(3,obj1);
		}
		}catch(Exception ex)
		{
			Log.i(TAG,"getBoardLinks"+ex.toString());
		}
		return links;
	}
	public ArrayList<URL> getPageLinks()
	{
		return this.getPageLinks(this.getMitbbspageURL());
	}
	public ArrayList<URL> getPageLinks(String mitbbspageAddr) throws Exception
	{
		return this.getPageLinks(htmlCleaner, new URL(mitbbspageAddr), "GB2312", "sy_biaoti");
	}
	public ArrayList<URL> getPageLinks(URL mitbbspageURL)
	{
		return this.getPageLinks(htmlCleaner, mitbbspageURL, "GB2312", "sy_biaoti");
	}
	/**
	 * get page links, notice the parse get the first tag by (TagNode)nodes.get(0);
	 * @param htmlCleaner
	 * @param mitbbspageURL
	 * @param encoding
	 * @param tagName
	 * @return
	 */
	public ArrayList<URL> getPageLinks(HtmlCleaner htmlCleaner, URL mitbbspageURL,String encoding, String tagName)
	{
	
		Log.i(TAG,"getPageLinks");
		
		ArrayList<URL>  links = new ArrayList<URL>();
		
		try{
			URLConnection conn = mitbbspageURL.openConnection();
			TagNode node = htmlCleaner.clean(new InputStreamReader(conn
					.getInputStream(), encoding));
			List nodes = node.getElementListByAttValue("id",tagName,true,true);
			Log.i(TAG, "nodes.length=" + String.valueOf(nodes.size()));
			
			TagNode pnode = (TagNode)nodes.get(0);
			List linklist = pnode.getElementListByName("a",true);
			
			Log.i(TAG,""+linklist.size());
			if(linklist.isEmpty())
			{
				links.add(0,mitbbspageURL);
				links.add(1,mitbbspageURL);
				return links;
			}
			
			boolean previous = false;
			boolean next = false;
			
			for(int i=0;i<linklist.size();i++)
			{
				TagNode pre =(TagNode)linklist.get(i);
				Log.i(TAG,pre.getText().toString());
				if((pre.getText().toString().equals("\u4E0A\u9875"))||((pre.getText().toString().equals("\u540C\u4E3B\u9898\u4E0A\u7BC7"))))
				{	
						previous = true;
						links.add(new URL(moibleBaseURL+pre.getAttributeByName("href")));
				}
				if((pre.getText().toString().equals("\u4E0B\u9875"))||((pre.getText().toString().equals("\u540C\u4E3B\u9898\u4E0A\u7BC7"))))
				{
						next = true;
						links.add(new URL(moibleBaseURL+pre.getAttributeByName("href")));
				}
				
			}
			
			if(!previous)
			{
				links.add(1,links.get(0));
				links.set(0, mitbbspageURL);
			}
			if(!next)
			{
				links.add(1,mitbbspageURL);
			}
			
			Log.i(TAG,"return links length is "+links.size());
		
			
		}catch(Exception ex)
		{
			Log.i(TAG,"getPageLinks"+ex.toString());
		}
		return links;
		
	}
	public ArrayList<Topic> parseMITBBSBoard()
	{
		return this.parseMITBBSBoard(this.htmlCleaner,this.getMitbbspageURL(),"GB2312","li");
	}
	

	public ArrayList<Topic> parseMITBBSBoard(String mitbbsPageAddress)throws Exception
	{
		return this.parseMITBBSBoard(this.htmlCleaner,new URL(mitbbsPageAddress),"GB2312","li");
	}
	
	
/**
 * parsed board topics
 * @param htmlCleaner
 * @param mitbbspageURL
 * @param encoding should "gb2312"
 * @param tagName should be "li"
 * @return
 * 		Topic List
 */
	public ArrayList<Topic> parseMITBBSBoard(HtmlCleaner htmlCleaner, URL mitbbspageURL,String encoding, String tagName) {
		Log.i(TAG,"parseMITBBSBoard()");
		
		ArrayList<Topic> parsedStringList = new ArrayList<Topic>();
		try {
			URLConnection conn = mitbbspageURL.openConnection();
			TagNode node = htmlCleaner.clean(new InputStreamReader(conn
					.getInputStream(), encoding));
			List nodes = node.getElementListByName(tagName, true);
			Log.i(TAG, "nodes.length=" + String.valueOf(nodes.size()));
			String title ;
			String user; 
			String address;
			String date;
			String parsedText;
			TagNode pnode;
			for (int i = 0; i < nodes.size(); i++) {
				TagNode tnode = (TagNode)nodes.get(i);
				parsedText=tnode.getText().toString();
				title = parsedText.substring(parsedText.contains("&nbsp;")? parsedText.lastIndexOf("&nbsp;")+7: parsedText.indexOf("]")+1, parsedText.indexOf("("));
				Log.i(TAG,title);
				user = parsedText.substring(parsedText.indexOf("\u4F5C\u8005")+3,parsedText.indexOf("\u53D1\u8868\u65F6\u95F4"));
				Log.i(TAG,user);
				date = parsedText.substring(parsedText.indexOf("\u53D1\u8868\u65F6\u95F4")+5,parsedText.length()-1);
				Log.i(TAG,date);
				pnode =tnode.findElementByName("a", true);
				address = moibleBaseURL+pnode.getAttributeByName("href");
				Log.i(TAG,address);
				parsedStringList.add(new Topic(TextViewString.RemoveHtmlMarker(title), 
						"\u4F5C\u8005: "+TextViewString.RemoveHtmlMarker(user),
						address,
						"\u65F6\u95F4: "+TextViewString.RemoveHtmlMarker(date)));
				
			}
		} catch (Exception ex) {
			Log.i(TAG, "parseMITBBSBoard"+ex.toString());
		}
		//parsedStringList.add("done");
		Log.i(TAG,String.valueOf(parsedStringList.size()));
		return parsedStringList;
	}
    
	public ArrayList<TopicPost> parsePage(String url) throws Exception
	{
		Log.i(TAG,"parsePage");
		if(url.contains("marticle.php"))
			return parseTopTopic(url);
		else if(url.contains("marticle_t.php"))
			return parseMITBBSBoardTopic(url);
			
		return null;
	}
	public ArrayList<TopicPost> parseTopTopic()
	{
		return this.parseMITBBSBoardTopic(this.getHtmlCleaner(), mitbbspageURL, "GB2312", "wenzhangyudu");
	}
	
	
	public ArrayList<TopicPost> parseTopTopic(String TopTopicPageAddress)
	{
		return this.parseTopTopic(this.htmlCleaner,this.getMitbbspageURL(),"GB2312","wenzhangyudu");
	}
	
	public ArrayList<TopicPost> parseTopTopic(HtmlCleaner htmlCleaner, URL mitbbspageURL,String encoding, String tagName){
		Log.i(TAG,"parseTopTopic");
		ArrayList<TopicPost> parsedStringList = new ArrayList<TopicPost>();
		try {
			URLConnection conn = mitbbspageURL.openConnection();
			TagNode node = htmlCleaner.clean(new InputStreamReader(conn
					.getInputStream(), encoding));
			List nodes = node.getElementListByAttValue("id",tagName,true, true);
			Log.i(TAG, "nodes.length=" + String.valueOf(nodes.size()));
			String user; 
			String date;
			String msg;
			String parsedText;
			for (int i = 0; i < nodes.size(); i++) {
				TagNode tnode = (TagNode)nodes.get(i);
				parsedText=tnode.getText().toString();
				String lines[] = parsedText.split("\n");
				user = lines[1].substring(lines[1].indexOf("\u53D1\u4FE1\u4EBA")+5, lines[1].indexOf(","));
				date = lines[3].substring(lines[3].lastIndexOf("(")+1, lines[3].lastIndexOf(")"));
				StringBuilder sb = new StringBuilder();
				String temp;
				for(int k=4;k<lines.length-2;k++)
				{
					temp = TextViewString.RemoveHtmlMarker(lines[k]);
					
					sb.append(temp);
					sb.append("\n");
				}
				msg = sb.toString();
				
				parsedStringList.add(new TopicPost("\u4F5C\u8005: "+TextViewString.RemoveHtmlMarker(user),
						"\u65F6\u95F4: "+TextViewString.RemoveHtmlMarker(date),
						msg));
			}
		} catch (Exception ex) {
			Log.i(TAG, "parseTopTopic"+ex.toString());
		}
		//parsedStringList.add("done");
		return parsedStringList;
	}
	public ArrayList<TopicPost> parseMITBBSBoardTopic()
	{
		return this.parseMITBBSBoardTopic(this.htmlCleaner,this.getMitbbspageURL(),"GB2312","li");
	}
	

	public ArrayList<TopicPost> parseMITBBSBoardTopic(String mitbbsPageAddress)throws Exception
	{
		return this.parseMITBBSBoardTopic(this.htmlCleaner,new URL(mitbbsPageAddress),"GB2312","li");
	}
	
	public ArrayList<TopicPost> parseMITBBSBoardTopic(HtmlCleaner htmlCleaner, URL mitbbspageURL,String encoding, String tagName) {
		Log.i(TAG,"parseMITBBSBoardTopic");
		ArrayList<TopicPost> parsedStringList = new ArrayList<TopicPost>();
		try {
			URLConnection conn = mitbbspageURL.openConnection();
			TagNode node = htmlCleaner.clean(new InputStreamReader(conn
					.getInputStream(), encoding));
			List nodes = node.getElementListByName(tagName, true);
			Log.i(TAG, "nodes.length=" + String.valueOf(nodes.size()));
			String user; 
			String date;
			String msg;
			String parsedText;
			for (int i = 0; i < nodes.size(); i++) {
				TagNode tnode = (TagNode)nodes.get(i);
				parsedText=tnode.getText().toString();
				String lines[] = parsedText.split("\n");
				user = lines[0].substring(lines[0].indexOf("\u53D1\u4FE1\u4EBA")+5, lines[0].indexOf(","));
				date = lines[2].substring(lines[2].lastIndexOf("(")+1, lines[2].lastIndexOf(")"));
				StringBuilder sb = new StringBuilder();
				String temp;
				for(int k=3;k<lines.length-2;k++)
				{
					temp = TextViewString.RemoveHtmlMarker(lines[k]);
					sb.append(temp);
					sb.append("\n");
				}
				msg = sb.toString();
				parsedStringList.add(new TopicPost("\u4F5C\u8005: "+TextViewString.RemoveHtmlMarker(user),
						"\u65F6\u95F4: "+TextViewString.RemoveHtmlMarker(date),
						msg));
			}
		} catch (Exception ex) {
			Log.i(TAG, "parseMITBBSBoardTopic"+ex.toString());
		}
		return parsedStringList;
	}
}
