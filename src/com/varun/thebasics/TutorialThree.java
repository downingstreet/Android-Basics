package com.varun.thebasics;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class TutorialThree extends Activity implements OnClickListener {
	
	ImageView display;
	int toPhone;
	//final MediaPlayer buttonSound = MediaPlayer.create(TutorialThree.this, R.raw.button_click);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);
		
		toPhone = R.drawable.wall1;
		
		
		
		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		ImageView image6 = (ImageView) findViewById(R.id.IVimage6);
		
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);
		
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.IVimage1:
			display.setImageResource(R.drawable.wall1);
			toPhone = R.drawable.wall1;
			break;
		
		case R.id.IVimage2:
			display.setImageResource(R.drawable.wall2);
			toPhone = R.drawable.wall2;
			break;
			
		case R.id.IVimage3:
			display.setImageResource(R.drawable.wall3);
			toPhone = R.drawable.wall3;
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.wall4);
			toPhone = R.drawable.wall4;
			break;
			
		case R.id.IVimage5:
			display.setImageResource(R.drawable.wall5);
			toPhone = R.drawable.wall5;
			break;
			
		case R.id.IVimage6:
			display.setImageResource(R.drawable.wall6);
			toPhone = R.drawable.wall6;
			break;
		case R.id.BsetWallpaper:
			//buttonSound.start();
			InputStream inputStream = getResources().openRawResource(toPhone);
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			Toast wallToast = Toast.makeText(TutorialThree.this," Wall paper Changed",Toast.LENGTH_LONG );
			wallToast.show();
			try{
				
				getApplicationContext().setWallpaper(bitmap);
				
				
			
			}catch(IOException e){
				e.printStackTrace();
			}
			break;
			}
		
		
	}
	
	

}
