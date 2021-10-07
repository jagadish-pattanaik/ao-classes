package com.jaguweb.aoclasses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class ViewPdfActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE_PICKER = 101;
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	private double page = 0;
	private double pageCount = 0;
	private String pdfFile = "";
	
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private Button button1;
	private EditText edittext1;
	private TextView textview4;
	private TextView textview3;
	private TextView textview1;
	private TextView textview2;
	
	private Intent file_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	private Intent i = new Intent();
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view_pdf);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		button1 = (Button) findViewById(R.id.button1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		file_picker.setType("application/pdf");
		file_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (renderer != null){
					
					renderer.close(); }
				
				
				startActivityForResult(file_picker, REQ_CD_FILE_PICKER);
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().equals("")) {
					if ((Double.parseDouble(edittext1.getText().toString()) > 0) && (Double.parseDouble(edittext1.getText().toString()) < (1 + pageCount))) {
						page = Double.parseDouble(edittext1.getText().toString()) - 1;
						_display(page);
					}
				}
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pageCount > 0) {
					page--;
					_display(page);
				}
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (page > (pageCount - 1)) {
					page++;
					_display(page);
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Scan or Type or Convert Image");
				d.setMessage("Do you want to Scan or Type PDF or Convert Image to PDF ?");
				d.setPositiveButton("Scan", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.setNegativeButton("Type PDF", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
						startActivity(i);
						Ads = new InterstitialAd(getApplicationContext());
						Ads.setAdListener(_Ads_ad_listener);
						Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
						Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
						.build());
					}
				});
				d.setNeutralButton("Convert Images", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), ConvertImgPdfActivity.class);
						startActivity(i);
						Ads = new InterstitialAd(getApplicationContext());
						Ads.setAdListener(_Ads_ad_listener);
						Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
						Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
						.build());
					}
				});
				d.create().show();
			}
		});
		
		_Ads_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				
			}
			
			@Override
			public void onAdFailedToLoad(int _param1) {
				final int _errorCode = _param1;
				
			}
			
			@Override
			public void onAdOpened() {
				
			}
			
			@Override
			public void onAdClosed() {
				
			}
		};
	}
	private void initializeLogic() {
		touch = new ZoomableImageView(this);
		
		linear3.addView(touch);
		
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setCornerRadius(50);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		button1.setElevation(15f);
		button1.setBackground(gd);
		android.graphics.drawable.GradientDrawable gd7 = new android.graphics.drawable.GradientDrawable();
		int clr7[] = new int[]{ Color.parseColor("#4fc3f7"), Color.parseColor("#03a9f4")};
		gd7.setColors(clr7);
		gd7.setStroke(4, Color.parseColor("#03a9f4"));
		linear1.setElevation(15f);
		linear1.setBackground(gd7);
		if (!sp.getString("c2", "").equals("1")) {
			d.setTitle("PDF Viewer");
			d.setMessage("View your PDF files here");
			d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("c2", "1").commit();
				}
			});
			d.create().show();
		}
		else {
			
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILE_PICKER:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				pdfFile = _filePath.get((int)(0));
				page = 0;
				try {
					
					renderer = new android.graphics.pdf.PdfRenderer(new ParcelFileDescriptor(ParcelFileDescriptor.open(new java.io.File(pdfFile), ParcelFileDescriptor.MODE_READ_ONLY)));
					
					
					
					pageCount = renderer.getPageCount();
					
					
					
					_display(page);
					textview4.setText("/".concat(String.valueOf((long)(pageCount))));
				} catch (Exception e){ }
				
				
				
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	private void _display (final double _i) {
		android.graphics.pdf.PdfRenderer.Page page = renderer.openPage((int)_i);
		
		Bitmap mBitmap = Bitmap.createBitmap((int)getDip(page.getWidth()), (int)getDip(page.getHeight()), Bitmap.Config.ARGB_8888);
		
		page.render(mBitmap, null, null, android.graphics.pdf.PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
		
		touch.setImageBitmap(mBitmap);
		
		page.close();
		
		
		edittext1.setText(String.valueOf((long)(_i + 1)));
	}
	
	
	private void _extra () {
	} private android.graphics.pdf.PdfRenderer renderer;
	
	ZoomableImageView touch;
	
	
	public class ZoomableImageView extends ImageView {
		
		
		Matrix matrix = new Matrix();
		
		static final int NONE = 0;
		
		static final int DRAG = 1;
		
		static final int ZOOM = 2;
		
		static final int CLICK = 3;
		
		int mode = NONE;
		
		PointF last = new PointF();
		
		PointF start = new PointF();
		
		float minScale = 1f;
		
		float maxScale = 4f;
		
		float[] m;
		
		float redundantXSpace, redundantYSpace;
		
		float width, height;
		
		float saveScale = 1f;
		
		float right, bottom, origWidth, origHeight, bmWidth, bmHeight;
		
		ScaleGestureDetector mScaleDetector;
		
		Context context;
		
		
		public ZoomableImageView(Context context) {
			
			super(context);
			
			super.setClickable(true);
			
			this.context = context;
			
			mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
			
			matrix.setTranslate(1f, 1f);
			
			m = new float[9];
			
			setImageMatrix(matrix); setScaleType(ScaleType.MATRIX);
			
			
			setOnTouchListener(new OnTouchListener() {
				
				@Override
				
				public boolean onTouch(View v, MotionEvent event) {
					
					mScaleDetector.onTouchEvent(event);
					
					matrix.getValues(m);
					
					float x = m[Matrix.MTRANS_X];
					
					float y = m[Matrix.MTRANS_Y];
					
					PointF curr = new PointF(event.getX(), event.getY());
					
					switch (event.getAction()) {
						
						case MotionEvent.ACTION_DOWN: last.set(event.getX(), event.getY()); start.set(last); mode = DRAG;
						
						break;
						
						case MotionEvent.ACTION_POINTER_DOWN: last.set(event.getX(), event.getY()); start.set(last);
						
						mode = ZOOM;
						
						break;
						
						case MotionEvent.ACTION_MOVE:
						
						if (mode == ZOOM || (mode == DRAG && saveScale > minScale)) {
							
							float deltaX = curr.x - last.x;
							
							float deltaY = curr.y - last.y;
							
							float scaleWidth = Math.round(origWidth * saveScale);
							
							float scaleHeight = Math.round(origHeight * saveScale);
							
							if (scaleWidth < width) {
								
								deltaX = 0;
								
								if (y + deltaY > 0) deltaY = -y;
								
								else if (y + deltaY < -bottom) deltaY = -(y + bottom);
								
							} else if (scaleHeight < height) {
								
								deltaY = 0;
								
								if (x + deltaX > 0) deltaX = -x;
								
								else if (x + deltaX < -right) deltaX = -(x + right);
								
							} else {
								
								if (x + deltaX > 0) deltaX = -x;
								
								else if (x + deltaX < -right) deltaX = -(x + right);
								
								if (y + deltaY > 0) deltaY = -y;
								
								else if (y + deltaY < -bottom) deltaY = -(y + bottom);
								
							}
							
							matrix.postTranslate(deltaX, deltaY);
							
							last.set(curr.x, curr.y);
							
						}
						
						break;
						
						case MotionEvent.ACTION_UP:
						
						mode = NONE;
						
						int xDiff = (int) Math.abs(curr.x - start.x);
						
						int yDiff = (int) Math.abs(curr.y - start.y);
						
						if (xDiff < CLICK && yDiff < CLICK) performClick();
						
						break;
						
						case MotionEvent.ACTION_POINTER_UP:
						
						mode = NONE;
						
						break;
						
					}
					
					setImageMatrix(matrix);
					
					invalidate();
					
					return true;
					
				}
				
			});
			
		}
		
		
		@Override
		
		public void setImageBitmap(Bitmap bm) {
			
			super.setImageBitmap(bm);
			
			bmWidth = bm.getWidth();
			
			bmHeight = bm.getHeight(); }
		
		
		public void setMaxZoom(float x) {
			
			maxScale = x; }
		
		
		private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
			
			@Override
			
			public boolean onScaleBegin(ScaleGestureDetector detector) {
				
				mode = ZOOM;
				
				return true;}
			
			@Override
			
			public boolean onScale(ScaleGestureDetector detector) {
				
				float mScaleFactor = detector.getScaleFactor();
				
				float origScale = saveScale;
				
				saveScale *= mScaleFactor;
				
				if (saveScale > maxScale){
					
					saveScale = maxScale;
					
					mScaleFactor = maxScale / origScale;
					
				} else if (saveScale < minScale) {
					
					saveScale = minScale;
					
					mScaleFactor = minScale / origScale;}
				
				right = width * saveScale - width - (2 * redundantXSpace * saveScale);
				
				bottom = height * saveScale - height - (2 * redundantYSpace * saveScale);
				
				if (origWidth * saveScale <= width || origHeight * saveScale <= height) {
					
					matrix.postScale(mScaleFactor, mScaleFactor, width / 2, height / 2);
					
					if (mScaleFactor < 1) {
						
						matrix.getValues(m);
						
						float x = m[Matrix.MTRANS_X];
						
						float y = m[Matrix.MTRANS_Y];
						
						if (mScaleFactor < 1) {
							
							if (Math.round(origWidth * saveScale) < width) {
								
								if (y < -bottom) matrix.postTranslate(0, -(y + bottom));
								
								else if (y > 0) matrix.postTranslate(0, -y);
								
							} else {
								
								if (x < -right) matrix.postTranslate(-(x + right), 0);
								
								else if (x > 0) matrix.postTranslate(-x, 0);}
							
						}
						
					}
					
				} else {
					
					matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY()); matrix.getValues(m);
					
					float x = m[Matrix.MTRANS_X];
					
					float y = m[Matrix.MTRANS_Y];
					
					if (mScaleFactor < 1) {
						
						if (x < -right) matrix.postTranslate(-(x + right), 0);
						
						else if (x > 0) matrix.postTranslate(-x, 0);
						
						if (y < -bottom) matrix.postTranslate(0, -(y + bottom));
						
						else if (y > 0) matrix.postTranslate(0, -y);}
					
				}
				
				return true;
				
			}
			
		}
		
		
		@Override
		
		protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
			
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			
			width = MeasureSpec.getSize(widthMeasureSpec);
			
			height = MeasureSpec.getSize(heightMeasureSpec);
			
			float scale;
			
			float scaleX = width / bmWidth;
			
			float scaleY = height / bmHeight;
			
			scale = Math.min(scaleX, scaleY); matrix.setScale(scale, scale); setImageMatrix(matrix);
			
			saveScale = 1f;
			
			redundantYSpace = height - (scale * bmHeight) ;
			
			redundantXSpace = width - (scale * bmWidth);
			
			redundantYSpace /= 2;
			
			redundantXSpace /= 2; matrix.postTranslate(redundantXSpace, redundantYSpace);
			
			origWidth = width - 2 * redundantXSpace;
			
			origHeight = height - 2 * redundantYSpace;
			
			right = width * saveScale - width - (2 * redundantXSpace * saveScale);
			
			bottom = height * saveScale - height - (2 * redundantYSpace * saveScale); setImageMatrix(matrix);}
		
	}
	
	
	{
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
