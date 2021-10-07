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
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.app.Activity;
import android.content.SharedPreferences;

public class SplashPageActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private ImageView imageview2;
	
	private TimerTask timer;
	private Intent page = new Intent();
	private ObjectAnimator anime = new ObjectAnimator();
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash_page);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		sp = getSharedPreferences("first_time", Activity.MODE_PRIVATE);
	}
	private void initializeLogic() {
		SketchwareUtil.showMessage(getApplicationContext(), "All you need for Online teaching...");
		anime.setTarget(imageview2);
		anime.setPropertyName("alpha");
		anime.setFloatValues((float)(0), (float)(1));
		anime.setDuration((int)(1000));
		anime.start();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (sp.getString("first_time", "").equals("done")) {
							anime.setTarget(imageview2);
							anime.setPropertyName("alpha");
							anime.setFloatValues((float)(1), (float)(0));
							anime.setDuration((int)(1000));
							anime.start();
							timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											page.setClass(getApplicationContext(), LoginActivity.class);
											startActivity(page);
											finish();
										}
									});
								}
							};
							_timer.schedule(timer, (int)(1000));
						}
						else {
							anime.setTarget(imageview2);
							anime.setPropertyName("alpha");
							anime.setFloatValues((float)(1), (float)(0));
							anime.setDuration((int)(1000));
							anime.start();
							timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											page.setClass(getApplicationContext(), WalkthroughActivity.class);
											startActivity(page);
											finish();
										}
									});
								}
							};
							_timer.schedule(timer, (int)(1000));
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(3000));
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
