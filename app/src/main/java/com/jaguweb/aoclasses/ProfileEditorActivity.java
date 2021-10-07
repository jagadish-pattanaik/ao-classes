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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class ProfileEditorActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private String avatar_path = "";
	
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private TextView textview1;
	private ImageView imageview1;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext4;
	private EditText edittext5;
	private EditText edittext6;
	private LinearLayout linear3;
	private Button button1;
	private Button button2;
	private Button button3;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private AlertDialog.Builder d;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile_editor);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		edittext5 = (EditText) findViewById(R.id.edittext5);
		edittext6 = (EditText) findViewById(R.id.edittext6);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		sp = getSharedPreferences("user data", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		d = new AlertDialog.Builder(this);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext5.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext6.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().equals("") && (!edittext2.getText().toString().equals("") && (!edittext3.getText().toString().equals("") && (!edittext4.getText().toString().equals("") && (!edittext5.getText().toString().equals("") && (!edittext6.getText().toString().equals("") && !avatar_path.equals(""))))))) {
					sp.edit().putString("user_name", edittext1.getText().toString()).commit();
					sp.edit().putString("user_num", edittext2.getText().toString()).commit();
					sp.edit().putString("user_subject", edittext3.getText().toString()).commit();
					sp.edit().putString("user_board", edittext4.getText().toString()).commit();
					sp.edit().putString("user_school", edittext5.getText().toString()).commit();
					sp.edit().putString("user_ainfo", edittext6.getText().toString()).commit();
					sp.edit().putString("user_avatar", avatar_path).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
				}
				else {
					if (!edittext1.getText().toString().equals("")) {
						sp.edit().putString("user_name", edittext1.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a valid name");
					}
					if (!edittext2.getText().toString().equals("")) {
						sp.edit().putString("user_num", edittext2.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a valid phone number");
					}
					if (!edittext3.getText().toString().equals("")) {
						sp.edit().putString("user_subject", edittext3.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a valid subject");
					}
					if (!edittext4.getText().toString().equals("")) {
						sp.edit().putString("user_board", edittext4.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a valid educational board name");
					}
					if (!edittext5.getText().toString().equals("")) {
						sp.edit().putString("user_school", edittext5.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a valid school name");
					}
					if (!edittext6.getText().toString().equals("")) {
						sp.edit().putString("user_ainfo", edittext6.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please provide additional information");
					}
					if (!avatar_path.equals("")) {
						sp.edit().putString("user_avatar", avatar_path).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Profile updated successfully");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please provide valid information");
					}
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Changes discarded ");
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
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
		button2.setEnabled(false);
		button3.setEnabled(false);
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		button1.setElevation(15f);
		button1.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setCornerRadius(50);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		button2.setElevation(15f);
		button2.setBackground(gd);
		android.graphics.drawable.GradientDrawable gd8 = new android.graphics.drawable.GradientDrawable();
		int clr8[] = new int[]{ Color.parseColor("#e57373"), Color.parseColor("#f44336")};
		gd8.setColors(clr8);
		gd8.setCornerRadius(50);
		gd8.setStroke(4, Color.parseColor("#f44336"));
		button3.setElevation(15f);
		button3.setBackground(gd8);
		if (!sp.getString("p_name", "").equals("") && (!sp.getString("p_num", "").equals("") && (!sp.getString("p_subject", "").equals("") && (!sp.getString("p_board", "").equals("") && (!sp.getString("p_school", "").equals("") && (!sp.getString("p_ainfo", "").equals("") && !sp.getString("p_avatar", "").equals(""))))))) {
			edittext1.setHint(sp.getString("p_name", ""));
			edittext2.setHint(sp.getString("p_num", ""));
			edittext3.setHint(sp.getString("p_subject", ""));
			edittext4.setHint(sp.getString("p_board", ""));
			edittext5.setHint(sp.getString("p_school", ""));
			edittext6.setHint(sp.getString("p_ainfo", ""));
			imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(sp.getString("p_avatar", ""), 1024, 1024));
		}
		else {
			if (!sp.getString("p_name", "").equals("")) {
				edittext1.setHint(sp.getString("p_name", ""));
			}
			if (!sp.getString("p_num", "").equals("")) {
				edittext2.setHint(sp.getString("p_num", ""));
			}
			if (!sp.getString("p_subject", "").equals("")) {
				edittext3.setHint(sp.getString("p_subject", ""));
			}
			if (!sp.getString("p_board", "").equals("")) {
				edittext4.setHint(sp.getString("p_board", ""));
			}
			if (!sp.getString("p_school", "").equals("")) {
				edittext5.setHint(sp.getString("p_school", ""));
			}
			if (!sp.getString("p_ainfo", "").equals("")) {
				edittext6.setHint(sp.getString("p_ainfo", ""));
			}
			if (!sp.getString("p_avatar", "").equals("")) {
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(sp.getString("p_avatar", ""), 1024, 1024));
			}
			edittext1.setHint(sp.getString("user_name", ""));
			imageview1.setImageResource(R.drawable.ic_person_add_black);
			edittext2.setHint("Phone Number");
			edittext3.setHint("Subject you teach");
			edittext4.setHint("Educational Board");
			edittext5.setHint("School Name");
			edittext6.setHint("Additional Information");
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				avatar_path = _filePath.get((int)(0));
				d.setTitle("Set as Profile Pic");
				d.setMessage("Do you want to set this image as profile pic ?");
				d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						sp.edit().putString("user_avatar", avatar_path).commit();
					}
				});
				d.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						avatar_path = "";
					}
				});
				d.create().show();
			}
			else {
				
			}
			break;
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
