package com.applee.MyCalligraphy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
/**
 *
 * @category: View瀹炵幇娑傞甫銆佹挙閿�互鍙婇噸鍋氬姛鑳� * @author: 閿嬬�? * @link: www.apkstory.com
 * @date: 2012.1.4
 *
 */
public class TuyaView extends View {
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Path mPath;
	private Paint mBitmapPaint;// 鐢诲竷鐨勭敾绗�	
	private Paint mPaint;// 鐪熷疄鐨勭敾绗�	
	private float mX, mY;// 涓存椂鐐瑰潗鏍�	
	private static final float TOUCH_TOLERANCE = 4;
// 淇濆瓨Path璺緞鐨勯泦鍚�鐢↙ist闆嗗悎鏉ユā鎷熸爤
	private static List<DrawPath> savePath;
// 璁板綍Path璺緞鐨勫璞�	
	private DrawPath dp;
	private int screenWidth, screenHeight;// 灞忓箷闀峰
	private class DrawPath {
		public Path path;// 璺�?		
		public Paint paint;// 鐢荤�?
	}
	
	public TuyaView(Context context, int w, int h) {
		super(context);
		screenWidth = w;
		screenHeight = h;
		mBitmap = Bitmap.createBitmap(screenWidth, screenHeight,
			Bitmap.Config.ARGB_8888);
			
		// 淇濆瓨涓�涓�缁樺埗鍑烘潵鐨勫浘褰�		
		mCanvas = new Canvas(mBitmap);
		mBitmapPaint = new Paint(Paint.DITHER_FLAG);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);// 璁剧疆澶栬竟缂�
		mPaint.setStrokeCap(Paint.Cap.SQUARE);// 褰㈢�?		mPaint.setStrokeWidth(5);// 鐢荤瑪�?藉害
		savePath = new ArrayList<DrawPath>();
	}
	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(0xFFAAAAAA);
		// 灏嗗墠闈㈠凡缁忕敾杩囧緱鏄剧ず鍑烘潵
		canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
		if (mPath != null) {
			// 瀹炴椂鐨勬樉�?��			
				canvas.drawPath(mPath, mPaint);
		}
	}
	private void touch_start(float x, float y) {
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
	}
	private void touch_move(float x, float y) {
		float dx = Math.abs(x - mX);
		float dy = Math.abs(mY - y);
		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
			// 浠巟1,y1鍒皒2,y2鐢讳竴鏉¤礉濉炲皵鏇茬嚎锛屾洿骞虫�?鐩存帴鐢╩Path.lineTo涔熸槸鍙互鐨�
			mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
			mX = x;
			mY = y;
	    }
	}
	private void touch_up() {
		mPath.lineTo(mX, mY);
	    mCanvas.drawPath(mPath, mPaint);
		//灏嗕竴鏉″畬鏁寸殑璺緞淇濆瓨涓嬫潵(鐩稿綋浜庡叆鏍堟搷浣�?		savePath.add(dp);
		mPath = null;// 閲嶆柊缃┖
	}
	/**
	 �?* 鎾ら攢鐨勬牳蹇冩�鎯冲氨鏄皢鐢诲竷娓呯┖锛�? �?* 灏嗕繚�?樹笅鏉ョ殑Path璺緞鏈�悗涓�釜绉婚櫎鎺夛�?	 �?* 閲嶆柊灏嗚矾寰勭敾鍦ㄧ敾甯冧笂闈�
	 �?*/
	public void undo() {
		mBitmap = Bitmap.createBitmap(screenWidth, screenHeight,
			Bitmap.Config.ARGB_8888);
			
		mCanvas.setBitmap(mBitmap);// 閲嶆柊璁剧疆鐢诲竷锛�?��褰撲簬娓呯┖鐢诲�?		// 娓呯┖鐢诲竷锛屼絾鏄鏋滃浘鐗囨湁鑳屾櫙鐨勮瘽锛屽垯浣跨敤涓婇潰鐨勯噸鏂板垵濮嬪寲鐨勬柟娉曪紝鐢ㄨ鏂规硶浼氬皢鑳屾櫙娓呯┖鎺�?.
		if (savePath != null && savePath.size() > 0) {
			// 绉婚櫎鏈�悗涓�釜path,鐩稿綋浜庡嚭鏍堟搷浣�?	
				savePath.remove(savePath.size() - 1);
			Iterator<DrawPath> iter = savePath.iterator();
			while (iter.hasNext()) {
				DrawPath drawPath = iter.next();
				mCanvas.drawPath(drawPath.path, drawPath.paint);
			}
			invalidate();// 鍒锋�?			
			/*鍦ㄨ繖閲屼繚瀛樺浘鐗囩函绮规槸涓轰簡鏂�?�?淇濆瓨鍥剧墖杩涜楠岃瘉*/
			String fileUrl = Environment.getExternalStorageDirectory()
			    .toString() + "/android/data/test.png";
			try {
				FileOutputStream fos = new FileOutputStream(new File(fileUrl));
				mBitmap.compress(CompressFormat.PNG, 100, fos);
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 �?* 閲嶅仛鐨勬牳蹇冩�鎯冲氨鏄皢鎾ら攢鐨勮矾寰勪繚瀛樺埌鍙�?��涓�釜闆嗗悎閲岄�?鏍�锛�	 �?* 鐒跺悗浠巖edo鐨勯泦鍚堥噷闈㈠彇鍑烘渶椤剁�?硅薄锛�	 �?* 鐢诲湪鐢诲竷涓婇潰鍗冲彲銆�	 �?*/
	public void redo(){
		//濡傛灉鎾ら攢浣犳噦浜嗙殑璇濓紝閭ｅ氨璇曡瘯閲嶅仛鍚с�
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				// 姣忔down涓嬪幓閲嶆柊new涓�釜Path
				mPath = new Path();
				//姣忎竴娆¤褰曠殑璺緞�?硅薄鏄笉涓�牱鐨�		
				dp = new DrawPath();
				dp.path = mPath;
				dp.paint = mPaint;
				touch_start(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_MOVE:
			    touch_move(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_UP:
				touch_up();
				invalidate();
				break;
		}
		return true;
	}
}

