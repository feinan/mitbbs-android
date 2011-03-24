package com.mboarder.bean;
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
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Adapter used for load topic list.
 * @author luyi.wang (storageincharge@gmail.com)
 *
 */
public class Topic {
	
	public final static String TOPIC_TITLE ="Title";
	public final static String TOPIC_USER ="User";
	public final static String TOPIC_DATE ="Date";
	
	private String title;
	private String user;
	private String address;
	private String date;
	private TopicPage startPage;
	private HashMap<String,String> viewHashMap;
	

	public Topic(String title,String user, String address,String date)
	{
		this(title,user,address,date,new TopicPage(address));
	}
	
	public Topic(String title, String user, String address, String date,TopicPage startPage)
	{
		this.title = title;
		this.user = user;
		this.address = address;
		this.date  = date;
		this.startPage = startPage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public TopicPage getStartPage() {
		return startPage;
	}

	public void setStartPage(TopicPage startPage) {
		this.startPage = startPage;
	}

	public HashMap<String,String> getViewHashMap() {
		
		viewHashMap.put(TOPIC_TITLE, this.getTitle());
		viewHashMap.put(TOPIC_USER, this.getUser());
		viewHashMap.put(TOPIC_DATE, this.getDate());
		
		return viewHashMap;
	}

	public void setViewHashMap(HashMap<String,String> viewHashMap) {
		this.viewHashMap = viewHashMap;
	}
}
