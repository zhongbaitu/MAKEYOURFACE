package com.facpp.picturedetect;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Entry extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//���ú���
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//ȫ��
		setContentView(R.layout.welcomelayout);
		
		new Handler().postDelayed(new Runnable() {
			

			public void run() {
				Intent mIntent=new Intent(Entry.this,MainActivity.class);
				startActivity(mIntent);
				finish();
				
			}
		}, 3000);
	}



}
