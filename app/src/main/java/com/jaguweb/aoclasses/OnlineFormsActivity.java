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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class OnlineFormsActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private String app_path = "";
	
	private ScrollView vscroll2;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private AdView adview1;
	private AdView adview2;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview10;
	private TextView textview10;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview5;
	private TextView textview4;
	private ImageView imageview4;
	private TextView textview5;
	private ImageView imageview7;
	private TextView textview6;
	private ImageView imageview6;
	private TextView textview7;
	private ImageView imageview8;
	private TextView textview8;
	private ImageView imageview9;
	private TextView textview9;
	
	private AlertDialog.Builder dialog1;
	private Intent pg = new Intent();
	private SharedPreferences sp;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.online_forms);
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
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		adview1 = (AdView) findViewById(R.id.adview1);
		adview2 = (AdView) findViewById(R.id.adview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview8 = (TextView) findViewById(R.id.textview8);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview9 = (TextView) findViewById(R.id.textview9);
		dialog1 = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), GoogleFormsActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), MsFormsActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), WufooActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.jotform.v2"))) {
					
					
					
				}
				else {
					pg.setClass(getApplicationContext(), JotformsActivity.class);
					startActivity(pg);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.formstack.android"))) {
					
					
					
				}
				else {
					pg.setClass(getApplicationContext(), FormstackActivity.class);
					startActivity(pg);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), TypeformActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), PaperformsActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pg.setClass(getApplicationContext(), FormsiteActivity.class);
				startActivity(pg);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AppsWebsPolicyActivity.class);
				startActivity(i);
			}
		});
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), RecommendedActivity.class);
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
		setTitle("ONLINE FORMS");
		linear12.setElevation(15f);
		linear11.setElevation(15f);
		linear10.setElevation(15f);
		linear9.setElevation(15f);
		linear8.setElevation(15f);
		linear7.setElevation(15f);
		linear6.setElevation(15f);
		linear5.setElevation(15f);
		android.graphics.drawable.GradientDrawable gd6 = new android.graphics.drawable.GradientDrawable();
		gd6.setColor(Color.parseColor("#ffffff"));
		gd6.setCornerRadius(50);
		gd6.setStroke(2, Color.parseColor("#e0e0e0"));
		linear13.setElevation(5f);
		linear13.setBackground(gd6);
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		imageview9.setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
		if (!sp.getString("checked2", "").equals("1")) {
			dialog1.setTitle("ONLINE FORMS");
			dialog1.setMessage("AO CLASSES gives you a wide range of online forms. You can choose any form and start making your online question paper. ");
			dialog1.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			dialog1.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("checked2", "1").commit();
				}
			});
			dialog1.create().show();
		}
		else {
			
		}
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
