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
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class OnlineClassesActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private String app_path = "";
	
	private ScrollView vscroll3;
	private LinearLayout linear8;
	private LinearLayout linear12;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private AdView adview1;
	private AdView adview2;
	private ImageView imageview8;
	private TextView textview1;
	private ImageView imageview6;
	private TextView textview2;
	private ImageView imageview7;
	private TextView textview3;
	private ImageView imageview10;
	private TextView textview4;
	private ImageView imageview9;
	private TextView textview5;
	private ImageView imageview11;
	private TextView textview6;
	private ImageView imageview12;
	private TextView textview7;
	private ImageView imageview15;
	private TextView textview10;
	private ImageView imageview13;
	private TextView textview8;
	private ImageView imageview14;
	private TextView textview9;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private ImageView imageview16;
	private ImageView imageview17;
	private TextView textview11;
	private TextView textview12;
	private ImageView imageview18;
	private TextView textview13;
	
	private Intent page = new Intent();
	private AlertDialog.Builder dialgue1;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private SharedPreferences sp;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.online_classes);
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
		vscroll3 = (ScrollView) findViewById(R.id.vscroll3);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		adview1 = (AdView) findViewById(R.id.adview1);
		adview2 = (AdView) findViewById(R.id.adview2);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview8 = (TextView) findViewById(R.id.textview8);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		textview13 = (TextView) findViewById(R.id.textview13);
		dialgue1 = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("us.zoom.videomeetings"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://us.zoom.videomeetings"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), ZoomActivity.class);
					startActivity(page);
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
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.google.android.apps.meetings"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.google.android.apps.meetings"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), GoogleMeetActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.google.android.talk"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.google.android.talk"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), HangoutsActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.microsoft.teams"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.microsoft.teams"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), MsTeamsActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.cisco.webex.meetings"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.cisco.webex.meetings"));
					startActivity(i);
				}
				else {
					if (FileUtil.isExistFile(app_path.concat("com.cisco.wx2.android"))) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("android-app://com.cisco.wx2.android"));
						startActivity(i);
					}
					page.setClass(getApplicationContext(), CiscoActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.skype.raider"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.skype.raider"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), SkypeActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.google.android.apps.classroom"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.google.android.apps.classroom"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), GoogleClassroomActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.gotomeeting"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.gotomeeting"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), GotomeetingActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear18.setOnClickListener(new View.OnClickListener() {
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
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("org.jitsi.meet"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://org.jitsi.meet"));
					startActivity(i);
				}
				else {
					page.setClass(getApplicationContext(), JitsiMeetActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CommingSoonActivity.class);
				startActivity(i);
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
		setTitle("ONLINE CLASSES");
		linear10.setElevation(15f);
		linear11.setElevation(15f);
		linear12.setElevation(15f);
		linear13.setElevation(15f);
		linear14.setElevation(15f);
		linear15.setElevation(15f);
		linear16.setElevation(15f);
		linear17.setElevation(15f);
		linear19.setElevation(15f);
		linear20.setElevation(15f);
		android.graphics.drawable.GradientDrawable gd6 = new android.graphics.drawable.GradientDrawable();
		gd6.setColor(Color.parseColor("#ffffff"));
		gd6.setCornerRadius(50);
		gd6.setStroke(2, Color.parseColor("#e0e0e0"));
		linear18.setElevation(5f);
		linear18.setBackground(gd6);
		imageview14.setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		if (!sp.getString("checked1", "").equals("1")) {
			dialgue1.setTitle("ONLINE CLASSES");
			dialgue1.setMessage("AO CLASSES gives you a wide range of meeting platforms. You can choose any platform for online teaching. ");
			dialgue1.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			dialgue1.setNegativeButton("Ok dont show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("checked1", "1").commit();
				}
			});
			dialgue1.create().show();
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
