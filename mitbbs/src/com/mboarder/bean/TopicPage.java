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
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
/**
 * 
 * @author luyi.wang (storageincharge@gmail.com)
 *
 */
public class TopicPage implements Serializable {

	private ArrayList<TopicPost> posts;
	private TopicPage previous;
	private TopicPage next;
	private String address;
	
	public TopicPage(String address)
	{
		this.address = address;
	}
	
	public TopicPage(URL currentURL)
	{
		this(currentURL.toString());
	}

	public ArrayList<TopicPost> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<TopicPost> posts) {
		this.posts = posts;
	}

	public TopicPage getPrevious() {
		return previous;
	}

	public void setPrevious(TopicPage previous) {
		this.previous = previous;
	}

	public TopicPage getNext() {
		return next;
	}

	public void setNext(TopicPage next) {
		this.next = next;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
