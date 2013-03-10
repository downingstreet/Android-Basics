package com.varun.thebasics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener {

	OurView v;
	Bitmap ball, blob;
	float x,y;
	Sprite sprite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
		blob = BitmapFactory.decodeResource(getResources(), R.drawable.spritesheet);
		x = y = 0;
		setContentView(v);
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}



	public class OurView extends SurfaceView implements Runnable{
		
		Thread t = null;
		SurfaceHolder holder;
		boolean isItOk = false;
		boolean spriteLoaded = false;
		
		
		public OurView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
			
		}

		public void run() {
			// TODO Auto-generated method stub
			sprite = new Sprite(this, blob);
			
			while(isItOk ==true){
				
				if(!holder.getSurface().isValid()){
					continue;
				}
				if(!spriteLoaded){
				
				spriteLoaded = true;
				}
				
				Canvas c = holder.lockCanvas();
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}
		}
		
		protected void onDraw(Canvas canvas){
			canvas.drawARGB(255, 150, 150, 10);
			canvas.drawBitmap(ball, x - (ball.getWidth()/2), y - (ball.getHeight()/2), null);
			sprite.onDraw(canvas);
		}
		
		public void pause(){
			isItOk = false;
			while(true){
				try{
					t.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				break;
			
			}
			
			t = null;
		}
		public void resume(){
			isItOk = true;
			t = new Thread(this);
			t.start();
		}
	}



	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		
		
		
		switch(me.getAction()){
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
			
		}
		
		return true;
	}

}
