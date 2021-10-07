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
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import android.widget.AdapterView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NotesActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	private TextView textview1;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.notes);
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
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NotesEditorActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				sp.edit().putString("pos", String.valueOf((long)(_position))).commit();
				i.setClass(getApplicationContext(), NotesEditorActivity.class);
				startActivity(i);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				d.setTitle("Delete Note ?");
				d.setMessage("Are you sure you want to delete this note ?");
				d.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						listmap.remove((int)(_position));
						sp.edit().putString("allnotes", new Gson().toJson(listmap)).commit();
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				d.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				return true;
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NotesEditorActivity.class);
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
		setTitle("NOTES");
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		linear1.setElevation(15f);
		linear1.setBackground(gd);
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
	public void onStart() {
		super.onStart();
		sp.edit().putString("pos", "").commit();
		if (!sp.getString("allnotes", "").equals("")) {
			listmap = new Gson().fromJson(sp.getString("allnotes", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(listmap));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.custom, null);
			}
			
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			
			textview1.setText(listmap.get((int)_position).get("note").toString());
			
			return _v;
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
