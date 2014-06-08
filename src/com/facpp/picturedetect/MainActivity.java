package com.facpp.picturedetect;

import java.io.ByteArrayOutputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;


public class MainActivity extends Activity {

	final private static String TAG = "MainActivity";
	final private int PICTURE_CHOOSE = 1;
	final private int From_Carema = 2;
	
	private ImageView imageView = null;
	Bitmap img = null;
	
	float eye_left_x, eye_left_y,eye_right_x,eye_right_y, nose_x,nose_y,mouth_x,mouth_y;  //眼耳口鼻的坐标
	
	Button button,button2,carema_but; 

	private Eyes eyes;
	private Nose nose;
	private Mouth mouth;
	Person person;
	ViewFlip viewflip;
	Bitmap bitmap;
	Bitmap NewBitmap;
	Bitmap progress;
	Bitmap angelababy;
	int ifLoaded=0;
	SaveFile savefile;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设置横屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        	angelababy=BitmapFactory.decodeResource(getResources(), R.drawable.angelababy);
            imageView = (ImageView)this.findViewById(R.id.imageView1);
            imageView.setImageBitmap(angelababy);
            
            progress=BitmapFactory.decodeResource(getResources(), R.drawable.progess);
            
            person=new Person();
            viewflip=new ViewFlip(this);
            eyes=new Eyes(this);
            nose=new Nose(this);
            mouth=new Mouth(this);
            savefile=new SaveFile(this);
            System.out.println("oncreat");

        
        if(savedInstanceState!=null){
        	ifLoaded=savedInstanceState.getInt("ifLoaded");
        	NewBitmap=savedInstanceState.getParcelable("NewBitmap");
        	img=savedInstanceState.getParcelable("img");
        	bitmap=savedInstanceState.getParcelable("bitmap");
        	eye_left_x=savedInstanceState.getFloat("eye_left_x");
        	eye_left_y=savedInstanceState.getFloat("eye_left_y");
        	eye_right_x=savedInstanceState.getFloat("eye_right_x");
        	eye_right_y=savedInstanceState.getFloat("eye_right_y");
        	nose_x=savedInstanceState.getFloat("nose_x");
        	nose_y=savedInstanceState.getFloat("nose_y");
        	mouth_x=savedInstanceState.getFloat("mouth_x");
        	mouth_y=savedInstanceState.getFloat("mouth_y");
        	if(img!=null){
        		imageView.setImageBitmap(img);
        	}

        }

        button = (Button)this.findViewById(R.id.button1);
        //选择图片
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				person=new Person();
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		        photoPickerIntent.setType("image/*");
		        startActivityForResult(photoPickerIntent, PICTURE_CHOOSE);
			}
		});
        
        //照相机
        carema_but=(Button) this.findViewById(R.id.carema);
        carema_but.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				person=new Person();
				Intent takePhoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(takePhoto, From_Carema);
				
			}
		});
        
        //保存图片
        button2=(Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				savefile.save(img);
				
			}
		});

    }

    @Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {    //恢复状态数据
		// TODO Auto-generated method stub
    	ifLoaded=savedInstanceState.getInt("ifLoaded");
    	NewBitmap=savedInstanceState.getParcelable("NewBitmap");
    	img=savedInstanceState.getParcelable("img");
    	bitmap=savedInstanceState.getParcelable("bitmap");
    	eye_left_x=savedInstanceState.getFloat("eye_left_x");
    	eye_left_y=savedInstanceState.getFloat("eye_left_y");
    	eye_right_x=savedInstanceState.getFloat("eye_right_x");
    	eye_right_y=savedInstanceState.getFloat("eye_right_y");
    	nose_x=savedInstanceState.getFloat("nose_x");
    	nose_y=savedInstanceState.getFloat("nose_y");
    	mouth_x=savedInstanceState.getFloat("mouth_x");
    	mouth_y=savedInstanceState.getFloat("mouth_y");
    	if(img!=null){
    		imageView.setImageBitmap(img);
    	}
    	
    	System.out.println("onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {        //保存状态，防止锁屏后图片丢失
		// TODO Auto-generated method stub
		outState.putParcelable("NewBitmap",NewBitmap);
		outState.putParcelable("img", img);
		outState.putParcelable("bitmap", bitmap);
		outState.putInt("ifLoaded", ifLoaded);
		outState.putFloat("eye_left_x", eye_left_x);
		outState.putFloat("eye_left_y", eye_left_y);
		outState.putFloat("eye_right_x", eye_right_x);
		outState.putFloat("eye_right_y", eye_right_y);
		outState.putFloat("nose_x", nose_x);
		outState.putFloat("nose_y", nose_y);
		outState.putFloat("mouth_x", mouth_x);	
		outState.putFloat("mouth_y", mouth_y);
		System.out.println("onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	//选择图片的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	super.onActivityResult(requestCode, resultCode, intent);
    	
    	//从相册获取照片，回调
    	if (requestCode == PICTURE_CHOOSE) {
    		if (intent != null) {
    			
    			
    			Cursor cursor = getContentResolver().query(intent.getData(), null, null, null, null);
    			cursor.moveToFirst();
    			int idx = cursor.getColumnIndex(ImageColumns.DATA);
    			String fileSrc = cursor.getString(idx); 
    			//Log.d(TAG, "Picture:" + fileSrc);
    			
    			
    			Options options = new Options();
    			options.inJustDecodeBounds = true;
    			img = BitmapFactory.decodeFile(fileSrc, options);

    		
    			options.inSampleSize = Math.max(1, (int)Math.ceil(Math.max((double)options.outWidth / 1024f, (double)options.outHeight / 1024f)));
    			options.inJustDecodeBounds = false;
    			img = BitmapFactory.decodeFile(fileSrc, options);	

    			System.out.println("载入成功");
    			  
    			NewBitmap=img;
    			
    			imageView.setImageBitmap(progress);
    			
    			detect();
    			
			
    		}
    		
    	}else if(requestCode==From_Carema){   //在照相机获取照片，回调
    		if (intent != null) {
    			Bundle extras=intent.getExtras();
        		img=(Bitmap) extras.get("data");
        		NewBitmap=img;
    			
    			imageView.setImageBitmap(progress);
    			
    			detect();
    		}
    		
    		
    	}
    }
    
    //face++的detect
    private class FaceppDetect {
    	DetectCallback callback = null;
    	
    	public void setDetectCallback(DetectCallback detectCallback) { 
    		callback = detectCallback;
    	}

    	public void detect(final Bitmap image) {
    		
    		new Thread(new Runnable() {
				
				public void run() {
					HttpRequests httpRequests = new HttpRequests("48e076d2628e91534e6f2175cd7f8003", "pV22Bbbs-xn-XW4-f2ZpiNaUolEt3sAD", true, false);
		      		//Log.v(TAG, "image size : " + img.getWidth() + " " + img.getHeight());
		    		
		    		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		    		
		    	  
		    		float scale = Math.min(1, Math.min(600f / img.getWidth(), 600f / img.getHeight()));
		    		Matrix matrix = new Matrix();
		    		matrix.postScale(scale, scale);

		    		Bitmap imgSmall = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, false);
		    		//Log.v(TAG, "imgSmall size : " + imgSmall.getWidth() + " " + imgSmall.getHeight());
		    		
		    		imgSmall.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		    		
		    		byte[] array = stream.toByteArray();
		    		
		    		try {
		    			//detect
						JSONObject result = httpRequests.detectionDetect(new PostParameters().setImg(array));
						//完成，启动回调函数
						if (callback != null) {
							callback.detectResult(result);
							System.out.println(result);
							
						}
					} catch (FaceppParseException e) {
						e.printStackTrace();
						MainActivity.this.runOnUiThread(new Runnable() {
							public void run() {
//								textView.setText("网络异常.");
								Toast.makeText(MainActivity.this, "网络异常，检查网络是否正常打开", Toast.LENGTH_LONG).show();
							}
						});
					}
					
				}
			}).start();
    		
    	}
    }

    interface DetectCallback {
    	void detectResult(JSONObject rst);
	}
    
    public void detect(){
    	ifLoaded=1;
    	FaceppDetect faceppDetect = new FaceppDetect();
		faceppDetect.setDetectCallback(new DetectCallback() {
			
			public void detectResult(final JSONObject rst) {  
				
				bitmap = Bitmap.createBitmap(img.getWidth(), img.getHeight(), img.getConfig());
				
				
				try {
					//脸的张数
					final int count = rst.getJSONArray("face").length();
					
					
					
					for (int i = 0; i < count; ++i) {
						
						//获得landmark
						eye_left_x= (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("eye_left").getDouble("x");
						eye_left_y = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("eye_left").getDouble("y");
						eye_right_x= (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("eye_right").getDouble("x");
						eye_right_y = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("eye_right").getDouble("y");
						nose_x = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("nose").getDouble("x");
						nose_y = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("nose").getDouble("y");
						mouth_x = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("mouth_left").getDouble("x");
						mouth_y = (float)rst.getJSONArray("face").getJSONObject(i)
								.getJSONObject("position").getJSONObject("mouth_right").getDouble("y");

						
						//转换真实坐标
						eye_left_x = eye_left_x / 100 * img.getWidth()-40;
						eye_left_y = eye_left_y / 100 * img.getHeight()-40;
						eye_right_x = eye_right_x / 100 * img.getWidth()-40;
						eye_right_y = eye_right_y / 100 * img.getHeight()-40;
						nose_x = nose_x / 100 * img.getWidth()-60;
						nose_y = nose_y / 100 * img.getHeight()-35;
						mouth_x = mouth_x / 100 * img.getWidth()-40;
						mouth_y = mouth_y / 100 * img.getHeight()-20;
		
					}
					
					MainActivity.this.runOnUiThread(new Runnable() {
						
						public void run() {
							imageView.setImageBitmap(img);
							ifLoaded=2;
						}
					});
					
					
					
				} catch (JSONException e) {
					e.printStackTrace();
					MainActivity.this.runOnUiThread(new Runnable() {
						public void run() {
							System.out.println("Error.");
						}
					});
				}
				
			}
		});
		faceppDetect.detect(img);
		
    }
    
    
    public void draw(){

    	if(ifLoaded==2){
			
    		//创建一新画布
    		Canvas canvas = new Canvas(bitmap);      //bitmap是一张白画布
    		canvas.drawBitmap(NewBitmap, new Matrix(), null);   //NewBitmap  一直都不变，一直都是原始载入那张图片

    		eyes.draw(canvas);
    		nose.draw(canvas);
    		mouth.draw(canvas);
    		
    		MainActivity.this.runOnUiThread(new Runnable() {
    			
    			public void run() {
    				//show 出来
    				imageView.setImageBitmap(img);
    				System.out.println("画图完成.");
    			}
    		});
		}else if(ifLoaded==1){
			Toast.makeText(MainActivity.this, "请稍等、正在加载分析", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(MainActivity.this, "请选择照片", Toast.LENGTH_SHORT).show();
		}
	
    	
    }
}
