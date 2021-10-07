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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.ClipData;
import android.net.Uri;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class ConvertImgPdfActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private Toolbar _toolbar;
	private double n = 0;
	private String save_path = "";
	private String path1 = "";
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> imagelist = new ArrayList<>();
	
	private LinearLayout linear3;
	private ListView listview1;
	private Button button_open;
	private EditText edittext1;
	private Button button_save;
	
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent i = new Intent();
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.convert_img_pdf);
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
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		listview1 = (ListView) findViewById(R.id.listview1);
		button_open = (Button) findViewById(R.id.button_open);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		button_save = (Button) findViewById(R.id.button_save);
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		button_open.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		button_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					
					android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument();
					
					
					
					
					
					int max = 0;
					
					int[] allwidth = new int[imagelist.size()];
					
					n = 0;
					for(int _repeat20 = 0; _repeat20 < (int)(imagelist.size()); _repeat20++) {
						path1 = imagelist.get((int)n).get("pic").toString();
						Bitmap mBitmap = FileUtil.decodeSampleBitmapFromPath(path1, 1024, 1024);
						
						
						int width = mBitmap.getWidth();
						
						allwidth[(int)n] = width;
						
						if (width > max){
							
							max = width;
							
						}
						
						
						n++;
					}
					n = 0;
					for(int _repeat13 = 0; _repeat13 < (int)(imagelist.size()); _repeat13++) {
						Bitmap mBitmap = FileUtil.decodeSampleBitmapFromPath(imagelist.get((int)n).get("pic").toString(), 1024, 1024);
						
						
						android.graphics.pdf.PdfDocument.PageInfo pageInfo = new android.graphics.pdf.PdfDocument.PageInfo.Builder(max, mBitmap.getHeight(), (int)n + 1).create();
						
						
						android.graphics.pdf.PdfDocument.Page page = document.startPage(pageInfo);
						
						
						Canvas canvas = page.getCanvas();
						
						canvas.drawColor(Color.WHITE);
						
						canvas.drawBitmap(mBitmap, (max - allwidth[(int)n])/2 , 0, null);
						
						
						document.finishPage(page);
						
						
						n++;
					}
					if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES".concat("/".concat("PDF files")))))) {
						
					}
					else {
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES".concat("/".concat("PDF files")))));
					}
					if (edittext1.getText().toString().length() > 0) {
						save_path = FileUtil.getExternalStorageDir().concat("/".concat("AO CLASSES".concat("/".concat("PDF files".concat("/".concat(edittext1.getText().toString().concat(".pdf")))))));
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter a file name");
					}
					
					java.io.FileOutputStream fout = new java.io.FileOutputStream(new java.io.File(save_path));
					
					
					document.writeTo(fout);
					
					document.close();
					
					fout.close();
					
					showMessage("File Saved");
					
				} catch ( Exception e){
					
					showMessage(e.toString());
					
				}
				
				
			}
		});
		
		_Ads_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				
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
		android.graphics.drawable.GradientDrawable gd3 = new android.graphics.drawable.GradientDrawable();
		int clr3[] = new int[]{ Color.parseColor("#80deea"), Color.parseColor("#00bcd4")};
		gd3.setColors(clr3);
		gd3.setCornerRadius(50);
		gd3.setStroke(4, Color.parseColor("#00bcd4"));
		button_open.setElevation(15f);
		button_open.setBackground(gd3);
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor("#4caf50"), Color.parseColor("#2e7d32")};
		gd.setColors(clr);
		gd.setCornerRadius(50);
		gd.setStroke(4, Color.parseColor("#2e7d32"));
		button_save.setElevation(15f);
		button_save.setBackground(gd);
		if (!sp.getString("pd", "").equals("1")) {
			d.setTitle("Convert Image to PDF");
			d.setMessage("Choose Image files by clicking on Open and then save the PDF file by giving a file name");
			d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.setNegativeButton("Ok don't show again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("pd", "1").commit();
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
				n = 0;
				for(int _repeat11 = 0; _repeat11 < (int)(_filePath.size()); _repeat11++) {
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("pic", _filePath.get((int)(0)));
						imagelist.add(_item);
					}
					
					n++;
				}
				listview1.setAdapter(new Listview1Adapter(imagelist));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			else {
				
			}
			break;
			default:
			break;
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
				_v = _inflater.inflate(R.layout.itemview, null);
			}
			
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			
			imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(imagelist.get((int)_position).get("pic").toString(), 1024, 1024));
			
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
