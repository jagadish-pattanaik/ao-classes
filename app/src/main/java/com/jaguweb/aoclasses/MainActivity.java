package com.jaguweb.aoclasses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ScrollView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	private String package_name = "";
	private String your_version = "";
	private String latest_version = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String Title = "";
	private String Message = "";
	private String a = "";
	private String b = "";
	private String app_path = "";
	private String dra_ver = "";
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear22;
	private LinearLayout linear21;
	private LinearLayout linear23;
	private LinearLayout linear16;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear12;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private AdView adview1;
	private AdView adview2;
	private ImageView imageview5;
	private TextView textview3;
	private ImageView imageview6;
	private TextView textview4;
	private ImageView imageview18;
	private TextView textview5;
	private ImageView imageview8;
	private TextView textview16;
	private ImageView imageview17;
	private TextView textview15;
	private ImageView imageview19;
	private TextView textview17;
	private ImageView imageview10;
	private TextView textview7;
	private ImageView imageview9;
	private TextView textview8;
	private ImageView imageview11;
	private TextView textview9;
	private ImageView imageview7;
	private TextView textview6;
	private ImageView imageview12;
	private TextView textview10;
	private ImageView imageview13;
	private TextView textview11;
	private ImageView imageview14;
	private TextView textview12;
	private ImageView imageview15;
	private TextView textview13;
	private ImageView imageview16;
	private TextView textview14;
	private LinearLayout linear24;
	private ImageView imageview20;
	private TextView textview18;
	private LinearLayout linear25;
	private ImageView imageview21;
	private TextView textview19;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear11;
	private LinearLayout _drawer_linear13;
	private LinearLayout _drawer_dr1;
	private LinearLayout _drawer_dr15;
	private LinearLayout _drawer_dr2;
	private LinearLayout _drawer_dr3;
	private LinearLayout _drawer_dr4;
	private LinearLayout _drawer_dr5;
	private LinearLayout _drawer_dr6;
	private LinearLayout _drawer_dr7;
	private LinearLayout _drawer_dr9;
	private LinearLayout _drawer_dr10;
	private LinearLayout _drawer_d14;
	private LinearLayout _drawer_dr8;
	private LinearLayout _drawer_dr13;
	private LinearLayout _drawer_dr11;
	private LinearLayout _drawer_dr12;
	private LinearLayout _drawer_linear26;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear24;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview16;
	private TextView _drawer_textview21;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview8;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview9;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview10;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview8;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview14;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview15;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview20;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview19;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview17;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview18;
	private TextView _drawer_textview16;
	private TextView _drawer_textview22;
	
	private Intent flash = new Intent();
	private Intent page = new Intent();
	private Intent dialogue = new Intent();
	private AlertDialog.Builder dialogue1;
	private DatabaseReference Ver = _firebase.getReference("Version");
	private ChildEventListener _Ver_child_listener;
	private DatabaseReference Notification = _firebase.getReference("Notification");
	private ChildEventListener _Notification_child_listener;
	private Intent intent = new Intent();
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private SharedPreferences sp;
	private TimerTask time;
	private Intent i = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private AlertDialog.Builder di;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		adview1 = (AdView) findViewById(R.id.adview1);
		adview2 = (AdView) findViewById(R.id.adview2);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview16 = (TextView) findViewById(R.id.textview16);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		textview15 = (TextView) findViewById(R.id.textview15);
		imageview19 = (ImageView) findViewById(R.id.imageview19);
		textview17 = (TextView) findViewById(R.id.textview17);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview8 = (TextView) findViewById(R.id.textview8);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview11 = (TextView) findViewById(R.id.textview11);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview13 = (TextView) findViewById(R.id.textview13);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		textview18 = (TextView) findViewById(R.id.textview18);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		imageview21 = (ImageView) findViewById(R.id.imageview21);
		textview19 = (TextView) findViewById(R.id.textview19);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear11 = (LinearLayout) _nav_view.findViewById(R.id.linear11);
		_drawer_linear13 = (LinearLayout) _nav_view.findViewById(R.id.linear13);
		_drawer_dr1 = (LinearLayout) _nav_view.findViewById(R.id.dr1);
		_drawer_dr15 = (LinearLayout) _nav_view.findViewById(R.id.dr15);
		_drawer_dr2 = (LinearLayout) _nav_view.findViewById(R.id.dr2);
		_drawer_dr3 = (LinearLayout) _nav_view.findViewById(R.id.dr3);
		_drawer_dr4 = (LinearLayout) _nav_view.findViewById(R.id.dr4);
		_drawer_dr5 = (LinearLayout) _nav_view.findViewById(R.id.dr5);
		_drawer_dr6 = (LinearLayout) _nav_view.findViewById(R.id.dr6);
		_drawer_dr7 = (LinearLayout) _nav_view.findViewById(R.id.dr7);
		_drawer_dr9 = (LinearLayout) _nav_view.findViewById(R.id.dr9);
		_drawer_dr10 = (LinearLayout) _nav_view.findViewById(R.id.dr10);
		_drawer_d14 = (LinearLayout) _nav_view.findViewById(R.id.d14);
		_drawer_dr8 = (LinearLayout) _nav_view.findViewById(R.id.dr8);
		_drawer_dr13 = (LinearLayout) _nav_view.findViewById(R.id.dr13);
		_drawer_dr11 = (LinearLayout) _nav_view.findViewById(R.id.dr11);
		_drawer_dr12 = (LinearLayout) _nav_view.findViewById(R.id.dr12);
		_drawer_linear26 = (LinearLayout) _nav_view.findViewById(R.id.linear26);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_linear24 = (LinearLayout) _nav_view.findViewById(R.id.linear24);
		_drawer_textview5 = (TextView) _nav_view.findViewById(R.id.textview5);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_textview6 = (TextView) _nav_view.findViewById(R.id.textview6);
		_drawer_imageview16 = (ImageView) _nav_view.findViewById(R.id.imageview16);
		_drawer_textview21 = (TextView) _nav_view.findViewById(R.id.textview21);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_textview8 = (TextView) _nav_view.findViewById(R.id.textview8);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_textview9 = (TextView) _nav_view.findViewById(R.id.textview9);
		_drawer_imageview6 = (ImageView) _nav_view.findViewById(R.id.imageview6);
		_drawer_textview10 = (TextView) _nav_view.findViewById(R.id.textview10);
		_drawer_imageview7 = (ImageView) _nav_view.findViewById(R.id.imageview7);
		_drawer_textview11 = (TextView) _nav_view.findViewById(R.id.textview11);
		_drawer_imageview8 = (ImageView) _nav_view.findViewById(R.id.imageview8);
		_drawer_textview12 = (TextView) _nav_view.findViewById(R.id.textview12);
		_drawer_imageview10 = (ImageView) _nav_view.findViewById(R.id.imageview10);
		_drawer_textview14 = (TextView) _nav_view.findViewById(R.id.textview14);
		_drawer_imageview11 = (ImageView) _nav_view.findViewById(R.id.imageview11);
		_drawer_textview15 = (TextView) _nav_view.findViewById(R.id.textview15);
		_drawer_imageview15 = (ImageView) _nav_view.findViewById(R.id.imageview15);
		_drawer_textview20 = (TextView) _nav_view.findViewById(R.id.textview20);
		_drawer_imageview9 = (ImageView) _nav_view.findViewById(R.id.imageview9);
		_drawer_textview13 = (TextView) _nav_view.findViewById(R.id.textview13);
		_drawer_imageview14 = (ImageView) _nav_view.findViewById(R.id.imageview14);
		_drawer_textview19 = (TextView) _nav_view.findViewById(R.id.textview19);
		_drawer_imageview12 = (ImageView) _nav_view.findViewById(R.id.imageview12);
		_drawer_textview17 = (TextView) _nav_view.findViewById(R.id.textview17);
		_drawer_imageview13 = (ImageView) _nav_view.findViewById(R.id.imageview13);
		_drawer_textview18 = (TextView) _nav_view.findViewById(R.id.textview18);
		_drawer_textview16 = (TextView) _nav_view.findViewById(R.id.textview16);
		_drawer_textview22 = (TextView) _nav_view.findViewById(R.id.textview22);
		dialogue1 = new AlertDialog.Builder(this);
		net = new RequestNetwork(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		di = new AlertDialog.Builder(this);
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					page.setClass(getApplicationContext(), OnlineClassesActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					page.setClass(getApplicationContext(), OnlineFormsActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					page.setClass(getApplicationContext(), WhiteBoardsActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), SmartClassesActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please login first to continue");
				}
			}
		});
		
		linear21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialogue1.setTitle("ATTENDANCE");
				dialogue1.setMessage("Take Attendance within minutes without any effort. Secured and automatic attendance. Coming Soon... Stay Tuned... Most probably this feature will be made available to you. Till that try other features. #stayhome #staysafe");
				dialogue1.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialogue1.create().show();
			}
		});
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), BooksBoardActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first to continue");
				}
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					page.setClass(getApplicationContext(), BoardActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					app_path = "data/data/";
					if (FileUtil.isExistFile(app_path.concat("com.google.android.calendar"))) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("android-app://com.google.android.calendar"));
						startActivity(i);
					}
					else {
						if (FileUtil.isExistFile(app_path.concat("com.google.android.apps.tasks"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.google.android.apps.tasks"));
							startActivity(i);
						}
						if (FileUtil.isExistFile(app_path.concat("com.microsoft.planner"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.microsoft.planner"));
							startActivity(i);
						}
						if (FileUtil.isExistFile(app_path.concat("com.microsoft.todos"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.microsoft.todos"));
							startActivity(i);
						}
						dialogue1.setTitle("Feature not available !");
						dialogue1.setMessage("Your device doesnt have this feature. Try installing support app to solve this problem. To know more about what to do next please read the our documentation.");
						dialogue1.setPositiveButton("Documentation", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								i.setClass(getApplicationContext(), DocumentationActivity.class);
								startActivity(i);
								Ads = new InterstitialAd(getApplicationContext());
								Ads.setAdListener(_Ads_ad_listener);
								Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
								Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
								.build());
							}
						});
						dialogue1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						
						dialogue1.create().show();
						SketchwareUtil.showMessage(getApplicationContext(), "Your device doesn't have this feature ! ");
					}
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), NotesActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					page.setClass(getApplicationContext(), FilesActivity.class);
					startActivity(page);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), ViewPdfActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					app_path = "data/data/";
					if (FileUtil.isExistFile(app_path.concat("com.adobe.scan.android"))) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("android-app://com.adobe.scan.android"));
						startActivity(i);
					}
					else {
						if (FileUtil.isExistFile(app_path.concat("com.microsoft.office.officelens"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.microsoft.office.officelens"));
							startActivity(i);
						}
						if (FileUtil.isExistFile(app_path.concat("com.cv.docscanner"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.cv.docscanner"));
							startActivity(i);
						}
						if (FileUtil.isExistFile(app_path.concat("com.intsig.camscanner"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.intsig.camscanner"));
							startActivity(i);
						}
						if (FileUtil.isExistFile(app_path.concat("com.microsoft.office.officehubrow"))) {
							i.setAction(Intent.ACTION_VIEW);
							i.setData(Uri.parse("android-app://com.microsoft.office.officehubrow"));
							startActivity(i);
						}
						i.setClass(getApplicationContext(), ScanActivity.class);
						startActivity(i);
					}
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), ConvertImgPdfActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), TypePdfActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), Edu2020Activity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
				else {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first");
				}
			}
		});
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.isExistFile(app_path.concat("in.edu.olabs.olabs"))) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://in.edu.olabs.olabs"));
					startActivity(i);
				}
				else {
					i.setClass(getApplicationContext(), OlabActivity.class);
					startActivity(i);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
				}
			}
		});
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				di.setTitle("Join or Create ?");
				di.setMessage("Do you want to join or create a quiz?");
				di.setPositiveButton("Create Quiz", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), CreateQuizActivity.class);
						startActivity(i);
						Ads = new InterstitialAd(getApplicationContext());
						Ads.setAdListener(_Ads_ad_listener);
						Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
						Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
						.build());
					}
				});
				di.setNegativeButton("Join Quiz", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), QuizzesActivity.class);
						startActivity(i);
						Ads = new InterstitialAd(getApplicationContext());
						Ads.setAdListener(_Ads_ad_listener);
						Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
						Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
						.build());
					}
				});
				di.create().show();
			}
		});
		
		_Ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				Ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map1 = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map1.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						latest_version = map1.get((int)0).get("v").toString();
						if (Double.parseDouble(latest_version) > Double.parseDouble(your_version)) {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "Update Required !");
											dialogue1.setTitle("Update Application For More Features, Speed and Security");
											dialogue1.setMessage("Latest version ".concat("v ".concat(latest_version.concat(" of this app is now available. Please update your app."))));
											dialogue1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													dialogue.setAction(Intent.ACTION_VIEW);
													dialogue.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses"));
													startActivity(dialogue);
												}
											});
											dialogue1.setNeutralButton("What's New?", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													i.setClass(getApplicationContext(), WhatsNewActivity.class);
													startActivity(i);
												}
											});
											dialogue1.setNegativeButton("Later", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please update soon");
												}
											});
											dialogue1.create().show();
										}
									});
								}
							};
							_timer.schedule(time, (int)(7000));
						}
						else {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "You are using latest version of the app");
										}
									});
								}
							};
							_timer.schedule(time, (int)(7000));
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Ver.addChildEventListener(_Ver_child_listener);
		
		_Notification_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				sp.edit().putString("notify", _childValue.get("Message").toString()).commit();
				if (!sp.getString("notify", "").equals(Message)) {
					Title = _childValue.get("Title").toString();
					Message = _childValue.get("Message").toString();
					Intent intent = new Intent(MainActivity.this, MainActivity.class);
					
					
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					
					
					PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
					
					androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(MainActivity.this, "id 1")
					
					
					.setSmallIcon(R.drawable.ic_school_white)
					
					.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
					
					.setContentTitle(Title.toString())
					
					.setContentText(Message.toString())
					
					.setOngoing(false)
					
					.setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)
					
					.setAutoCancel(false);
					
					androidx.core.app.NotificationManagerCompat notificationManager = androidx.core.app.NotificationManagerCompat.from(MainActivity.this);
					
					
					notificationManager.notify(1, builder.build());
					
					
				}
				else {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Notification.addChildEventListener(_Notification_child_listener);
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				dialogue1.setTitle("No Internet Connection");
				dialogue1.setMessage("Please check your internet connection and try again");
				dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				dialogue1.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						net.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "A", _net_request_listener);
					}
				});
				dialogue1.create().show();
			}
		};
		
		_drawer_dr1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_dr15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), DocumentationActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_dr2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutFeatureaActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_dr3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses"));
				startActivity(i);
			}
		});
		
		_drawer_dr4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				a = "AO CLASSESS - all you need for online teaching";
				b = "AO CLASSES\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nfull education bill 2020\nand many more.... download it now";
				Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
				
			}
		});
		
		_drawer_dr5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				page.setAction(Intent.ACTION_VIEW);
				page.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
				page.putExtra("subject", "Features request AO CLASSES");
				startActivity(page);
			}
		});
		
		_drawer_dr6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				page.setAction(Intent.ACTION_VIEW);
				page.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
				page.putExtra("subject", "Feedback about AO CLASSES");
				startActivity(page);
			}
		});
		
		_drawer_dr7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				page.setAction(Intent.ACTION_VIEW);
				page.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
				page.putExtra("subject", "Report problem about AO CLASSES");
				startActivity(page);
			}
		});
		
		_drawer_dr9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					SketchwareUtil.showMessage(getApplicationContext(), "You have already been logged in");
				}
				else {
					i.setClass(getApplicationContext(), LoginActivity.class);
					startActivity(i);
				}
			}
		});
		
		_drawer_dr10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					FirebaseAuth.getInstance().signOut();
					SketchwareUtil.showMessage(getApplicationContext(), "Logged out successfully");
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "You haven't logged in");
				}
			}
		});
		
		_drawer_d14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.youtube.com/channel/UCgdd03ctC4odnUCNlPBSdUg"));
				startActivity(i);
			}
		});
		
		_drawer_dr8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MoreByJaguwebActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_dr13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialogue1.setTitle("Support Web and App Policy");
				dialogue1.setMessage("Do you want to view support web policy or app policy ?");
				dialogue1.setPositiveButton("Support Apps Policy", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), SupportAppsPolicyActivity.class);
						startActivity(i);
					}
				});
				dialogue1.setNegativeButton("Support Apps policy", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), SupportWebPolicyActivity.class);
						startActivity(i);
					}
				});
				dialogue1.create().show();
			}
		});
		
		_drawer_dr11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PrivacyPolicyActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		_drawer_dr12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), TermsConditionsActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		_drawer_textview22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), UpdateInfoActivity.class);
				startActivity(i);
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
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	private void initializeLogic() {
		flash.setClass(getApplicationContext(), SplashScrActivity.class);
		startActivity(flash);
		_createChannel();
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setCornerRadius(50);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		linear9.setElevation(15f);
		linear9.setBackground(gd);
		android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
		int clr2[] = new int[]{ Color.parseColor("#4db6ac"), Color.parseColor("#009688")};
		gd2.setColors(clr2);
		gd2.setCornerRadius(50);
		gd2.setStroke(4, Color.parseColor("#009688"));
		linear10.setElevation(15f);
		linear10.setBackground(gd2);
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		linear11.setElevation(15f);
		linear11.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd4 = new android.graphics.drawable.GradientDrawable();
		int clr4[] = new int[]{ Color.parseColor("#ffb74d"), Color.parseColor("#ff9800")};
		gd4.setColors(clr4);
		gd4.setCornerRadius(50);
		gd4.setStroke(4, Color.parseColor("#ff9800"));
		linear16.setElevation(15f);
		linear16.setBackground(gd4);
		android.graphics.drawable.GradientDrawable gd5 = new android.graphics.drawable.GradientDrawable();
		int clr5[] = new int[]{ Color.parseColor("#f48fb1"), Color.parseColor("#e91e63")};
		gd5.setColors(clr5);
		gd5.setCornerRadius(50);
		gd5.setStroke(4, Color.parseColor("#e91e63"));
		linear13.setElevation(15f);
		linear13.setBackground(gd5);
		android.graphics.drawable.GradientDrawable gd6 = new android.graphics.drawable.GradientDrawable();
		int clr6[] = new int[]{ Color.parseColor("#ba68c8"), Color.parseColor("#9c27b0")};
		gd6.setColors(clr6);
		gd6.setCornerRadius(50);
		gd6.setStroke(4, Color.parseColor("#9c27b0"));
		linear14.setElevation(15f);
		linear14.setBackground(gd6);
		android.graphics.drawable.GradientDrawable gd7 = new android.graphics.drawable.GradientDrawable();
		int clr7[] = new int[]{ Color.parseColor("#4fc3f7"), Color.parseColor("#03a9f4")};
		gd7.setColors(clr7);
		gd7.setCornerRadius(50);
		gd7.setStroke(4, Color.parseColor("#03a9f4"));
		linear12.setElevation(15f);
		linear12.setBackground(gd7);
		android.graphics.drawable.GradientDrawable gd8 = new android.graphics.drawable.GradientDrawable();
		int clr8[] = new int[]{ Color.parseColor("#e57373"), Color.parseColor("#f44336")};
		gd8.setColors(clr8);
		gd8.setCornerRadius(50);
		gd8.setStroke(4, Color.parseColor("#f44336"));
		linear15.setElevation(15f);
		linear15.setBackground(gd8);
		android.graphics.drawable.GradientDrawable gd9 = new android.graphics.drawable.GradientDrawable();
		int clr9[] = new int[]{ Color.parseColor("#ff7043"), Color.parseColor("#ff5722")};
		gd9.setColors(clr9);
		gd9.setCornerRadius(50);
		gd9.setStroke(4, Color.parseColor("#ff5722"));
		linear17.setElevation(15f);
		linear17.setBackground(gd9);
		android.graphics.drawable.GradientDrawable gd10 = new android.graphics.drawable.GradientDrawable();
		int clr10[] = new int[]{ Color.parseColor("#ffca28"), Color.parseColor("#ffb300")};
		gd10.setColors(clr10);
		gd10.setCornerRadius(50);
		gd10.setStroke(4, Color.parseColor("#ffb300"));
		linear18.setElevation(15f);
		linear18.setBackground(gd10);
		android.graphics.drawable.GradientDrawable gd11 = new android.graphics.drawable.GradientDrawable();
		int clr11[] = new int[]{ Color.parseColor("#8c9eff"), Color.parseColor("#3f51b5")};
		gd11.setColors(clr11);
		gd11.setCornerRadius(50);
		gd11.setStroke(4, Color.parseColor("#3f51b5"));
		linear19.setElevation(15f);
		linear19.setBackground(gd11);
		android.graphics.drawable.GradientDrawable gd12 = new android.graphics.drawable.GradientDrawable();
		int clr12[] = new int[]{ Color.parseColor("#ff1744"), Color.parseColor("#f44336")};
		gd12.setColors(clr12);
		gd12.setCornerRadius(50);
		gd12.setStroke(4, Color.parseColor("#f44336"));
		linear20.setElevation(15f);
		linear20.setBackground(gd12);
		android.graphics.drawable.GradientDrawable gd13 = new android.graphics.drawable.GradientDrawable();
		int clr13[] = new int[]{ Color.parseColor("#00e5ff"), Color.parseColor("#18ffff")};
		gd13.setColors(clr13);
		gd13.setCornerRadius(50);
		gd13.setStroke(4, Color.parseColor("#18ffff"));
		linear21.setElevation(15f);
		linear21.setBackground(gd13);
		android.graphics.drawable.GradientDrawable gd14 = new android.graphics.drawable.GradientDrawable();
		int clr14[] = new int[]{ Color.parseColor("#cddc39"), Color.parseColor("#dce775")};
		gd14.setColors(clr14);
		gd14.setCornerRadius(50);
		gd14.setStroke(4, Color.parseColor("#cddc39"));
		linear22.setElevation(15f);
		linear22.setBackground(gd14);
		android.graphics.drawable.GradientDrawable gd15 = new android.graphics.drawable.GradientDrawable();
		int clr15[] = new int[]{ Color.parseColor("#795548"), Color.parseColor("#a1887f")};
		gd15.setColors(clr15);
		gd15.setCornerRadius(50);
		gd15.setStroke(4, Color.parseColor("#795548"));
		linear23.setElevation(15f);
		linear23.setBackground(gd15);
		android.graphics.drawable.GradientDrawable gd16 = new android.graphics.drawable.GradientDrawable();
		int clr16[] = new int[]{ Color.parseColor("#455a64"), Color.parseColor("#607d8b")};
		gd16.setColors(clr16);
		gd16.setCornerRadius(50);
		gd16.setStroke(4, Color.parseColor("#455a64"));
		linear24.setElevation(15f);
		linear24.setBackground(gd16);
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		app_path = "data/data/";
		package_name = "com.jaguweb.aoclasses";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					intent.putExtra("your ver", your_version);
					Ver.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						net.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/", "A", _net_request_listener);
					}
				});
			}
		};
		_timer.schedule(time, (int)(6000));
		dra_ver = "Version: ".concat(your_version);
		_drawer_textview22.setText(dra_ver);
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						dialogue1.setTitle("Share App\n");
						dialogue1.setMessage("Share App with your colleague and help them in online teaching.");
						dialogue1.setPositiveButton("Share with friends", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								a = "AO CLASSES - all you need for online teaching";
								b = "AO CLASSES\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nand many more.... download now";
								Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
								
							}
						});
						dialogue1.setNegativeButton("Later", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
								time = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												dialogue1.setTitle("Share App\n");
												dialogue1.setMessage("Share App with your colleague and help them in online teaching.");
												dialogue1.setPositiveButton("Share with friends", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														a = "AO CLASSES - all you need for online teaching";
														b = "AO CLASSES\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\ndownload now";
														Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
														
													}
												});
												dialogue1.setNegativeButton("Later", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
													}
												});
												dialogue1.create().show();
											}
										});
									}
								};
								_timer.schedule(time, (int)(1200000));
							}
						});
						dialogue1.create().show();
					}
				});
			}
		};
		_timer.schedule(time, (int)(600000));
		if (!sp.getString("done", "").equals("1")) {
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							dialogue1.setTitle("Enjoying ?");
							dialogue1.setMessage("Enjoying online teaching with AO CLASSESS ?");
							dialogue1.setPositiveButton("Enjoying !", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Rate Us and Share");
									dialogue1.setMessage("Would you mind rating us ?");
									dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											i.setAction(Intent.ACTION_VIEW);
											i.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses&hl=en"));
											startActivity(i);
											sp.edit().putString("done", "1").commit();
										}
									});
									dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											a = "AO CLASSES - all you need for online teaching";
											b = "AO CLASSES\ndownload from link -  ".concat("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses".concat(" Everything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nnew education bill 2020".concat("DOWNLOAD NOW")));
											Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
											
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
											time = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															dialogue1.setTitle("Rate Us and Share");
															dialogue1.setMessage("Would you mind rating us ?");
															dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	i.setAction(Intent.ACTION_VIEW);
																	i.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses&hl=en"));
																	startActivity(i);
																	sp.edit().putString("done", "1").commit();
																}
															});
															dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	a = "AO CLASSES - all you need for online teaching";
																	b = "AO CLASSS\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nDOWNLOAD NOW";
																	Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
																	
																}
															});
															dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
																}
															});
															dialogue1.create().show();
														}
													});
												}
											};
											_timer.schedule(time, (int)(600000));
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.setNegativeButton("Not really", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Report");
									dialogue1.setMessage("Not enjoying ? Report us about the problem");
									dialogue1.setPositiveButton("Report", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sp.edit().putString("done", "1").commit();
											page.setAction(Intent.ACTION_VIEW);
											page.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
											page.putExtra("subject", "Report problem about AO CLASSES");
											startActivity(page);
										}
									});
									dialogue1.setNegativeButton("Feedback", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sp.edit().putString("done", "1").commit();
											page.setAction(Intent.ACTION_VIEW);
											page.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
											page.putExtra("subject", "Feedback about AO CLASSES");
											startActivity(page);
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.create().show();
						}
					});
				}
			};
			_timer.schedule(time, (int)(500000));
		}
		else {
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							dialogue1.setTitle("Enjoying ?");
							dialogue1.setMessage("Enjoying online teaching with AO CLASSESS ?");
							dialogue1.setPositiveButton("Enjoying !", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Rate Us and Share");
									dialogue1.setMessage("Would you mind rating us ?");
									dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											i.setAction(Intent.ACTION_VIEW);
											i.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses&hl=en"));
											startActivity(i);
											sp.edit().putString("done", "1").commit();
										}
									});
									dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											a = "AO CLASSES - all you need for online teaching";
											b = "AO CLASSES\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nDOWNLOAD NOW";
											Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
											
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
											time = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															dialogue1.setTitle("Rate Us and Share");
															dialogue1.setMessage("Would you mind rating us ?");
															dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	i.setAction(Intent.ACTION_VIEW);
																	i.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses&hl=en"));
																	startActivity(i);
																	sp.edit().putString("done", "1").commit();
																}
															});
															dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	a = "AO CLASSES - all you need for online teaching";
																	b = "AO CLASSS\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nDOWNLOAD NOW";
																	Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
																	
																}
															});
															dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
																}
															});
															dialogue1.create().show();
														}
													});
												}
											};
											_timer.schedule(time, (int)(500000));
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.setNegativeButton("Not really", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									SketchwareUtil.showMessage(getApplicationContext(), "We are sorry for that");
								}
							});
							dialogue1.create().show();
						}
					});
				}
			};
			_timer.schedule(time, (int)(500000));
		}
		if (FileUtil.isExistFile(app_path.concat("com.jaguweb.isrif"))) {
			
		}
		else {
			di.setTitle("Try ISRIF by Jaguweb");
			di.setMessage("ISRIF - Indian Scientific Research And Innovation Forum\nBy Jaguweb\nGet it on Play Store now!");
			di.setPositiveButton("Install now !", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.jaguweb.isrif"));
					startActivity(i);
				}
			});
			
			di.setNegativeButton("Later", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
				}
			});
			di.create().show();
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
	
	@Override
	public void onBackPressed() {
		Ads = new InterstitialAd(getApplicationContext());
		Ads.setAdListener(_Ads_ad_listener);
		Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
		Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						dialogue1.setTitle("QUIT APPLICATION ?");
						dialogue1.setMessage("Do you really want to quit the application ?");
						dialogue1.setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "GOOD BYE SEE YOU SOON !");
								finish();
							}
						});
						dialogue1.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "WELCOME BACK !");
							}
						});
						dialogue1.setNeutralButton("SHARE APP", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								a = "AO CLASSES - all you need for online teaching";
								b = "AO CLASSES\ndownload from link - https://play.google.com/work/apps/details?id=com.jaguweb.aoclasses\nEverything you need for online teaching is here\nall meeting apps\nall forms apps\nscanning \npdf creator\nimage to pdf converter\npdf viewer\nclass planner \nnotes to set reminder\nquestions bank\nand many more.... download now";
								Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
								
							}
						});
						dialogue1.create().show();
					}
				});
			}
		};
		_timer.schedule(time, (int)(3000));
	}
	private void _createChannel () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			CharSequence name = "AO CLASSESS";
			String description = "Notification by AO CLASSESS";
			int importance = NotificationManager.IMPORTANCE_DEFAULT;
			NotificationChannel channel = new NotificationChannel("id 1", name, importance);
			channel.setDescription(description);
			
			NotificationManager notificationManager = getSystemService(NotificationManager.class);
			notificationManager.createNotificationChannel(channel);
			
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
