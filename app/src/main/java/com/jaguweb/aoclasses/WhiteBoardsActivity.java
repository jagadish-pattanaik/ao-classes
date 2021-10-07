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
import android.widget.TextView;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class WhiteBoardsActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private String app_path = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear17;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private AdView adview1;
	private AdView adview2;
	private TextView textview16;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	private ImageView imageview2;
	private TextView textview17;
	private TextView textview10;
	private TextView textview11;
	private TextView textview13;
	private TextView textview12;
	private TextView textview14;
	private ImageView imageview1;
	private TextView textview15;
	private ImageView imageview3;
	private TextView textview18;
	
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.white_boards);
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
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		adview1 = (AdView) findViewById(R.id.adview1);
		adview2 = (AdView) findViewById(R.id.adview2);
		textview16 = (TextView) findViewById(R.id.textview16);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview17 = (TextView) findViewById(R.id.textview17);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview14 = (TextView) findViewById(R.id.textview14);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview15 = (TextView) findViewById(R.id.textview15);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview18 = (TextView) findViewById(R.id.textview18);
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Comming Soon...");
				d.setMessage("AO Board developed by Jaguweb with lot of features will be made available soon for free on AO CLASSES app.");
				d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.setNegativeButton("More Info", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), ReleaseMoreInfoActivity.class);
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
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.google.android.apps.jam"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.google.android.apps.jam"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), JamboradActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.inconceptlabs.liveboard"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.inconceptlabs.liveboard"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), LiveboardActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AwwActivity.class);
				startActivity(i);
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
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.realtimeboard"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.realtimeboard"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), MiroActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.stormboard.mobile"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.stormboard.mobile"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), StormboardActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.ipevo.whiteboard"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.ipevo.whiteboard"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), AnnotatorActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("com.sketchboard.impex"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.sketchboard.impex"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), SketchboardActivity.class);
					startActivity(i);
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
				i.setClass(getApplicationContext(), ConceptboardActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BoardFoxActivity.class);
				startActivity(i);
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
				i.setClass(getApplicationContext(), LimnuActivity.class);
				startActivity(i);
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
				i.setClass(getApplicationContext(), MuralActivity.class);
				startActivity(i);
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
				app_path = "data/data/";
				if (FileUtil.isExistFile(app_path.concat("ziteboard.online.whiteboard.collaborating"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://ziteboard.online.whiteboard.collaborating"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), WhiteBoardActivity.class);
					startActivity(i);
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
				if (FileUtil.isExistFile(app_path.concat("com.explaineverything.explaineverything"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.explaineverything.explaineverything"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), ExplaineverythingActivity.class);
					startActivity(i);
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
				i.setClass(getApplicationContext(), FreehandActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AppsWebsPolicyActivity.class);
				startActivity(i);
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
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
		
		textview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CommingSoonActivity.class);
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
		setTitle("Whiteboards");
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		linear2.setElevation(15f);
		linear2.setBackground(gd3);
		linear3.setElevation(15f);
		linear3.setBackground(gd3);
		linear4.setElevation(15f);
		linear4.setBackground(gd3);
		linear5.setElevation(15f);
		linear5.setBackground(gd3);
		linear6.setElevation(15f);
		linear6.setBackground(gd3);
		linear7.setElevation(15f);
		linear7.setBackground(gd3);
		linear8.setElevation(15f);
		linear8.setBackground(gd3);
		linear9.setElevation(15f);
		linear9.setBackground(gd3);
		linear10.setElevation(15f);
		linear10.setBackground(gd3);
		linear11.setElevation(15f);
		linear11.setBackground(gd3);
		linear12.setElevation(15f);
		linear12.setBackground(gd3);
		linear13.setElevation(15f);
		linear13.setBackground(gd3);
		linear14.setElevation(15f);
		linear14.setBackground(gd3);
		linear15.setElevation(15f);
		linear15.setBackground(gd3);
		linear16.setElevation(15f);
		linear16.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd6 = new android.graphics.drawable.GradientDrawable();
		gd6.setColor(Color.parseColor("#ffffff"));
		gd6.setCornerRadius(50);
		gd6.setStroke(2, Color.parseColor("#e0e0e0"));
		linear16.setElevation(5f);
		linear16.setBackground(gd6);
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		imageview1.setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
		if (!sp.getString("checked", "").equals("1")) {
			d.setTitle("Whiteboards");
			d.setMessage("Teach better with whiteboards. Choose any whiteboard you like and start teaching.");
			d.setPositiveButton("I understood", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("checked", "1").commit();
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
