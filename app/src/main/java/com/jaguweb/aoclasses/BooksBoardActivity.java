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
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;

public class BooksBoardActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private AdView adview1;
	private AdView adview2;
	private AdView adview3;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private AlertDialog.Builder d;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.books_board);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
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
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		adview1 = (AdView) findViewById(R.id.adview1);
		adview2 = (AdView) findViewById(R.id.adview2);
		adview3 = (AdView) findViewById(R.id.adview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CbseBooksActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), IcseBooksActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), DavBooksActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		_Ads_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				Ads.show();
				Ads.loadAd(new
				AdRequest.Builder().build());
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
		setTitle("School Books");
		android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
		int clr2[] = new int[]{ Color.parseColor("#4db6ac"), Color.parseColor("#009688")};
		gd2.setColors(clr2);
		gd2.setCornerRadius(50);
		gd2.setStroke(4, Color.parseColor("#009688"));
		linear2.setElevation(15f);
		linear2.setBackground(gd2);
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		linear3.setElevation(15f);
		linear3.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd4 = new android.graphics.drawable.GradientDrawable();
		int clr4[] = new int[]{ Color.parseColor("#ffb74d"), Color.parseColor("#ff9800")};
		gd4.setColors(clr4);
		gd4.setCornerRadius(50);
		gd4.setStroke(4, Color.parseColor("#ff9800"));
		linear4.setElevation(15f);
		linear4.setBackground(gd4);
		if (!sp.getString("bb", "").equals("1")) {
			d.setTitle("School Books");
			d.setMessage("Choose your board then class to access the books");
			d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("bb", "1").commit();
				}
			});
			d.create().show();
		}
		else {
			
		}
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview3.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
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
