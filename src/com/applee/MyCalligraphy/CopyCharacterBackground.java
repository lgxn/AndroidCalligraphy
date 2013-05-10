package com.applee.MyCalligraphy;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.Paint.Align;

public class CopyCharacterBackground extends CharacterBackground
{	
		protected Rect mMinRect = new Rect(); 

		public Rect getMinRect()
		{
				return mMinRect;
		}

		public void setRect(Rect rect)
		{
				Utils.getFrameRect(rect, mMinRect);
				mRect = rect;
		}
		
		public void DrawText(Canvas canvas)
		{
				DrawText(canvas, mMinRect);
		}
		
		public void DrawBackground(Canvas canvas)
		{
				DrawBackground(canvas, mMinRect);
				DrawBackground(canvas, mRect);
		}
}
