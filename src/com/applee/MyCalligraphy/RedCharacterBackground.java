package com.applee.MyCalligraphy;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.Paint.Align;

public class RedCharacterBackground extends CharacterBackground
{
		public void setRect(Rect rect)
		{
				Utils.getFrameRect(rect);
				this.mRect = rect;
		}

		public void DrawText(Canvas canvas)
		{
				DrawText(canvas, mRect);
		}
		
		public void DrawBackground(Canvas canvas)
		{
				DrawBackground(canvas, mRect);
		}
}
