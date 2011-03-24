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
 * Adapter used for load topic list.
 * @author luyi.wang (storageincharge@gmail.com)
 *
 */

public class Board implements Serializable{
	
	private ArrayList<Topic> topics;
	private Board previous;
	private Board next;
	private URL current;

	public Board(URL current)
	{
		this.current = current;
	}
	
	public Board(String currentAddr) throws Exception
	{
		this(new URL(currentAddr));
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}

	public Board getPrevious() {
		return previous;
	}

	public void setPrevious(Board previous) {
		this.previous = previous;
	}

	public Board getNext() {
		return next;
	}

	public void setNext(Board next) {
		this.next = next;
	}

	public URL getCurrent() {
		return current;
	}

	public void setCurrent(URL current) {
		this.current = current;
	}

}
