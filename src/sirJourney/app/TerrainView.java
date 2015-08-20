package sirJourney.app;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TerrainView extends View{
	private float imageX;
	private float imageY;
	private Paint paintImage = new Paint();
	ArrayList<Bitmap> imageDisponible = new ArrayList<Bitmap>();
	int index = 1;
	
	Drawable d1, d2;
	
	
	
	Bitmap breakableBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_breakable);
	Bitmap ladderBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_ladder);

	public TerrainView(Context context) {
		super(context);
		  Resources res = context.getResources();
		    d1 = res.getDrawable(R.drawable.block_shock_absorver);
		    d2 = res.getDrawable(R.drawable.block_ladder);
		    
	}
	
	public TerrainView(Context context, AttributeSet attrs) {

		super( context, attrs );
	}

	public TerrainView(Context context, AttributeSet attrs, int defStyle) {

		super( context, attrs, defStyle );
	}

	private void prepareImage(){
		Bitmap breakableBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_breakable);
		imageDisponible.add(breakableBlock);
		Bitmap nonBreakableBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_not_breakable);
		imageDisponible.add(nonBreakableBlock);
		Bitmap ladderBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_ladder);
		imageDisponible.add(ladderBlock);
		Bitmap spongeBlock = BitmapFactory.decodeResource(getResources(), R.drawable.block_shock_absorver);
		imageDisponible.add(spongeBlock);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
		//Pour récupérer la position du doigt sur l'écrans
		/*
		float positionTouchX = event.getX();
		float positionTouchY = event.getY();
		
		imageX = positionTouchX;
		imageY = positionTouchY;
				
		return true;
		*/
	}

	protected void onDraw(Canvas canvas) {
		
		for(float i = imageX; i < imageX + 100; i+=1){
			canvas.drawBitmap(breakableBlock, imageX - (breakableBlock.getWidth() / 2), imageY - (breakableBlock.getHeight() / 2), null);
		}
		
		invalidate(); //Efface pour redessiner.
	}

}
