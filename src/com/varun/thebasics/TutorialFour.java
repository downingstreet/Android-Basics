package com.varun.thebasics;

import android.app.Activity;
import android.os.Bundle;

public class TutorialFour extends Activity {
	
	DrawingTheBall v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new DrawingTheBall(TutorialFour.this);
		setContentView(v);
	}
	
	

}
