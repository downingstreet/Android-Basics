package com.varun.thebasics;



import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.content.Intent;

public class main extends Activity {
    
	
	MediaPlayer logoMusic;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        logoMusic = MediaPlayer.create(main.this, R.raw.kalimba);
		logoMusic.start();
		
		Thread logoTimer = new Thread()
		{
			public void run()
			{
				try{
					sleep(2000);
					Intent menuIntent = new Intent("com.varun.thebasics.MENU");
					startActivity(menuIntent);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				finally{
					finish();
				}
				
			}
			
		};
		logoTimer.start();
	
	}
    



@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	logoMusic.release();
}



@Override
protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
}

@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
}

}