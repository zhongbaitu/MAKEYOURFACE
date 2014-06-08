package com.facpp.picturedetect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.http.conn.ManagedClientConnection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.widget.Toast;

public class SaveFile {
	
	MainActivity mainactivity;
	
	SaveFile(Context context){
		this.mainactivity=(MainActivity) context;
	}
	
	public void save(Bitmap bitmap){
		if(mainactivity.ifLoaded==2){
			//设置显示格式
			SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-hh-mm-ss");     
			Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间     
			String   str   =   formatter.format(curDate);  
			
			File file=new File(Environment.getExternalStorageDirectory().toString() + "/DCIM");
			if(!file.exists()){
				file.mkdir();
			}
			File imageFile=new File(file,str+".jpg");
			
			try {
				imageFile.createNewFile();
				FileOutputStream fos=new FileOutputStream(imageFile);
				bitmap.compress(CompressFormat.JPEG, 50, fos);
				fos.flush();
				fos.close();
				
				Toast.makeText(mainactivity, "图片成功保存到图片相册", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(mainactivity.ifLoaded==1){
			Toast.makeText(mainactivity, "都还没装扮不能保存喔", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(mainactivity, "木有可保存的图片喔", Toast.LENGTH_SHORT).show();
		}
	
	}

}
