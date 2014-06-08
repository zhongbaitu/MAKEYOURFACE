package com.facpp.picturedetect;

import android.R.raw;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class Eyes {
	MainActivity mainactivity;
	
//	mainactivity.person mainactivity.person;
	ImageButton eyeButton1,eyeButton2,eyeButton3,eyeButton4,eyeButton5,eyeButton6,eyeButton7,eyeButton8,eyeButton9;
	
//	ViewFlip viewFlip;
	
	private Bitmap eye1_left,eye1_right,eye2_left,eye2_right,eye3_left,eye3_right,eye4_left,eye4_right,eye5_left,eye5_right
	,eye6_left,eye6_right,eye7_left,eye7_right,eye8_left,eye8_right,eye9_left,eye9_right;

	public Eyes(Context context) {

		this.mainactivity=(MainActivity) context;
		
		
		
		View view=mainactivity.viewflip.vf.getChildAt(0);

		
		eye1_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye1_left);
        eye1_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye1_right);
        eye2_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye2_left);
        eye2_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye2_right);
        eye3_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye3_left);
        eye3_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye3_right);
        eye4_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye4_left);
        eye4_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye4_right);
        eye5_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye5_left);
        eye5_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye5_right);
        eye6_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye6_left);
        eye6_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye6_right);
        eye7_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye7_left);
        eye7_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye7_right);
        eye8_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye8_left);
        eye8_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye8_right);
        eye9_left=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye9_left);
        eye9_right=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.eye9_right);
		

		eyeButton1=(ImageButton) view.findViewById(R.id.eyes1);
		eyeButton2=(ImageButton) view.findViewById(R.id.eyes2);
		eyeButton3=(ImageButton) view.findViewById(R.id.eyes3);
		eyeButton4=(ImageButton) view.findViewById(R.id.eyes4);
		eyeButton5=(ImageButton) view.findViewById(R.id.eyes5);
		eyeButton6=(ImageButton) view.findViewById(R.id.eyes6);
		eyeButton7=(ImageButton) view.findViewById(R.id.eyes7);
		eyeButton8=(ImageButton) view.findViewById(R.id.eyes8);
		eyeButton9=(ImageButton) view.findViewById(R.id.eyes9);
		

		eyeButton1.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(1);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton2.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton2.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(2);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		

		eyeButton3.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton3.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(3);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton4.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton4.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(4);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton5.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton5.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(5);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton6.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton6.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(6);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton7.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton7.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(7);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton8.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton8.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(8);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		eyeButton9.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				eyeButton9.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setEyes(9);
						mainactivity.draw(); 
						
					}
				});
				
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		
	}
	
	
	public void draw(Canvas canvas){
		switch (mainactivity.person.getEyes()) {
		case 1:
			canvas.drawBitmap(eye1_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye1_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 2:
			canvas.drawBitmap(eye2_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye2_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 3:
			canvas.drawBitmap(eye3_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye3_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 4:
			canvas.drawBitmap(eye4_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye4_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 5:
			canvas.drawBitmap(eye5_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye5_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 6:
			canvas.drawBitmap(eye6_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye6_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 7:
			canvas.drawBitmap(eye7_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye7_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 8:
			canvas.drawBitmap(eye8_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye8_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;
			
		case 9:
			canvas.drawBitmap(eye9_left, mainactivity.eye_left_x, mainactivity.eye_left_y, null);
			canvas.drawBitmap(eye9_right, mainactivity.eye_right_x, mainactivity.eye_right_y, null);
			break;

		
		}
		//»­Í¼Íê³É£¬±£´æÍ¼Æ¬
		mainactivity.img = mainactivity.bitmap;
		
	}
	
	

}
