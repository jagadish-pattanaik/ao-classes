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
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class FilesActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILES = 101;
	public final int REQ_CD_CAM = 102;
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	private String path = "";
	private String imagepath = "";
	private String folderpath = "";
	private String datenow = "";
	private String newphotoname = "";
	private String app_path = "";
	
	private ArrayList<String> Image_picker = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear4;
	private Button pick_files;
	private LinearLayout finalview;
	private ImageView imageview1;
	
	private Intent files = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dialogue1;
	private Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_cam;
	private Intent intent = new Intent();
	private Calendar calender = Calendar.getInstance();
	private SharedPreferences sp;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.files);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		pick_files = (Button) findViewById(R.id.pick_files);
		finalview = (LinearLayout) findViewById(R.id.finalview);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		files.setType("*/*");
		files.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dialogue1 = new AlertDialog.Builder(this);
		_file_cam = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_cam = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_cam= FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_cam);
		}
		else {
			_uri_cam = Uri.fromFile(_file_cam);
		}
		cam.putExtra(MediaStore.EXTRA_OUTPUT, _uri_cam);
		cam.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		pick_files.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(files, REQ_CD_FILES);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(cam, REQ_CD_CAM);
			}
		});
	}
	private void initializeLogic() {
		setTitle("PICK FILES FROM GALERY");
	} private void saveImage(Bitmap bitmap) {
		java.io.FileOutputStream fod = null;
		java.io.File picFile = new java.io.File(imagepath);
		try {
			fod = new java.io.FileOutputStream(picFile);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, fod);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fod != null) {
					fod.close();
				}
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
		Intent mediaScanIntent = new Intent( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE); Uri contentUri = Uri.fromFile(picFile); mediaScanIntent.setData(contentUri); this.sendBroadcast(mediaScanIntent);
		finalview.destroyDrawingCache();
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		pick_files.setElevation(15f);
		pick_files.setBackground(gd3);
		if (!sp.getString("checked3", "").equals("1")) {
			dialogue1.setTitle("FILES");
			dialogue1.setMessage("In files you can view your teaching files and take photos or scan your files.");
			dialogue1.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			dialogue1.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("checked3", "1").commit();
				}
			});
			dialogue1.create().show();
		}
		else {
			
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILES:
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
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
			}
			else {
				
			}
			break;
			
			case REQ_CD_CAM:
			if (_resultCode == Activity.RESULT_OK) {
				 String _filePath = _file_cam.getAbsolutePath();
				
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath, 1024, 1024));
				dialogue1.setTitle("SAVE IMAGE");
				dialogue1.setMessage("Do you want to save the photo ?");
				dialogue1.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						calender = Calendar.getInstance();
						datenow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(calender.getTime());
						newphotoname = "AO_Classes".concat(datenow);
						imagepath = folderpath.concat("/AoClasses".concat(newphotoname.concat(".jpg")));
						finalview.setDrawingCacheEnabled(true);
						Bitmap bitmap = finalview.getDrawingCache();
						saveImage(bitmap);
						SketchwareUtil.showMessage(getApplicationContext(), "Photo Saved Successfully ");
					}
				});
				dialogue1.setNegativeButton("DON'T SAVE", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Photo save cancelled");
					}
				});
				dialogue1.create().show();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		folderpath = FileUtil.getExternalStorageDir().concat("/AO CLASSES/photos");
		if (FileUtil.isDirectory(folderpath)) {
			
		}
		else {
			FileUtil.makeDir(folderpath);
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
