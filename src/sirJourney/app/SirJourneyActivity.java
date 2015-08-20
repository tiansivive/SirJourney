package sirJourney.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;

public class SirJourneyActivity extends Activity implements View.OnClickListener{
    TextView coucou = null;
    ImageButton GameButton = null, creditsButton = null, howToPlayButton = null;
    
	/** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GameButton = (ImageButton) findViewById(R.id.imageBeginJourney);
        GameButton.setOnClickListener(this);
        
        creditsButton = (ImageButton) findViewById(R.id.imageCredits);
        creditsButton.setOnClickListener(this);
        
        howToPlayButton = (ImageButton) findViewById(R.id.imageHowToPlay);
        howToPlayButton.setOnClickListener(this);
        
        
	
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case(R.id.imageBeginJourney):
			Intent myIntent = new Intent(v.getContext(), SirJourneyActivityGame.class);
        	startActivity(myIntent);
        	break;
		
		case(R.id.imageCredits):
			Intent myIntent2 = new Intent(v.getContext(), SirJourneyActivityCredits.class);
    		startActivity(myIntent2);
    		break;
    	
		case(R.id.imageHowToPlay):
			Intent myIntent3 = new Intent(v.getContext(), SirJourneyActivityHowToPlay.class);
			startActivity(myIntent3);
			break;
	
		}
	}
	
}