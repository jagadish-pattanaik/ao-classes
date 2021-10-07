package com.jaguweb.aoclasses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class TypePdfActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private String pdf_path = "";
	private String targetPdf = "";
	
	private LinearLayout linear7;
	private LinearLayout ll;
	private LinearLayout linear9;
	private EditText edittext2;
	private EditText edittext1;
	private Button button1;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private AlertDialog.Builder d;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.type_pdf);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		ll = (LinearLayout) findViewById(R.id.ll);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		button1 = (Button) findViewById(R.id.button1);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				targetPdf = FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES".concat("/".concat("PDF files"))));
				if (edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Type something");
				}
				else {
					if (edittext1.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter a file name");
					}
					else {
						if (FileUtil.isExistFile(targetPdf.concat("/".concat(edittext1.getText().toString().concat(".pdf"))))) {
							android.graphics.Bitmap bitmap = loadBitmapFromView(ll, ll.getWidth(), ll.getHeight()); createPdf(bitmap);
							finish();
						}
						else {
							FileUtil.makeDir(targetPdf.concat("/".concat(edittext1.getText().toString().concat(".pdf"))));
							android.graphics.Bitmap bitmap = loadBitmapFromView(ll, ll.getWidth(), ll.getHeight()); createPdf(bitmap);
							finish();
						}
					}
				}
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
		linear7.setElevation(15f);
		linear7.setBackground(gd7);
		if (!sp.getString("pd", "").equals("1")) {
			d.setTitle("Type Pdf");
			d.setMessage("Type your PDF , give a file name and click save.");
			d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("pd", "1").commit();
				}
			});
			d.create().show();
		}
		else {
			
		}
	} public static Bitmap loadBitmapFromView(View v, int width, int height) { android.graphics.Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); android.graphics.Canvas c = new Canvas(b); v.draw(c); return b; } private void createPdf(android.graphics.Bitmap bitmap){ WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE); DisplayMetrics displaymetrics = new DisplayMetrics(); this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics); float hight = displaymetrics.heightPixels ; float width = displaymetrics.widthPixels ; int convertHighet = (int) hight, convertWidth = (int) width; android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument(); android.graphics.pdf.PdfDocument.PageInfo pageInfo = new android.graphics.pdf.PdfDocument.PageInfo.Builder(convertWidth, convertHighet, 1).create(); android.graphics.pdf.PdfDocument.Page page = document.startPage(pageInfo); android.graphics.Canvas canvas = page.getCanvas(); android.graphics.Paint paint = new android.graphics.Paint(); canvas.drawPaint(paint); bitmap = Bitmap.createScaledBitmap(bitmap, convertWidth, convertHighet, true); paint.setColor(Color.BLUE); canvas.drawBitmap(bitmap, 0, 0 , null); document.finishPage(page); java.io.File filePath; filePath = new java.io.File(targetPdf); try { document.writeTo(new java.io.FileOutputStream(filePath)); } catch (java.io.IOException e) { e.printStackTrace(); Toast.makeText(this, "", Toast.LENGTH_LONG).show(); } document.close(); Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show();
		
		
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
