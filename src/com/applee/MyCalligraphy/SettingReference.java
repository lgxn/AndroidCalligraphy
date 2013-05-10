package com.applee.MyCalligraphy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SettingReference
{
		private static SettingReference mInstance = null;
		private Context context;

		public static SettingReference Instance(Context context)
		{
				if(mInstance == null)
						mInstance = new SettingReference(context);
				
				return mInstance;						
		}
		
		protected SettingReference()
		{
		}

		protected SettingReference(Context context)
		{
				this.context = context;
		}

		public void saveString(String filename, String key, String value)
		{
				SharedPreferences preferences = context.getSharedPreferences(
								filename, Context.MODE_PRIVATE);
				Editor editor = preferences.edit();
				editor.putString(key, value);
				editor.commit();
		}

		public String getString(String filename, String key)
		{
				SharedPreferences preferences = context.getSharedPreferences(
								filename, Context.MODE_PRIVATE);
				return preferences.getString(key, null);
		}
}