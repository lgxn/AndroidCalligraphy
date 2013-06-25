package com.applee.MyCalligraphy;

import android.annotation.SuppressLint;
import android.content.*;
import android.graphics.*;
import android.graphics.Paint.FontMetrics;
import android.view.*;
import android.widget.*;
import android.util.*;

public class DrawingView extends ImageView
{
		private Path mPath;
		private float mX, mY;
		private CharacterBackgroundType mCharacterBackgroundType = CharacterBackgroundType.RED_CHARACTER_BACKGROUND;
		private static final float TOUCH_TOLERANCE = 4;

		public DrawingView(Context context, AttributeSet attrs)
		{
				super(context, attrs);
				Initialize();
		}

		public DrawingView(Context context, AttributeSet attrs, int defStyle)
		{
				super(context, attrs, defStyle);
				Initialize();
		}

		public DrawingView(Context context)
		{
				super(context);
				Initialize();
		}

		private void Initialize()
		{
				try
				{
						CharacterBackground characterBackground = CharacterBackgroundFactory
										.getCharacterBackground(mCharacterBackgroundType);
				}
				catch (AndroidException e)
				{
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		}

		private void DrawText0(Canvas canvas)
		{
				Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				textPaint.setTextSize(350);
				textPaint.setColor(Color.BLACK);

				// FontMetrics瀵硅薄
				FontMetrics fontMetrics = textPaint.getFontMetrics();

				String text = "abcd";

				// 璁＄畻姣忎竴涓潗鏍�				
				float baseX = 10;
				float baseY = 100;
				float topY = baseY + fontMetrics.top;
				float ascentY = baseY + fontMetrics.ascent;
				float descentY = baseY + fontMetrics.descent;
				float bottomY = baseY + fontMetrics.bottom;

				// 缁樺埗鏂囨湰
				canvas.drawText(text, baseX, baseY, textPaint);

				// BaseLine鎻忕敾
				Paint baseLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				baseLinePaint.setColor(Color.RED);
				canvas.drawLine(0, baseY, getWidth(), baseY, baseLinePaint);

				// Base鎻忕敾
				canvas.drawCircle(baseX, baseY, 5, baseLinePaint);

				// TopLine鎻忕敾
				Paint topLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				topLinePaint.setColor(Color.LTGRAY);
				canvas.drawLine(0, topY, getWidth(), topY, topLinePaint);

				// AscentLine鎻忕敾
				Paint ascentLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				ascentLinePaint.setColor(Color.GREEN);
				canvas.drawLine(0, ascentY, getWidth(), ascentY,
								ascentLinePaint);

				// DescentLine鎻忕敾
				Paint descentLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				descentLinePaint.setColor(Color.YELLOW);
				canvas.drawLine(0, descentY, getWidth(), descentY,
								descentLinePaint);

				// ButtomLine鎻忕敾
				Paint bottomLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				bottomLinePaint.setColor(Color.MAGENTA);
				canvas.drawLine(0, bottomY, getWidth(), bottomY,
								bottomLinePaint);
		}

		private void DrawCallingraphy(Canvas canvas)
		{
				if (mPath != null)
				{
						BackgroundPaints backgroundPaints = BackgroundPaints
										.getInstance();
						Paint paint = backgroundPaints.getPaint();
						canvas.drawPath(mPath, paint);
				}
		}

		@Override
		public void onDraw(Canvas canvas)
		{
				super.onDraw(canvas);
				// Typeface typeface =
				// Typeface.createFromFile("font/simkai.ttf");
				// Typeface typeface0 = Typeface.createFromAsset(getAssets(),
				// "font/simkai.ttf");
				// name.setTypeface(typeface);
				CharacterBackground characterBackground = CharacterBackgroundFactory
								.getCurrentInstance();
				if (characterBackground != null)
				{
						Rect r = new Rect();
						//Utils.getFrameRect(this, r);
						getDrawingRect(r);
						characterBackground.setRect(r);

						characterBackground.DrawBackground(canvas);
						characterBackground.DrawText(canvas);
				}

				DrawCallingraphy(canvas);
		}

		private void touch_start(float x, float y)
		{
				mPath.moveTo(x, y);
				mX = x;
				mY = y;
		}

		private void touch_move(float x, float y)
		{
				float dx = Math.abs(x - mX);
				float dy = Math.abs(mY - y);
				if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)
				{
						mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
						mX = x;
						mY = y;
				}
		}

		private void touch_up()
		{
		}

		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
				float x = event.getX();
				float y = event.getY();
				switch (event.getAction() & MotionEvent.ACTION_MASK)
				{
						case MotionEvent.ACTION_POINTER_UP :
								break;

						case MotionEvent.ACTION_POINTER_DOWN :
								{
										distance(event);
								}
								break;

						case MotionEvent.ACTION_DOWN :
								{
										if (mPath == null)
												mPath = new Path();

										touch_start(x, y);
										invalidate();
								}
								break;
						case MotionEvent.ACTION_MOVE :
								{
										touch_move(x, y);
										invalidate();
								}
								break;
						case MotionEvent.ACTION_UP :
								{
										touch_up();
										invalidate();
								}
								break;
				}
				return true;
		}

		@SuppressLint("FloatMath")
		private float distance(MotionEvent event)
		{
				// TODO Auto-generated method stub
				float x = event.getX(0) - event.getX(1);
				float y = event.getY(0) - event.getY(1);
				return FloatMath.sqrt(x * x + y * y);
		}

		public void ClearView()
		{
				// TODO Auto-generated method stub
				mPath = null;
				mPath = new Path();
				System.gc();
				this.invalidate();
		}

		public void setCharacterBackgroundType(
						CharacterBackgroundType characterBackgroundType)
		{
				// TODO Auto-generated method stub
				mCharacterBackgroundType = characterBackgroundType;
				
				try
				{
						CharacterBackground characterBackground = CharacterBackgroundFactory
										.getCharacterBackground(mCharacterBackgroundType);
						
						ClearView();
				}
				catch (AndroidException e)
				{
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
				this.invalidate();
		}
}
