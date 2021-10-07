package com.jaguweb.aoclasses;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;

public class AoWhiteboardActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout s10;
	private LinearLayout s20;
	private LinearLayout s30;
	private LinearLayout s40;
	private LinearLayout s50;
	private LinearLayout s60;
	private LinearLayout s70;
	private LinearLayout s80;
	private LinearLayout linear21;
	private LinearLayout black;
	private LinearLayout red;
	private LinearLayout yellow;
	private LinearLayout green;
	private LinearLayout blue;
	private LinearLayout linear9;
	private LinearLayout brush;
	private LinearLayout rubber;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ao_whiteboard);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		s10 = (LinearLayout) findViewById(R.id.s10);
		s20 = (LinearLayout) findViewById(R.id.s20);
		s30 = (LinearLayout) findViewById(R.id.s30);
		s40 = (LinearLayout) findViewById(R.id.s40);
		s50 = (LinearLayout) findViewById(R.id.s50);
		s60 = (LinearLayout) findViewById(R.id.s60);
		s70 = (LinearLayout) findViewById(R.id.s70);
		s80 = (LinearLayout) findViewById(R.id.s80);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		black = (LinearLayout) findViewById(R.id.black);
		red = (LinearLayout) findViewById(R.id.red);
		yellow = (LinearLayout) findViewById(R.id.yellow);
		green = (LinearLayout) findViewById(R.id.green);
		blue = (LinearLayout) findViewById(R.id.blue);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		brush = (LinearLayout) findViewById(R.id.brush);
		rubber = (LinearLayout) findViewById(R.id.rubber);
	}
	private void initializeLogic() {
		dv = new DrawingView(this);linear2.addView(dv); mPaint = new Paint(); mPaint.setAntiAlias(true); mPaint.setDither(true); mPaint.setStyle(Paint.Style.STROKE); mPaint.setStrokeJoin(Paint.Join.ROUND); mPaint.setStrokeCap(Paint.Cap.ROUND); mPaint.setStrokeWidth(40); } DrawingView dv; private Paint mPaint; private Canvas mCanvas; public class DrawingView extends View { public int width; public int height; private Bitmap mBitmap; private Path mPath; private Paint mBitmapPaint; Context context; private Paint circlePaint; private Path circlePath; public DrawingView(Context c) { super(c); context=c; mPath = new Path(); mBitmapPaint = new Paint(Paint.DITHER_FLAG); circlePaint = new Paint(); circlePath = new Path(); circlePaint.setAntiAlias(true); circlePaint.setColor(Color.BLUE); circlePaint.setStyle(Paint.Style.STROKE); circlePaint.setStrokeJoin(Paint.Join.MITER); circlePaint.setStrokeWidth(4f); } @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) { super.onSizeChanged(w, h, oldw, oldh); mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888); mCanvas = new Canvas(mBitmap); } @Override protected void onDraw(Canvas canvas) { super.onDraw(canvas); canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint); canvas.drawPath( mPath, mPaint); canvas.drawPath( circlePath, circlePaint); invalidate(); } private float mX, mY; private static final float TOUCH_TOLERANCE = 4; private void touch_start(float x, float y) { mPath.reset(); mPath.moveTo(x, y); mX = x; mY = y; } private void touch_move(float x, float y) { float dx = Math.abs(x - mX); float dy = Math.abs(y - mY); if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) { mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2); mX = x; mY = y; circlePath.reset(); circlePath.addCircle(mX, mY, 30, Path.Direction.CW); } } private void touch_up() { mPath.lineTo(mX, mY); circlePath.reset(); mCanvas.drawPath(mPath, mPaint); mPath.reset(); } @Override public boolean onTouchEvent(MotionEvent event) { float x = event.getX(); float y = event.getY(); switch (event.getAction()) { case MotionEvent.ACTION_DOWN: touch_start(x, y); invalidate(); break; case MotionEvent.ACTION_MOVE: touch_move(x, y); invalidate(); break; case MotionEvent.ACTION_UP: touch_up(); invalidate(); break; } return true; } } private void storeImage(Bitmap image) { java.io.File pictureFile = new java.io.File(getExternalCacheDir() + "/image.jpg"); if (pictureFile == null) { Log.d("MainActivity", "Error creating media file, check storage permissions: "); return; } try { java.io.FileOutputStream fos = new java.io.FileOutputStream(pictureFile); image.compress(Bitmap.CompressFormat.PNG, 90, fos); fos.close(); } catch (java.io.FileNotFoundException e) { Log.d("MainActivity", "File not found: " + e.getMessage()); } catch (java.io.IOException e) { Log.d("MainActivity", "Error accessing file: " + e.getMessage()); } Intent iten = new Intent(android.content.Intent.ACTION_SEND); iten.setType("*/*"); iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(getExternalCacheDir() + "/image.jpg"))); startActivity(Intent.createChooser(iten, "Send image")); } private Bitmap getBitmapFromView(View view) { Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(returnedBitmap); android.graphics.drawable.Drawable bgDrawable =view.getBackground(); if (bgDrawable!=null) { bgDrawable.draw(canvas); } else{ canvas.drawColor(Color.WHITE); } view.draw(canvas); return returnedBitmap;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
