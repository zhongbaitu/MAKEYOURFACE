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

public class Nose {
	MainActivity mainactivity;
	

	ImageButton noseButton1,noseButton2,noseButton3,noseButton4,noseButton5,noseButton6,noseButton7,noseButton8,noseButton9;
	
//	ViewFlip viewFlip;
	
	private Bitmap noseImg;

	public Nose(Context context) {

		this.mainactivity=(MainActivity) context;
		

		
//		viewFlip=new ViewFlip(mainactivity);
		
		View view=mainactivity.viewflip.vf.getChildAt(1);
		
		noseImg=BitmapFactory.decodeResource(mainactivity.getResources(), R.drawable.nose1);
		
		
		noseButton1=(ImageButton) view.findViewById(R.id.nose1);
		noseButton2=(ImageButton) view.findViewById(R.id.nose2);
		noseButton3=(ImageButton) view.findViewById(R.id.nose3);
		noseButton4=(ImageButton) view.findViewById(R.id.nose4);
		noseButton5=(ImageButton) view.findViewById(R.id.nose5);
		noseButton6=(ImageButton) view.findViewById(R.id.nose6);
		noseButton7=(ImageButton) view.findViewById(R.id.nose7);
		noseButton8=(ImageButton) view.findViewById(R.id.nose8);
		noseButton9=(ImageButton) view.findViewById(R.id.nose9);
		
		noseButton1.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(1);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});	
		
		noseButton2.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton2.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(2);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton3.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton3.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(3);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton4.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton4.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(4);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton5.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton5.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(5);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton6.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton6.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(6);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton7.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton7.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(7);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		noseButton8.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton8.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(8);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});
		
		
		noseButton9.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				noseButton9.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						mainactivity.person.setNose(9);
						mainactivity.draw(); 
						
					}
				});
				return mainactivity.viewflip.mGestureDetector.onTouchEvent(event);
			}
		});

	}
	
	
	public void draw(Canvas canvas){
		switch (mainactivity.person.getNose()) {
		case 1:
			canvas.drawBitmap(noseImg, mainactivity.nose_x, mainactivity.nose_y, null);
			break;

		}
		//»­Í¼Íê³É£¬±£´æÍ¼Æ¬
		mainactivity.img = mainactivity.bitmap;
		
	}
	
	

}
