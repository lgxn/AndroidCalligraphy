package com.applee.MyCalligraphy;

import java.io.File;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.os.Environment;

public class BackgroundPaints
{
		private Paint mPaint;
		private Paint mTextPaint;
		private Paint mObliquePaint;
		private Paint mFramePaint;

		protected BackgroundPaints()
		{

		}

		private static BackgroundPaints mInstance = new BackgroundPaints();

		public static BackgroundPaints getInstance()
		{
				return mInstance;
		}

		public Paint getPaint()
		{
				return mPaint;
		}

		public Paint getTextPaint()
		{
				return mTextPaint;
		}

		public Paint getObliquePaint()
		{
				return mObliquePaint;
		}

		public Paint getFramePaint()
		{
				return mFramePaint;
		}

		public void InitPaints(Context context)
		{
				SettingReference settingReference = SettingReference
								.Instance(context);

				// Callingraphy
				mPaint = new Paint();
				mPaint.setAntiAlias(true);
				mPaint.setStyle(Paint.Style.STROKE);
				mPaint.setStrokeJoin(Paint.Join.ROUND);
				mPaint.setStrokeCap(Paint.Cap.SQUARE);
				mPaint.setStrokeWidth(5);

				// Font
				mTextPaint = new Paint();
				mTextPaint.setAntiAlias(true);
				mTextPaint.setStyle(Paint.Style.STROKE);
				mTextPaint.setStrokeJoin(Paint.Join.ROUND);
				mTextPaint.setStrokeCap(Paint.Cap.SQUARE);
				mTextPaint.setColor(Color.RED);
				mTextPaint.setStrokeWidth(3);
				// mTextPaint.setTextAlign(Align.CENTER);

				String strPath = settingReference.getString(
								ConstantStrings.FONT_PATH,
								ConstantStrings.FONT_PATH);
				
				if (strPath != null)
				{
						File fontFile = new File(
										Environment.getExternalStorageDirectory(),
										strPath);
						if (fontFile.exists())
						{
								Typeface typeface = Typeface
												.createFromFile(new File(
																Environment.getExternalStorageDirectory(),
																strPath));

								BackgroundPaints backgroundPaints = BackgroundPaints
												.getInstance();

								mTextPaint.setTypeface(typeface);
						}
				}

				// Oblique
				mObliquePaint = new Paint();
				mObliquePaint.setAntiAlias(true);
				mObliquePaint.setStyle(Paint.Style.STROKE);
				mObliquePaint.setStrokeJoin(Paint.Join.ROUND);
				mObliquePaint.setStrokeCap(Paint.Cap.SQUARE);
				mObliquePaint.setColor(Color.BLUE);
				mObliquePaint.setStrokeWidth(1);

				//
				mFramePaint = new Paint();
				mFramePaint.setAntiAlias(true);
				mFramePaint.setStyle(Paint.Style.STROKE);
				mFramePaint.setStrokeJoin(Paint.Join.ROUND);
				mFramePaint.setStrokeCap(Paint.Cap.SQUARE);
				mFramePaint.setStrokeWidth(5);
				mFramePaint.setColor(Color.BLUE);
		}
}
