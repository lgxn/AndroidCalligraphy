package com.applee.MyCalligraphy;

import java.io.File;

import android.app.*;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity
{
		private OnClickListener mListenerRefresh;
		private OnClickListener mListenerPrevious;
		private OnClickListener mListenerNext;
		private OnClickListener mListenerSetting;
		private OnItemSelectedListener mListenerType;

		@Override
		public void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main);
				
				BackgroundPaints backgroundPaints = BackgroundPaints.getInstance();
				backgroundPaints.InitPaints(this);

				Button buttonRefresh = (Button) findViewById(R.id.buttonRefresh);
				mListenerRefresh = new View.OnClickListener()
				{
						@Override
						public void onClick(View arg0)
						{
								// TODO Auto-generated method stub
								DrawingView view = (DrawingView) findViewById(R.id.imgView);
								view.ClearView();
						}
				};

				buttonRefresh.setOnClickListener(mListenerRefresh);

				Button buttonPrevious = (Button) findViewById(R.id.buttonPrevious);
				mListenerPrevious = new View.OnClickListener()
				{
						@Override
						public void onClick(View arg0)
						{
								// TODO Auto-generated method stub

						}
				};

				buttonPrevious.setOnClickListener(mListenerPrevious);

				Button buttonNext = (Button) findViewById(R.id.buttonNext);
				mListenerNext = new View.OnClickListener()
				{
						@Override
						public void onClick(View arg0)
						{
								// TODO Auto-generated method stub

						}
				};

				buttonNext.setOnClickListener(mListenerNext);

				Button buttonSetting = (Button) findViewById(R.id.buttonSetting);
				mListenerSetting = new View.OnClickListener()
				{
						@Override
						public void onClick(View arg0)
						{
								Intent intent = new Intent(MainActivity.this, SettingListActivity.class);
								startActivity(intent);
								
//								try
//								{
//										// TODO Auto-generated method stub
//										AssetManager mgr = MainActivity.this
//														.getAssets();
//										Typeface typeface = Typeface
//														.createFromAsset(mgr,
//																		"Fonts/YECAO.ttf");
//
//										// Typeface typeface = Typeface
//										// .createFromFile(new File(
//										// Environment.getExternalStorageDirectory(),
//										// "/assets/Fonts/YECAO.ttf"));
//
//										BackgroundPaints backgroundPaints = BackgroundPaints
//														.getInstance();
//										Paint textPaint = backgroundPaints
//														.getTextPaint();
//										textPaint.setTypeface(typeface);
//
//										DrawingView view = (DrawingView) findViewById(R.id.imgView);
//										view.invalidate();
//								}
//								catch (Exception e)
//								{
//										// TODO: handle exception
//										String s = e.getMessage();
//								}
						}
				};

				buttonSetting.setOnClickListener(mListenerSetting);

				Spinner spinnerType = (Spinner) findViewById(R.id.spinnerType);
				mListenerType = new Spinner.OnItemSelectedListener()
				{
						@Override
						public void onItemSelected(AdapterView<?> arg0,
										View arg1, int arg2, long arg3)
						{
								// TODO Auto-generated method stub
								DrawingView view = (DrawingView) findViewById(R.id.imgView);
								switch (arg2)
								{
										case 0 :
												view.setCharacterBackgroundType(CharacterBackgroundType.RED_CHARACTER_BACKGROUND);
												break;
										case 1 :
												view.setCharacterBackgroundType(CharacterBackgroundType.COPY_CHARACTER_BACKGROUND);
												break;
										default :
												break;
								}
						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0)
						{
								// TODO Auto-generated method stub

						}
				};

				spinnerType.setOnItemSelectedListener(mListenerType);

		}
		
		@Override	
		protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data)
		{
				BackgroundPaints.getInstance().InitPaints(this);
				
				DrawingView view = (DrawingView) findViewById(R.id.imgView);
				view.invalidate();
		}
}
