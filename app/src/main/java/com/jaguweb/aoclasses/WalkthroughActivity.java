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
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

public class WalkthroughActivity extends AppCompatActivity {
	
	
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private TextView textview3;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear16;
	private ImageView imageview2;
	private ImageView imageview5;
	private ImageView imageview8;
	private ImageView imageview3;
	private ImageView imageview6;
	private ImageView imageview9;
	private ImageView imageview4;
	private ImageView imageview7;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private ImageView imageview11;
	private TextView textview5;
	private ImageView imageview13;
	private ImageView imageview12;
	private ImageView imageview16;
	private ImageView imageview10;
	private TextView textview4;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear28;
	private LinearLayout linear29;
	private ImageView imageview17;
	private TextView textview7;
	private TextView textview6;
	private ImageView imageview18;
	private LinearLayout linear30;
	private TextView textview8;
	private LinearLayout linear32;
	private LinearLayout linear33;
	private TextView textview9;
	private ImageView imageview19;
	private TextView textview11;
	private TextView textview10;
	private LinearLayout linear35;
	private LinearLayout linear36;
	private TextView textview12;
	private ImageView imageview20;
	private TextView textview13;
	private LinearLayout linear40;
	private LinearLayout linear39;
	private LinearLayout linear38;
	private ImageView imageview25;
	private ImageView imageview26;
	private ImageView imageview27;
	private TextView textview21;
	private ImageView imageview28;
	private TextView textview22;
	private TextView textview20;
	private TextView textview14;
	
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.walkthrough);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview19 = (ImageView) findViewById(R.id.imageview19);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		textview13 = (TextView) findViewById(R.id.textview13);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		imageview25 = (ImageView) findViewById(R.id.imageview25);
		imageview26 = (ImageView) findViewById(R.id.imageview26);
		imageview27 = (ImageView) findViewById(R.id.imageview27);
		textview21 = (TextView) findViewById(R.id.textview21);
		imageview28 = (ImageView) findViewById(R.id.imageview28);
		textview22 = (TextView) findViewById(R.id.textview22);
		textview20 = (TextView) findViewById(R.id.textview20);
		textview14 = (TextView) findViewById(R.id.textview14);
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("first_time", Activity.MODE_PRIVATE);
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.VISIBLE);
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.GONE);
				linear4.setVisibility(View.VISIBLE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.GONE);
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				linear7.setVisibility(View.VISIBLE);
				linear8.setVisibility(View.GONE);
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.GONE);
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
		});
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.GONE);
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.VISIBLE);
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.GONE);
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.VISIBLE);
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Read Documentation");
				d.setMessage("Its good to read documentation before you start");
				d.setPositiveButton("Read Documentation", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), DocumentationActivity.class);
						startActivity(i);
					}
				});
				d.setNegativeButton("Later", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), LoginActivity.class);
						startActivity(i);
						sp.edit().putString("first_time", "done").commit();
						finish();
					}
				});
				d.create().show();
			}
		});
	}
	private void initializeLogic() {
		linear2.setVisibility(View.VISIBLE);
		linear1.setVisibility(View.GONE);
		linear3.setVisibility(View.GONE);
		linear4.setVisibility(View.GONE);
		linear5.setVisibility(View.VISIBLE);
		linear6.setVisibility(View.GONE);
		linear7.setVisibility(View.GONE);
		linear8.setVisibility(View.GONE);
		d.setTitle("Let's get Started...");
		d.setMessage("Welcome ! Let's get started by knowing all features of AO CLASSES");
		d.setNeutralButton("LET'S GO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		d.create().show();
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
