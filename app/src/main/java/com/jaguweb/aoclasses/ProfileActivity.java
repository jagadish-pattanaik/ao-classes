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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class ProfileActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear4;
	private Button button1;
	private Button button2;
	private LinearLayout linear6;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	private TextView textview2;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private Intent i = new Intent();
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
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
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview2 = (TextView) findViewById(R.id.textview2);
		auth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("user data", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					FirebaseAuth.getInstance().signOut();
					finish();
				}
				else {
					i.setClass(getApplicationContext(), LoginActivity.class);
					startActivity(i);
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), ProfileEditorActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Login first to edit your profile");
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					i.setClass(getApplicationContext(), ProfileEditorActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Login First to edit your profile");
				}
			}
		});
		
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
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			if (!sp.getString("user_name", "").equals("")) {
				textview3.setText(sp.getString("user_name", ""));
				sp.edit().putString("p_name", textview3.getText().toString()).commit();
				textview1.setText(textview3.getText().toString());
			}
			else {
				textview3.setText("Name");
				textview1.setText("Name");
			}
			if (!sp.getString("user_num", "").equals("")) {
				textview5.setText(sp.getString("user_num", ""));
				sp.edit().putString("p_num", textview5.getText().toString()).commit();
			}
			else {
				textview5.setText("Phone number");
			}
			if (!sp.getString("user_email", "").equals("")) {
				textview4.setText(sp.getString("user_email", ""));
				sp.edit().putString("p_email", textview4.getText().toString()).commit();
			}
			else {
				textview4.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
			}
			if (!sp.getString("user_subject", "").equals("")) {
				textview6.setText(sp.getString("user_subject", ""));
				sp.edit().putString("p_subject", textview6.getText().toString()).commit();
			}
			else {
				textview6.setText("Subject");
			}
			if (!sp.getString("user_board", "").equals("")) {
				textview7.setText(sp.getString("user_board", ""));
				sp.edit().putString("p_board", textview7.getText().toString()).commit();
			}
			else {
				textview7.setText("Board");
			}
			if (!sp.getString("user_school", "").equals("")) {
				textview8.setText(sp.getString("user_school", ""));
				sp.edit().putString("p_school", textview8.getText().toString()).commit();
			}
			else {
				textview8.setText("School Name");
			}
			if (!sp.getString("user_ainfo", "").equals("")) {
				textview9.setText(sp.getString("user_ainfo", ""));
				sp.edit().putString("p_ainfo", textview9.getText().toString()).commit();
			}
			else {
				textview9.setText("Additional Information");
			}
			if (!sp.getString("user_avatar", "").equals("")) {
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(sp.getString("user_avatar", ""), 1024, 1024));
				sp.edit().putString("p_avatar", sp.getString("user_avatar", "")).commit();
			}
			else {
				imageview1.setImageResource(R.drawable.ic_account_circle_black);
			}
			textview2.setText("Your Profile");
			textview2.setTextColor(0xFF000000);
			button1.setBackgroundColor(0xFFF44336);
			button2.setBackgroundColor(0xFF29B6F6);
			textview3.setText(sp.getString("user_name", ""));
			textview1.setText(textview3.getText().toString());
			textview4.setText(sp.getString("user_email", ""));
			imageview1.setImageResource(R.drawable.ic_account_circle_black);
			sp.edit().putString("p_name", textview3.getText().toString()).commit();
			sp.edit().putString("p_email", textview4.getText().toString()).commit();
			button1.setText("LOGOUT");
		}
		else {
			textview2.setText("Please Login first to view your profile");
			textview2.setTextColor(0xFFF44336);
			button1.setBackgroundColor(0xFF4CAF50);
			button2.setBackgroundColor(0xFF29B6F6);
			button1.setText("LOGIN");
			button1.setBackgroundColor(0xFF4CAF50);
			textview3.setText("Name");
			textview1.setText(textview3.getText().toString());
			textview4.setText("Email Id");
			textview5.setText("Phone number");
			textview6.setText("Subject");
			textview7.setText("Board");
			textview8.setText("School Name");
			textview9.setText("Additional Information");
			imageview1.setImageResource(R.drawable.ic_account_circle_black);
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
		finish();
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
