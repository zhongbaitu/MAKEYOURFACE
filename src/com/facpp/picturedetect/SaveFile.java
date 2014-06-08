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
			//������ʾ��ʽ
			SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-hh-mm-ss");     
			Date   curDate   =   new   Date(System.currentTimeMillis());//��ȡ��ǰʱ��     
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
				
				Toast.makeText(mainactivity, "ͼƬ�ɹ����浽ͼƬ���", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(mainactivity.ifLoaded==1){
			Toast.makeText(mainactivity, "����ûװ�粻�ܱ����", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(mainactivity, "ľ�пɱ����ͼƬ�", Toast.LENGTH_SHORT).show();
		}
	
	}

}
