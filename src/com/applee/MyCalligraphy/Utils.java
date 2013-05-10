package com.applee.MyCalligraphy;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

class Utils
{
		private static int mMargin = 5;
		
		public static float getFontHeight(Paint paint)
		{
				FontMetrics fm = paint.getFontMetrics();
				return (float) (Math.ceil(fm.descent - fm.top) + 2);
		}
		
		public static float getFontWidth(Paint paint, String text)
		{
				float[] widths = new float[1];
				paint.getTextWidths(text, widths );
				return widths[0];
		}
		
		public static float getSideLength(Paint paint, String text)
		{
				float cy = getFontHeight(paint);
				float cx = getFontWidth(paint, text);
				
				return cy > cx ? cy : cx;
		}
		
		public static PointF getCenterPoint(float cx, float cy)
		{
				return new PointF(cx * 0.5F, cy * 0.5F);
		}

		public static void getFrameRect(Rect r)
		{
				// TODO Auto-generated method stub
				int nX = r.centerX();
				int nY = r.centerY();
				int nLength = getFrameLength(r);
				int nHalfLength = (int) (nLength * 0.5F);
				
				r.set(nX - nHalfLength, nY - nHalfLength, nX + nHalfLength, nY + nHalfLength);
		}
		
		private static int getFrameLength(Rect r)
		{
				int nX = r.centerX();
				int nY = r.centerY();
				int nLength = nY;
				if(nY > nX)
						nLength = nX;
				
				nLength -= (mMargin * 2);
				return nLength * 2;
		}
		
		public static void getFrameRect(Rect r, Rect rcMin)
		{
				// TODO Auto-generated method stub
				Rect rect = r;
				int nLength = getFrameLength(r);
				int nMinLength = rect.height() - 3 * mMargin - nLength; 
				
				int nMinLeft = rect.left - mMargin;
				int nMinTop = rect.top - mMargin;
			
				rcMin.set(nMinLeft, nMinTop, nMinLeft + nMinLength, nMinTop + nMinLength);
				
				int nLeft = rect.left;
				int nTop = nMinTop + 2 * mMargin + nMinLength;
				r.set(nLeft, nTop, nLeft + nLength, nTop + nLength);
		}
}
