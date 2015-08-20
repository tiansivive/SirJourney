package sirJourney.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class SirJourneyActivityGame extends Activity
{
	GameView test;
	Button boutonUp, boutonLeft, boutonRight, boutonDown; //bouton haut
	ImageButton boutonRun, boutonEchelle, boutonBlocCasse, boutonBlocNonCassable, boutonEmpty;
	float previousPosition;

	float translation = 50; 
	TranslateAnimation moveUp, moveDown, moveLeft, moveRight;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_mode);
		
		test = (GameView)findViewById(R.id.gameView1);
		//test.changeCoord(200, 200);

		moveUp = new TranslateAnimation(0,0,0,-translation);
		moveDown = new TranslateAnimation(0,0,0,translation);
		moveLeft = new TranslateAnimation(0,-translation,0,0);
		moveRight = new TranslateAnimation(0,translation,0,0);
		

		defineAnimation();

		boutonRun = (ImageButton)findViewById(R.id.boutonRun);		
		boutonRun.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				test.resetTerrain();

			}
		});

		boutonEchelle = (ImageButton)findViewById(R.id.boutonEchelle);		
		boutonEchelle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				test.changeCharToPut('e');

			}
		});

		boutonBlocCasse = (ImageButton)findViewById(R.id.boutonBlocCasse);		
		boutonBlocCasse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				test.changeCharToPut('b');

			}
		});		
		
		boutonBlocNonCassable = (ImageButton)findViewById(R.id.BoutonBlocNonCassable);		
		boutonBlocNonCassable.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				test.changeCharToPut('s');

			}
		});
		
		boutonEmpty = (ImageButton)findViewById(R.id.BoutonEmpty);		
		boutonEmpty.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				test.changeCharToPut('-');

			}
		});

/*
		boutonUp = (Button)findViewById(R.id.buttonUp);		
		boutonUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				test.startAnimation(moveUp);

			}
		});

		boutonLeft = (Button)findViewById(R.id.buttonLeft);
		boutonLeft.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				test.startAnimation(moveLeft);

			}
		});

		boutonRight = (Button)findViewById(R.id.buttonRight);
		boutonRight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				test.startAnimation(moveRight);

			}
		});

		boutonDown = (Button)findViewById(R.id.buttonDown);
		boutonDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				test.startAnimation(moveDown);

			}
		}); 
		*/
	}

	private void defineAnimation() {
		moveUp.setDuration(500);
		moveDown.setDuration(500);
		moveLeft.setDuration(500);
		moveRight.setDuration(500);
		
		moveUp.setFillEnabled(true);
		moveUp.setFillAfter(true);
		
		this.moveUp.setAnimationListener(new AnimationListener(){
			@Override
			public void onAnimationEnd(Animation animation) {
				float newPosition = previousPosition - translation;
				System.out.println("Previous Position: " + previousPosition + " TranslationTop: " + translation + " New Position: " + newPosition);
				test.setImageY(newPosition);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
			@Override
			public void onAnimationStart(Animation animation) {
				previousPosition = test.getImageY();
			}
		});
		
		this.moveDown.setAnimationListener(new AnimationListener(){
			@Override
			public void onAnimationEnd(Animation animation) {
				float newPosition = previousPosition + translation;
				System.out.println("Previous Position: " + previousPosition + " TranslationTop: " + translation + " New Position: " + newPosition);

				test.setImageY(newPosition);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
			@Override
			public void onAnimationStart(Animation animation) {
				previousPosition = test.getImageY();
			}
		}); 
		
		this.moveLeft.setAnimationListener(new AnimationListener(){
			@Override
			public void onAnimationEnd(Animation animation) {
				float newPosition = previousPosition - translation;
				System.out.println("Previous Position: " + previousPosition + " TranslationTop: " + translation + " New Position: " + newPosition);

				test.setImageX(newPosition);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
			@Override
			public void onAnimationStart(Animation animation) {
				previousPosition = test.getImageX();
			}
		}); 
		this.moveRight.setAnimationListener(new AnimationListener(){
			@Override
			public void onAnimationEnd(Animation animation) {
				float newPosition = previousPosition + translation;
				System.out.println("Previous Position: " + previousPosition + " TranslationTop: " + translation + " New Position: " + newPosition);

				test.setImageX(newPosition);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
			@Override
			public void onAnimationStart(Animation animation) {
				previousPosition = test.getImageX();
			}
		}); 
	}
}
