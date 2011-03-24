package com.mboarder.app;

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





import java.net.URL;
import java.util.ArrayList;

import com.mboarder.app.R;
import com.mboarder.app.adapter.BoardListAdapter;
import com.mboarder.app.adapter.TopicListAdapter;
import com.mboarder.bean.Board;
import com.mboarder.bean.Topic;
import com.mboarder.bean.TopicPage;
import com.mboarder.bean.TopicPost;
import com.mboarder.data.FetchWebpage;
import com.mboarder.gesture.SimpleGestureFilter;
import com.mboarder.gesture.SimpleGestureFilter.SimpleGestureListener;
import com.mboarder.util.Translate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
/**
* 
* 
* @Author Luyi Wang (storageincharge@gmail.com)
* @author feinan (nan.26505@gmail.com)
* 
* Used to load mitbbs page.
* 
*/
public class PageLoader extends ListActivity implements SimpleGestureListener {

	private static final String TAG = "PageLoader";
	
	private TopicPage currentPage;
	private String pageUrl;
	private static FetchWebpage fw;
	protected static final int STATE_GOT_CURSOR = 0;
	protected static final int STATE_ERROR = 1;
	private static final int MENU_REFRESH = 0;
	private static final int MENU_CLOSE = 1;
	private static final int MENU_NEXT = 2;
	private static final int MENU_PREVIOUS = 3;
	private static final int MENU_ABOUT = 4;	
	private TopicListAdapter topicListAdatper;
	private Context mContext;
	private ListView own;
	private SimpleGestureFilter detector;
	
	private  ImageButton leftarrow;
	private  ImageButton rightarrow;
	private  ImageButton refresharrow;
	private ProgressBar pageProgressbar;
	
	
	public Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case STATE_ERROR:
				Log.w(TAG, "handleMessage Error");
				popDialog().show();
				break;
			case STATE_GOT_CURSOR:
				try {
					setListAdapter(topicListAdatper);
					setProgressBarVisibility(false);
					setProgressBarIndeterminateVisibility(false);
					ListView lv = getListView();
					lv.setLayoutAnimation( getLayoutAnimationController() );
					lv.setTextFilterEnabled(true);												
				} catch (Exception e) {
					Log.w(TAG, "handleMessage Exception");
				}
				break;
			}
		}
	};
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		detector = new SimpleGestureFilter(this,this);
		mContext = this;
		own = getListView();
		// Request for the progress bar to be shown in the title
		
		initialPage();
		initialBanner();
		
		
	}//onCreate
	private void initialPage() {
		setContentView(R.layout.topiclist);
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		Bundle current= getIntent().getExtras();
		if(current!=null)
		{
			pageUrl= current.getString("url");
			currentPage =(TopicPage) current.getSerializable("page");
			setTitle("mitbbs - "+current.getString("title"));
		}
		
		
		if(pageUrl==null)
		{
			pageUrl ="http://www.mitbbs.com/mobile/marticle.php?board=Soccer&id=31911917&ftype=0&p=tp";
		}
		
		(new Thread() {
	
			public void run() {
					
				try{	
					
					fw = new FetchWebpage(pageUrl);
					Log.i(TAG,pageUrl);
					if(currentPage==null)
					{
						currentPage = new TopicPage(pageUrl);
						refreshPage();
					}
					else
					{
						if(currentPage.getPosts()!=null)
						{
							topicListAdatper= new TopicListAdapter(mContext, currentPage.getPosts());
						}else
						{
							refreshPage();
						}

					}
					Message.obtain(mHandler, STATE_GOT_CURSOR, null).sendToTarget();
				}catch(Exception ex)
				{
					Log.i(TAG,ex.toString());
					Message.obtain(mHandler, STATE_ERROR, null).sendToTarget();
				}
			}

			
		}).start();
	}//initialPage
	public void initialBanner()
	{
		 leftarrow = (ImageButton) findViewById(R.id.topicleft_button);
		 rightarrow = (ImageButton) findViewById(R.id.topicright_button);
		 refresharrow =  (ImageButton) findViewById(R.id.topicrefresh_button);
		 

		 leftarrow.setOnClickListener(new OnClickListener() {
		                         public void onClick(View v) {
		                            try {
		                            	currentPage = currentPage.getPrevious();
										refreshPage();
										
									} catch (Exception e) {
										Log.i(TAG,e.toString());
										e.printStackTrace();
									}
		                         }
		                     });
		 rightarrow.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {
            	 try {
            		 currentPage = currentPage.getNext();
					refreshPage();
					
				} catch (Exception e) {
					Log.i(TAG,e.toString());
					e.printStackTrace();
				}
             }
         });
		 refresharrow.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {
            	 try {
					refreshPage();
				} catch (Exception e) {
					Log.i(TAG,e.toString());
					e.printStackTrace();
				}
             }
         });
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		try {
			refreshPage();
		} catch (Exception e) {
			Log.i(TAG,e.toString());
			e.printStackTrace();
		}
		
	}
	public Dialog popDialog()
	{
		Dialog errorDialog = new AlertDialog.Builder(PageLoader.this)
        .setIcon(R.drawable.ic_menu_info_details)
        .setTitle("Error!")
        .setMessage("Gosh, there is a problem with network!")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked OK so do some stuff */
            }
        })
        .create();	
		Log.i(TAG,"errorDialog created");
		
		return errorDialog;
	}
	
	private void refreshPage() throws Exception {
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		(new Thread() {
			
			public void run() {
					
				try{	
					
		Log.i(TAG,"start page refreshing ");	
		currentPage.setPosts((fw.parsePage(currentPage.getAddress())));
		
		ArrayList<URL> pageLinks= fw.getPageLinks(currentPage.getAddress());
		URL next =  pageLinks.get(pageLinks.size()-1);
		URL previous = pageLinks.get(pageLinks.size()-2);
		
		currentPage.setNext(new TopicPage(next));
		currentPage.setPrevious(new TopicPage(previous));
		
		topicListAdatper = new TopicListAdapter(mContext,currentPage.getPosts());
		Log.i(TAG,"Refreshing stop");
		Message.obtain(mHandler, STATE_GOT_CURSOR, null).sendToTarget();
				}catch(Exception ex)
				{
					Log.i(TAG,ex.toString());
					Message.obtain(mHandler, STATE_ERROR, null).sendToTarget();
				}
			}
		}).start();
	}
	
	private LayoutAnimationController getLayoutAnimationController()
	{
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
		menu.add(0, MENU_REFRESH, 0, "\u5237\u65B0").setIcon(R.drawable.ic_menu_refresh);
		menu.add(0, MENU_ABOUT, 0, "\u5173\u4E8E").setIcon(R.drawable.ic_menu_info_details);		
		menu.add(0, MENU_PREVIOUS, 0, "\u4E0A\u9875").setIcon(R.drawable.ic_menu_back);
		menu.add(0, MENU_CLOSE, 0, "\u8FD4\u56DE").setIcon(R.drawable.ic_menu_close_clear_cancel);		
		menu.add(0, MENU_NEXT, 0, "\u4E0B\u9875").setIcon(R.drawable.ic_menu_forward);
		return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_REFRESH:
			MenuRefresh();
			return true;
		case MENU_CLOSE:
			Quit();
			return true;
		case MENU_NEXT:
			MenuNext();
			return true;
		case MENU_PREVIOUS:
			MenuPrevious();
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
	
	public void MenuRefresh() {
		try {
			refreshPage();
		} catch (Exception e) {
			Log.i(TAG,e.toString());
			e.printStackTrace();
		}
	}
	
	public void MenuNext() {
		try {
			currentPage = currentPage.getNext();
			refreshPage();

		} catch (Exception e) {
			Log.i(TAG, e.toString());
			e.printStackTrace();
		}
	}

	public void MenuPrevious() {
        try {
        	currentPage = currentPage.getPrevious();
			refreshPage();
			
		} catch (Exception e) {
			Log.i(TAG,e.toString());
			e.printStackTrace();
		}
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

	@Override 
	 public boolean dispatchTouchEvent(MotionEvent me){ 
	   this.detector.onTouchEvent(me);
	  return super.dispatchTouchEvent(me); 
	 }

	  @Override
	 public void onSwipe(int direction) {
	  String str = "";
	  
	  switch (direction) {
	  
	  case SimpleGestureFilter.SWIPE_RIGHT : str = "loading previous page ..."; MenuPrevious();
	                                           break;
	  case SimpleGestureFilter.SWIPE_LEFT :  str = "loading next page ..."; MenuNext();
	  
	                                                 break;
	  /*case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
	                                                 break;
	  case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
	                                                 break;*/	                                           
	  }
	  if(str!=null && str.length()>0)
	  {
		  Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	  }
	  Log.w(TAG, str);
	 }

	 @Override
	 public void onDoubleTap() {
	    Toast.makeText(this, "\u53CC\u51FB\u4EC0\u4E48\u4E5F\u6CA1\u6709 ^_^", Toast.LENGTH_SHORT).show(); 
	 }

}
