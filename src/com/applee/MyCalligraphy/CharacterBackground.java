package com.applee.MyCalligraphy;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.Paint.Align;

public abstract class CharacterBackground
{
		protected Rect mRect = new Rect(); 

		public Rect getRect()
		{
				return mRect;
		}

		public abstract void setRect(Rect rect);
		
		protected void AdjustTextSize(int nDesiredSize, String text)
		{
				AdjustTextSize(nDesiredSize, nDesiredSize, text);
		}
		
		protected void AdjustTextSize(int nDesiredSize, float nParam, String text)
		{
				BackgroundPaints backgroundPaints = BackgroundPaints.getInstance();
				Paint textPaint = backgroundPaints.getTextPaint();
				textPaint.setTextSize(nParam);
				
				Rect bounds = new Rect();
				textPaint.getTextBounds(text, 0, 1, bounds);
				float fResult = bounds.height() - nDesiredSize;
				if(Math.abs(fResult) < Float.MIN_VALUE)
				{
						return;
				}
				else if(fResult < 0)
				{
						AdjustTextSize(nDesiredSize, nParam + Math.abs(fResult) * 0.5F, text);
				}
				else 
				{
						AdjustTextSize(nDesiredSize, nParam - Math.abs(fResult) * 0.5F, text);
				}
		}
		
		protected void DrawBackground(Canvas canvas, Rect rect)
		{
				Rect r = rect;
				
//				Rect r = new Rect();
//				Utils.getFrameRect(this, r);
				
				BackgroundPaints backgroundPaints = BackgroundPaints.getInstance();
				Paint framePaint = backgroundPaints.getFramePaint();
				canvas.drawRect(r, framePaint);
				
				Path path = new Path();
				path.moveTo(r.left, r.top);
				path.lineTo(r.right, r.bottom);
				path.moveTo(r.left, r.bottom);
				path.lineTo(r.right, r.top);
				PathEffect effect = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
				
				Paint obliquePaint = backgroundPaints.getObliquePaint();
				obliquePaint.setPathEffect(effect);
				canvas.drawPath(path, obliquePaint);
		}
		
		public void DrawText(Canvas canvas, Rect rect)
		{
				Rect r = rect;
				
//				Rect r = new Rect();
//				Utils.getFrameRect(this, r);
				
				String text = "ÎÒ";
				float fHorizMargin = (r.height() / 8.0F);
				AdjustTextSize(r.height() - (int)fHorizMargin, text);
				Rect bounds = new Rect();
				
				BackgroundPaints backgroundPaints = BackgroundPaints.getInstance();
				Paint textPaint = backgroundPaints.getTextPaint();
				textPaint.setTextAlign(Align.LEFT);
				textPaint.getTextBounds(text, 0, 1, bounds);
				
				canvas.drawText(text, 0, 1, r.left - bounds.left + fHorizMargin * 0.5F ,
								r.top - bounds.top + fHorizMargin * 0.5F, textPaint);
		}
		
		public abstract void DrawText(Canvas canvas);
		public abstract void DrawBackground(Canvas canvas);
}
