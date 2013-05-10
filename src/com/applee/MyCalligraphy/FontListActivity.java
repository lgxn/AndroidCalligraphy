package com.applee.MyCalligraphy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FontListActivity extends ListActivity
{
		private Map<String, String> mData = new HashMap<String, String>();
		
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);

				// listView = new ListView(this);
				// listView.setAdapter(new ArrayAdapter<String>(this,
				// android.R.layout.simple_expandable_list_item_1,
				// getData()));
				setListAdapter(new ArrayAdapter<String>(this,
								android.R.layout.simple_list_item_single_choice,
								getData()));

				// setContentView(listView);
		}

		private List<String> getData()
		{
				List<String> data = new ArrayList<String>();
				Map<String, String> mpItems = new HashMap<String, String>();
				
				String strInternalPath = "/system/fonts/";
				File internalPath = new File(strInternalPath);
				File[] files = internalPath.listFiles();
				for (int i = 0; i < files.length; i++)
				{
						TTFParser ttfParser = new TTFParser();
						try
						{
								String strPath = files[i].getAbsolutePath();
								ttfParser.parse(strPath);
								
								String strfontName = ttfParser.getFontName();
								data.add(strfontName);
								
								mData.put(strfontName, strPath);
						}
						catch (IOException e)
						{
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
				}
				
				return data;
		}

		@Override
		protected void onListItemClick(ListView listView, View view,
						int position, long id)
		{
				listView.setChoiceMode(listView.CHOICE_MODE_SINGLE);
				listView.setItemChecked(position, true);
				
				TextView tv = (TextView) view;
				String strName = (String) tv.getText();
				String strPath = mData.get(strName );
				
				SettingReference.Instance(this).saveString(ConstantStrings.CONFIG_FILE_NAME,  ConstantStrings.FONT_PATH, strPath);
				
				finish();
		}
}
