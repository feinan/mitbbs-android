/**
 * 
 */
package com.mboarder.app;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.mboarder.app.R;
import com.mboarder.bean.Board;
import com.mboarder.bean.CategoryPage;
import com.mboarder.util.Translate;

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


/**
* 
* 
* @Author FeiNan (nan.26505@gmail.com)
* 
* 
*/

public class MitbbsCategoryLoader extends ExpandableListActivity {

	public static final String TAG = "MitbbsCategoryLoader";
	ArrayList<String> linkList = new ArrayList<String>();

	CategoryPage mitbbsCategoryPage = new CategoryPage();
	
    private static final String TitleCN = "TitleCN";
    private static final String TitleEN = "TitleEN";
    
	private static final int MENU_REFRESH = 0;
	private static final int MENU_CLOSE = 1;
	private static final int MENU_NEXT = 2;
	private static final int MENU_PREVIOUS = 3;
	private static final int MENU_ABOUT = 4;    
    
	private Board switchBoard;
    private ExpandableListAdapter mAdapter;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitle(Translate.ABOUT_APP_TITLE);
		
		String[] categoryName = mitbbsCategoryPage.getCategoryName();
		
		mitbbsCategoryPage.init();
		
		ArrayList<HashMap<String, String>> groupData = new ArrayList<HashMap<String, String>>();
        ArrayList<ArrayList<HashMap<String, String>>> childData = new ArrayList<ArrayList<HashMap<String, String>>>();
        
        for (int i = 0; i < categoryName.length; i++) {
        	HashMap<String, String> curGroupMap = new HashMap<String, String>();
            curGroupMap.put(TitleCN, categoryName[i]);
            groupData.add(curGroupMap);
            
            childData.add(mitbbsCategoryPage.getCategoryPagePostListArray().get(i));
        }
        
        // Set up our adapter
        
        /*mAdapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { TitleCN },
                new int[] { android.R.id.text1},
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { TitleCN, TitleEN },
                new int[] { android.R.id.text1, android.R.id.text2 }
                );*/      
        
        mAdapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.category_main,
                new String[] { TitleCN },
                new int[] { R.id.text1},
                childData,
                R.layout.category_page_list_view,
                new String[] { TitleCN, TitleEN },
                new int[] { R.id.text1, R.id.text2 }
                );
        
        setListAdapter(mAdapter);
        

        ExpandableListView elv = getExpandableListView ();
        elv.setLayoutAnimation(getLayoutAnimationController());
        elv.setTextFilterEnabled(true);

        
		elv.setOnChildClickListener(new OnChildClickListener() {
			  public boolean onChildClick(ExpandableListView parent, View v,
				      int groupPosition, int childPosition, long id){
				Log.w(TAG, "Enter onItemClick()");
				
			    Map<String, String> map = (Map<String, String>) parent.getExpandableListAdapter().getChild(
			            groupPosition, childPosition);

			    try{
			    	
			    switchBoard= new Board(map.get("Url"));
			    switchBoard.setCurrent(new URL((map.get("Url"))));
				Intent i = new Intent(MitbbsCategoryLoader.this,
						BoardLoader.class);
				i.putExtra("url", map.get("Url"));
				i.putExtra("board",switchBoard);
				i.putExtra("title", map.get("TitleCN"));
				startActivity(i);
			    }catch(Exception ex)
			    {
			    	Log.i(TAG,"onCreate"+ex.toString());
			    }
				return true;
			}
		});

	}

	private LayoutAnimationController getLayoutAnimationController() {
		// Start Animation
		AnimationSet set = new AnimationSet(true);

		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(50);
		set.addAnimation(animation);

		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				-1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(100);
		set.addAnimation(animation);

		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		// End Animation

		return controller;
	}

	/* Creates the menu items */
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_ABOUT, 0, "\u5173\u4E8E").setIcon(R.drawable.ic_menu_info_details);		
		menu.add(0, MENU_CLOSE, 0, "\u8FD4\u56DE").setIcon(R.drawable.ic_menu_close_clear_cancel);		
		return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_CLOSE:
			Quit();
			return true;
		case MENU_ABOUT:
			MenuAbout();
			return true;
		}
		return false;
	}

	public void Quit() {		
		//finishFromChild(this);
		finish();
	}
		
	public void MenuAbout() {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    alertDialog.setTitle(Translate.ABOUT_APP_TITLE);
	    alertDialog.setMessage(Translate.ABOUT_APP);
	    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) {
	          return;
	      } }); 
	    alertDialog.show();	    
	}

}
