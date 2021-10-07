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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class LoginActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear2;
	private LinearLayout linear_login;
	private LinearLayout linear_forget_pass;
	private LinearLayout linear_register;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview7;
	private TextView textview2;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private Button button1;
	private ProgressBar progressbar1;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private ImageView imageview3;
	private EditText edittext2;
	private ImageView imageview4;
	private EditText edittext4;
	private TextView textview10;
	private TextView textview4;
	private TextView textview3;
	private ImageView imageview5;
	private TextView textview5;
	private TextView textview6;
	private EditText edittext6;
	private Button button2;
	private ProgressBar progressbar2;
	private Button button4;
	private Button button5;
	private ImageView imageview6;
	private TextView textview7;
	private TextView textview8;
	private EditText edittext7;
	private EditText edittext8;
	private EditText edittext9;
	private EditText edittext10;
	private ProgressBar progressbar3;
	private Button button3;
	private LinearLayout linear11;
	private TextView textview14;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private TextView textview9;
	
	private Intent intent = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private AlertDialog.Builder d1;
	private SharedPreferences sp;
	private TimerTask t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear_login = (LinearLayout) findViewById(R.id.linear_login);
		linear_forget_pass = (LinearLayout) findViewById(R.id.linear_forget_pass);
		linear_register = (LinearLayout) findViewById(R.id.linear_register);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		button1 = (Button) findViewById(R.id.button1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		edittext6 = (EditText) findViewById(R.id.edittext6);
		button2 = (Button) findViewById(R.id.button2);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		edittext7 = (EditText) findViewById(R.id.edittext7);
		edittext8 = (EditText) findViewById(R.id.edittext8);
		edittext9 = (EditText) findViewById(R.id.edittext9);
		edittext10 = (EditText) findViewById(R.id.edittext10);
		progressbar3 = (ProgressBar) findViewById(R.id.progressbar3);
		button3 = (Button) findViewById(R.id.button3);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview9 = (TextView) findViewById(R.id.textview9);
		auth = FirebaseAuth.getInstance();
		d1 = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext2.getText().toString().equals("") || edittext4.getText().toString().equals("")) {
					if (edittext2.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your email");
					}
					if (edittext4.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "password");
					}
				}
				else {
					auth.signInWithEmailAndPassword(edittext2.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_sign_in_listener);
					progressbar1.setVisibility(View.VISIBLE);
				}
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.GONE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.VISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Don't have an account? Sign up to continue...");
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.GONE);
				linear_forget_pass.setVisibility(View.VISIBLE);
				linear_register.setVisibility(View.GONE);
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.GONE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.VISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Don't have an account? Sign up to continue...");
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.GONE);
				linear_forget_pass.setVisibility(View.VISIBLE);
				linear_register.setVisibility(View.GONE);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext6.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter your Email Id");
				}
				else {
					auth.sendPasswordResetEmail(edittext6.getText().toString()).addOnCompleteListener(_auth_reset_password_listener);
					progressbar2.setVisibility(View.VISIBLE);
				}
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.VISIBLE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Login to continue...");
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.GONE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.VISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Don't have an account? Sign up to continue...");
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext7.getText().toString().equals("") || ((edittext8.getText().toString().equals("") || edittext9.getText().toString().equals("")) || edittext10.getText().toString().equals(""))) {
					if (edittext7.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your name");
					}
					if (edittext8.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your Email");
					}
					if (edittext9.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your password");
					}
					if (edittext10.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Confirm your password");
					}
				}
				else {
					if (edittext9.getText().toString().equals(edittext10.getText().toString())) {
						auth.createUserWithEmailAndPassword(edittext8.getText().toString(), edittext9.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_create_user_listener);
						linear_login.setVisibility(View.VISIBLE);
						linear_register.setVisibility(View.GONE);
						progressbar3.setVisibility(View.VISIBLE);
					}
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.VISIBLE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Login to continue...");
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), DocumentationActivity.class);
				startActivity(intent);
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), PrivacyPolicyActivity.class);
				startActivity(intent);
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), TermsConditionsActivity.class);
				startActivity(intent);
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AppsWebsPolicyActivity.class);
				startActivity(intent);
			}
		});
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_login.setVisibility(View.VISIBLE);
				linear_forget_pass.setVisibility(View.GONE);
				linear_register.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Login to continue...");
			}
		});
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					progressbar3.setVisibility(View.GONE);
					edittext2.setText(edittext8.getText().toString());
					edittext4.setText(edittext9.getText().toString());
					auth.signInWithEmailAndPassword(edittext8.getText().toString(), edittext9.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_sign_in_listener);
					sp.edit().putString("user_name", edittext7.getText().toString()).commit();
					sp.edit().putString("user_email", edittext8.getText().toString()).commit();
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")))) {
						
					}
					else {
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")));
					}
					finish();
				}
				else {
					if (_errorMessage.contains("already")) {
						SketchwareUtil.showMessage(getApplicationContext(), "You already have an account in this gmail id.");
						progressbar3.setVisibility(View.GONE);
						linear_login.setVisibility(View.VISIBLE);
						linear_forget_pass.setVisibility(View.GONE);
						linear_register.setVisibility(View.GONE);
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Login to continue...");
									}
								});
							}
						};
						_timer.schedule(t, (int)(2000));
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Sign up failed ! Please try again");
						progressbar3.setVisibility(View.GONE);
					}
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					progressbar1.setVisibility(View.GONE);
					sp.edit().putString("user_email", edittext2.getText().toString()).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "logged in successfully");
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")))) {
						
					}
					else {
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")));
					}
					finish();
				}
				else {
					if (_errorMessage.contains("no user record")) {
						SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
						linear_login.setVisibility(View.GONE);
						linear_forget_pass.setVisibility(View.GONE);
						linear_register.setVisibility(View.VISIBLE);
						progressbar1.setVisibility(View.GONE);
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Don't have an account? Sign up to continue...");
									}
								});
							}
						};
						_timer.schedule(t, (int)(2000));
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
						progressbar1.setVisibility(View.GONE);
					}
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "Password reset link has been sent to your email Id");
					progressbar2.setVisibility(View.GONE);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "ERROR ! Password reset link cound not be sent");
					progressbar2.setVisibility(View.GONE);
				}
			}
		};
	}
	private void initializeLogic() {
		android.graphics.drawable.GradientDrawable gd0 = new android.graphics.drawable.GradientDrawable();
		int clr0[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd0.setColors(clr0);
		gd0.setCornerRadius(50);
		gd0.setStroke(4, Color.parseColor("#2e7d32"));
		button1.setElevation(15f);
		button1.setBackground(gd0);
		button2.setElevation(15f);
		button2.setBackground(gd0);
		button3.setElevation(15f);
		button3.setBackground(gd0);
		android.graphics.drawable.GradientDrawable gd8 = new android.graphics.drawable.GradientDrawable();
		int clr8[] = new int[]{ Color.parseColor("#e57373"), Color.parseColor("#f44336")};
		gd8.setColors(clr8);
		gd8.setCornerRadius(50);
		gd8.setStroke(4, Color.parseColor("#f44336"));
		linear10.setElevation(15f);
		linear10.setBackground(gd8);
		android.graphics.drawable.GradientDrawable gd7 = new android.graphics.drawable.GradientDrawable();
		int clr7[] = new int[]{ Color.parseColor("#4fc3f7"), Color.parseColor("#03a9f4")};
		gd7.setColors(clr7);
		gd7.setCornerRadius(50);
		gd7.setStroke(4, Color.parseColor("#03a9f4"));
		button4.setElevation(15f);
		button4.setBackground(gd7);
		linear11.setElevation(15f);
		linear11.setBackground(gd7);
		android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
		int clr2[] = new int[]{ Color.parseColor("#4db6ac"), Color.parseColor("#009688")};
		gd2.setColors(clr2);
		gd2.setCornerRadius(50);
		gd2.setStroke(4, Color.parseColor("#009688"));
		button5.setElevation(15f);
		button5.setBackground(gd2);
		android.graphics.drawable.GradientDrawable gd6 = new android.graphics.drawable.GradientDrawable();
		gd6.setColor(Color.parseColor("#ffffff"));
		gd6.setCornerRadius(50);
		gd6.setStroke(4, Color.parseColor("#e0e0e0"));
		linear8.setElevation(15f);
		linear8.setBackground(gd6);
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		gd3.setColor(Color.parseColor("#ffffff"));
		gd3.setCornerRadius(50);
		gd3.setStroke(2, Color.parseColor("#e0e0e0"));
		linear7.setElevation(15f);
		linear7.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd1 = new android.graphics.drawable.GradientDrawable();
		gd1.setColor(Color.parseColor("#ffffff"));
		gd1.setCornerRadius(50);
		gd1.setStroke(2, Color.parseColor("#e0e0e0"));
		linear9.setElevation(15f);
		linear9.setBackground(gd1);
		android.graphics.drawable.GradientDrawable gd4 = new android.graphics.drawable.GradientDrawable();
		gd4.setColor(Color.parseColor("#ffffff"));
		gd4.setCornerRadius(50);
		gd4.setStroke(2, Color.parseColor("#e0e0e0"));
		edittext6.setElevation(15f);
		edittext6.setBackground(gd4);
		edittext7.setElevation(15f);
		edittext7.setBackground(gd4);
		edittext8.setElevation(15f);
		edittext8.setBackground(gd4);
		edittext9.setElevation(15f);
		edittext9.setBackground(gd4);
		edittext10.setElevation(15f);
		edittext10.setBackground(gd4);
		linear_login.setVisibility(View.VISIBLE);
		progressbar1.setVisibility(View.GONE);
		progressbar2.setVisibility(View.GONE);
		progressbar3.setVisibility(View.GONE);
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			finish();
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Login to continue...");
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
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES")));
		}
		d1.setTitle("Login First");
		d1.setMessage("Please Login First To Continue...");
		d1.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		d1.create().show();
		SketchwareUtil.showMessage(getApplicationContext(), "Please Login First");
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
