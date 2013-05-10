package com.applee.MyCalligraphy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class SettingDialogs
{
//		public static String showListModalDialog(String strName,
//						Map<String, String> mpItems, Activity activity)
//		{
//				Set<String> sItems = mpItems.keySet();
//				if (sItems.isEmpty())
//						return "";
//
//				String[] strItems = new String[sItems.size()];
//				
//				int i = 0;
//				Iterator<String> iteratorItems = sItems.iterator();
//				while (iteratorItems.hasNext())
//				{
//						strItems[i] = iteratorItems.next();
//						i++;
//				}
//
//				int nWhich = 0;
//				AlertDialog.Builder builder = new Builder(activity);
//				builder.setTitle(strName);
//				builder.setItems(strItems, new OnClickListener()
//				{
//						@Override
//						public void onClick(DialogInterface dialog, int which)
//						{
//								dialog.dismiss();
//						}
//				});
//
//				new Handler()
//				{
//						@Override
//						public void handleMessage(Message msg)
//						{
//								// process incoming messages here
//								// super.handleMessage(msg);
//								throw new RuntimeException();
//						}
//				};
//
//				builder.create().show();
//
//				try
//				{
//						Looper.getMainLooper().loop();
//				}
//				catch (RuntimeException e2)
//				{
//				}
//				
//				String strItem = strItems[nWhich];
//				if(!mpItems.containsKey(strItem))
//						return "";
//				
//				return mpItems.get(strItem);
//		}
//
//		public static String showFontDialog(Activity activity)
//		{
//				Map<String, String> mpItems = new HashMap<String, String>();
//				
//				String strInternalPath = "/system/fonts/";
//				File internalPath = new File(strInternalPath);
//				File[] files = internalPath.listFiles();
//				for (int i = 0; i < files.length; i++)
//				{
//						TTFParser ttfParser = new TTFParser();
//						try
//						{
//								String strPath = files[i].getAbsolutePath();
//								ttfParser.parse(strPath);
//								
//								String strfontName = ttfParser.getFontName();
//								mpItems.put(strfontName, strPath);
//						}
//						catch (IOException e)
//						{
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//						}
//				}
//				
//				String strItem = showListModalDialog("Ñ¡Ôñ×ÖÌå", mpItems, activity);
//				return strItem;
//		}

}
