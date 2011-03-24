package com.mboarder.app.adapter;
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

import com.mboarder.app.R;
import com.mboarder.bean.Topic;
import com.mboarder.bean.TopicPost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 *  Adapter used for load topic post list.
 *  
 * @author luyi.wang
 *
 */
public class TopicListAdapter extends BaseAdapter{
	
	private ArrayList<TopicPost> contents;
	private Context mContext;
	public TopicListAdapter(Context c,ArrayList<TopicPost> t) {
		this.mContext =c;
		this.contents =t ;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contents.size();
	}

	@Override
	public Object getItem(int position) {
		return contents.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
LinearLayout row ;
		
		TopicPost topicPost = contents.get(position);
		if(convertView== null)
		{
			row = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.post, parent, false);
		}
		else
		{
			row = (LinearLayout)convertView;
		}
		TextView titleView =(TextView)row.findViewById(R.id.post_user);
		titleView.setText(topicPost.getUser());
		TextView userView =(TextView)row.findViewById(R.id.post_date);
		userView.setText(topicPost.getDate());
		TextView dateView =(TextView)row.findViewById(R.id.post_msg);
		dateView.setText(topicPost.getMsg());
		return row;
		
	}

	
}
