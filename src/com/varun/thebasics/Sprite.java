package com.varun.thebasics;

import com.varun.thebasics.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	
	int x, y, xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	OurView ov;
	int currentFrame = 0;
	int direction = 0;
	
	public Sprite(OurView ourView, Bitmap blob) {
		// TODO Auto-generated constructor stub
		b = blob;
		ov = ourView;
		height = b.getHeight() / 4;
		width = b.getWidth() / 3;
		x = y = 0;
		xSpeed = 5;
		ySpeed = 0;
	}

	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		update();
		int srcX = currentFrame * width;
		int srcY = direction * height;
		Rect src = new Rect(srcX, srcY, srcX + width,srcY + height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(b , src , dst, null);
	}

	private void update() {
		// TODO Auto-generated method stub
		// 0 up
		// 1 right
		// 2 left
		//3 down
		//facing down
		if(x > ov.getWidth() - width - xSpeed){
			xSpeed = 0;
			ySpeed= 5;
			direction = 3;
		}
		//going left
		if(y > ov.getHeight() - height - ySpeed){
			xSpeed = -5;
			ySpeed = 0;
			direction = 2;
		}
		//facing up
		if(x + xSpeed < 0 ){
			x = 0;
			xSpeed = 0;
			ySpeed = -5;
			direction = 0;
		}
		//facing right
		if(y + ySpeed < 0){
			y = 0;
			xSpeed = 5;
			ySpeed = 0;
			direction = 1;
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentFrame = ++currentFrame % 3;
		x += xSpeed;
		y += ySpeed;
	}

}
