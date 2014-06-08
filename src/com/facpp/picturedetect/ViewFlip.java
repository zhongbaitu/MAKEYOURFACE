package com.facpp.picturedetect;



import com.facpp.picturedetect.R.color;

import android.content.Context;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class ViewFlip {
	MainActivity mainactivity;
	
	GestureDetector mGestureDetector;
	
	ViewFlipper vf;
	
	TextView eye,nose,mouth;
	
	View view1,view2,view3;
	
	public ViewFlip(Context context){
		
		this.mainactivity=(MainActivity) context;
		
		vf=(ViewFlipper) mainactivity.findViewById(R.id.viewFlipper1);
		
		LayoutInflater inflater = LayoutInflater.from(mainactivity);
		
		eye=(TextView) mainactivity.findViewById(R.id.textView1);
		nose=(TextView) mainactivity.findViewById(R.id.textView2);
		mouth=(TextView) mainactivity.findViewById(R.id.textView3);
		
		view1=inflater.inflate(R.layout.eyelayout, null);
		view2=inflater.inflate(R.layout.noselayout, null);
		view3=inflater.inflate(R.layout.mouthlayout, null);
		
		eye.setBackgroundColor(color.orange_a);
		
		vf.addView(view1);
		vf.addView(view2);
		vf.addView(view3);
		
		mGestureDetector=new GestureDetector(mainactivity,new MyGestureListener());
		

	}

	class MyGestureListener extends SimpleOnGestureListener{
		
	@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if(e2.getX()-e1.getX()<5){
				Animation lInAnim = AnimationUtils.loadAnimation(mainactivity, R.anim.push_left_in);       // 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）  
                Animation lOutAnim = AnimationUtils.loadAnimation(mainactivity, R.anim.push_left_out);     // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）  
       
                vf.setInAnimation(lInAnim);  
                vf.setOutAnimation(lOutAnim);  
                vf.showPrevious();
				
				if(vf.getCurrentView().equals(view1)){
					eye.setBackgroundColor(color.orange_a);
					nose.setBackgroundColor(Color.argb(0, 0, 0, 0));
					mouth.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}else if(vf.getCurrentView().equals(view2)){
					eye.setBackgroundColor(Color.argb(0, 0, 0, 0));
					nose.setBackgroundColor(color.orange_a);
					mouth.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}else if(vf.getCurrentView().equals(view3)){
					mouth.setBackgroundColor(color.orange_a);
					eye.setBackgroundColor(Color.argb(0, 0, 0, 0));
					nose.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}
				
			}else if(e2.getX()-e1.getX()>5){
				
                
                Animation rInAnim = AnimationUtils.loadAnimation(mainactivity, R.anim.push_right_in);  // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）  
                Animation rOutAnim = AnimationUtils.loadAnimation(mainactivity, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）  
                
                vf.setInAnimation(rInAnim);  
                vf.setOutAnimation(rOutAnim); 
				
                vf.showNext();
				 
				
				if(vf.getCurrentView().equals(view1)){
					eye.setBackgroundColor(color.orange_a);
					nose.setBackgroundColor(Color.argb(0, 0, 0, 0));
					mouth.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}else if(vf.getCurrentView().equals(view2)){
					eye.setBackgroundColor(Color.argb(0, 0, 0, 0));
					nose.setBackgroundColor(color.orange_a);
					mouth.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}else if(vf.getCurrentView().equals(view3)){
					mouth.setBackgroundColor(color.orange_a);
					eye.setBackgroundColor(Color.argb(0, 0, 0, 0));
					nose.setBackgroundColor(Color.argb(0, 0, 0, 0));
				}
			}
			//return super.onFling(e1, e2, velocityX, velocityY);
			vf.setClickable(false);
			return true;
		}
		

		
		
		
	}

}
