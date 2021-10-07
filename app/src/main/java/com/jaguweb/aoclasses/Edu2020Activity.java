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
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;

public class Edu2020Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private String download_url = "";
	private String file_path = "";
	private String path = "";
	
	private AdView adview1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ProgressBar progressbar1;
	private LinearLayout linear4;
	private AdView adview2;
	private TextView textview2;
	private ImageView imageview1;
	private TextView textview3;
	private TextView textview4;
	
	private Intent i = new Intent();
	private TimerTask t;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edu2020);
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
		adview1 = (AdView) findViewById(R.id.adview1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		adview2 = (AdView) findViewById(R.id.adview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		auth = FirebaseAuth.getInstance();
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					download_url = "https://firebasestorage.googleapis.com/v0/b/ao-classes-27b3d.appspot.com/o/%F0%9F%8E%93NEW%20EDUCATION%20POLICY%202020%20FULL%F0%9F%8E%93.pdf?alt=media&token=f587fc2e-947a-419a-a441-4801be24324e";
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse(download_url));
					startActivity(i);
					progressbar1.setVisibility(View.VISIBLE);
					textview4.setVisibility(View.VISIBLE);
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									progressbar1.setVisibility(View.GONE);
									textview4.setVisibility(View.GONE);
									SketchwareUtil.showMessage(getApplicationContext(), "Downloaded successfully");
									finish();
								}
							});
						}
					};
					_timer.schedule(t, (int)(2000));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Please Login first to download");
				}
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
		setTitle("Education bill 2020");
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setCornerRadius(50);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		linear3.setElevation(15f);
		linear3.setBackground(gd);
		android.graphics.drawable.GradientDrawable gd5 = new android.graphics.drawable.GradientDrawable();
		int clr5[] = new int[]{ Color.parseColor("#f48fb1"), Color.parseColor("#e91e63")};
		gd5.setColors(clr5);
		gd5.setStroke(4, Color.parseColor("#e91e63"));
		linear2.setElevation(15f);
		linear2.setBackground(gd5);
		adview2.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		adview1.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
		.build());
		progressbar1.setVisibility(View.GONE);
		textview4.setVisibility(View.GONE);
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
