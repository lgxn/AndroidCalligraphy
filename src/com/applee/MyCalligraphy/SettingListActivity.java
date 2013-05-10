package com.applee.MyCalligraphy;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingListActivity extends ListActivity
{
		private static int INDEX_FONT_DIALOG = 0;

		@Override
		public void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);

				// listView = new ListView(this);
				// listView.setAdapter(new ArrayAdapter<String>(this,
				// android.R.layout.simple_expandable_list_item_1,
				// getData()));
				setListAdapter(new ArrayAdapter<String>(this,
								android.R.layout.simple_expandable_list_item_1,
								getData()));

				// setContentView(listView);
		}

		private List<String> getData()
		{
				List<String> data = new ArrayList<String>();
				data.add("字体");
				data.add("字体颜色");
				data.add("方格颜色");
				data.add("方格显隐");
				data.add("画笔颜色");
				data.add("画笔粗细");

				return data;
		}

		@Override
		protected void onListItemClick(ListView listView, View view,
						int position, long id)
		{
				switch (position)
				{
						case 0 :
								{
										Intent intent = new Intent(
														SettingListActivity.this,
														FontListActivity.class);
										
										startActivityForResult(intent,
														INDEX_FONT_DIALOG);
								}
								break;
						case 1 :
								break;
						case 2 :
								break;
						case 3 :
								break;
						case 4 :
								break;
						case 5 :
								break;
						default :
								break;
				}
		}
		
		@Override	
		protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data)
		{
				//?
				/
				BackgroundPaints.getInstance().InitPaints(this);
				
				DrawingView view = (DrawingView) findViewById(R.id.imgView);
				view.invalidate();
		}
}
