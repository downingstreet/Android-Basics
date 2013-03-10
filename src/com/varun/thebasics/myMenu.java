package com.varun.thebasics;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class myMenu extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	//button sound
		
		final MediaPlayer buttonSound = MediaPlayer.create(myMenu.this, R.raw.button_click);
		
		
		
		//button references
		Button tut1 = (Button) findViewById(R.id.tutorial1);
		tut1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALONE"));
			}
		});
		
		Button tut2 = (Button) findViewById(R.id.tutorial2);
		tut2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALTWO"));
			}
		});

		Button tut3 = (Button) findViewById(R.id.tutorial3);
		tut3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALTHREE"));
			}
		});
	
	

	
		Button tut4 = (Button) findViewById(R.id.tutorial4);
		tut4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALFOUR"));
			}
		});
	
		
		Button tut5 = (Button) findViewById(R.id.tutorial5);
		tut5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALFIVE"));
			}
		});

		Button tut6 = (Button) findViewById(R.id.tutorial6);
		tut6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.varun.thebasics.TUTORIALSIX"));
			}
		});
	
	
	}

	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.main_menu, menu);
		return true;
	 }
	
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menuSweet:
			 startActivity(new Intent("com.varun.thebasics.SWEET"));
			return true;
		case R.id.menuToast:
			Toast myToast = Toast.makeText(myMenu.this,"This is a Toast",Toast.LENGTH_LONG);
			myToast.show();
			return true;
		
		
		
		}
		
		
		return false;
	}

	

}