package com.facpp.picturedetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class Mouth {
	MainActivity mainactivity;
	

	ImageButton mouthButton1,mouthButton2,mouthButton3,mouthButton4,mouthButton5,mouthButton6
				,mouthButton7,mouthButton8,mouthButton9;
	
//	ViewFlip viewFlip;
	
	private Bitmap mouth1Img,mouth2Img;

	public Mouth(Context context) {

		this.mainactivity=(MainActivity) context;
		


		
		View view=mainactivity.viewflip.vf.getChildAt(2);
		
		mouth1Img=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.mouth1);
		mouth2Img=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.mouth2);

		

		mouthButton1=(ImageButton) view.findViewById(R.id.mouth1);
		mouthButton2=(ImageButton) view.findViewById(R.id.mouth2);
		mouthButton3=(ImageButton) view.findViewById(R.id.mouth3);
		mouthButton4=(ImageButton) view.findViewById(R.id.mouth4);
		mouthButton5=(ImageButton) view.findViewById(R.id.mouth5);
		mouthButton6=(ImageButton) view.findViewById(R.id.mouth6);
		mouthButton7=(ImageButton) view.findViewById(R.id.mouth7);
		mouthButton8=(ImageButton) view.findViewById(R.id.mouth8);
		mouthButton9=(ImageButton) view.findViewById(R.id.mouth9);
		
		
		mouthButton1.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(1);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});

		
		mouthButton2.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton2.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(2);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton3.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton3.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(3);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton4.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton4.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(4);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton5.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton5.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(5);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton6.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton6.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(6);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton7.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton7.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(7);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton8.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton8.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(8);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		mouthButton9.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				mouthButton9.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setMouth(9);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});

		
		
	}
	
	
	public void draw(Canvas canvas){
		switch (mainactivity.person.getMouth()) {
		case 1:
			canvas.drawBitmap(mouth1Img, mainactivity.mouth_x, mainactivity.mouth_y, null);
			break;
			
		case 2:
			canvas.drawBitmap(mouth2Img, mainactivity.mouth_x, mainactivity.mouth_y, null);
			break;

		}
		//»­Í¼Íê³É£¬±£´æÍ¼Æ¬
		mainactivity.img = mainactivity.bitmap;
		
	}
	
	

}
