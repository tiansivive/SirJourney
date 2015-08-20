package sirJourney.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class GameView extends View {
	private float imageX;
	private float imageY;
	ImageButton boutonUp; //bouton haut
	
	
	Bitmap blockBreakable = BitmapFactory.decodeResource(getResources(), R.drawable.block_breakable);
	
	Bitmap blockLadder = BitmapFactory.decodeResource(getResources(), R.drawable.block_ladder);
	
	Bitmap blockNotBreakable = BitmapFactory.decodeResource(getResources(), R.drawable.block_not_breakable);
	
	float imageSize;
	float tLigne, tColone;
	private char charToPut;
	private float positionInitialX, positionInitialY, positionFinalX, positionFinalY;
	
	char[][] terrainTest;
	
	//Constructeur
	public GameView(Context context) {
		super(context);
		tLigne = terrainTest.length;
		tColone = terrainTest[1].length;
	}

	public GameView(Context context, AttributeSet attrs) {

		super( context, attrs );
		tLigne = terrainTest.length;
		tColone = terrainTest[1].length;
	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {

		super( context, attrs, defStyle );
		tLigne = terrainTest.length;
		tColone = terrainTest[1].length;
	}

	private void initVar(){
		
		
		imageSize = 35;
		
			
		
		for(int i = 0; i < tLigne; i++){
			for(int j = 0; j < tColone; j++){
				terrainTest[i][j] = '-';
			}
		}
		
		
		
		this.positionInitialX = imageSize/2;
		this.positionInitialY = imageSize/2;
		this.positionFinalX = this.positionInitialX + (tColone * imageSize);
		this.positionFinalY = this.positionInitialY + (tLigne * imageSize);
		System.out.println(getWidth() + " ________________________  " + this.getHeight());
	}
	
	public void resetTerrain(){
		for(int i = 0; i < tLigne; i++){
			for(int j = 0; j < tColone; j++){
				terrainTest[i][j] = '-';
			}
		}
	}
	
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
		initVar();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		//Pour r残up屍er la position du doigt sur l'残rans
		float positionTouchX = event.getX();
		float positionTouchY = event.getY();
		
		PointF pointClicked = new PointF(positionTouchX, positionTouchY);
		
		try{
			PointF cellToChange = determineWhichCellHasBeenClicked(pointClicked);
		terrainTest[(int)cellToChange.y] [(int)cellToChange.x] = charToPut;
		}
		catch(Exception e){
			
		}
		return true;	
	}
	
	public void changeCharToPut(char newChar){
		charToPut = newChar;
	}
	
	public PointF determineWhichCellHasBeenClicked(PointF pointClicked) throws Exception{
		float leftLimit = positionInitialX,
			  rightLimit = positionFinalX,
			  
			  topLimit = positionInitialY,
			  bottomLimit = positionFinalY;
		
		float posXClicked = pointClicked.x,
			  posYClicked = pointClicked.y;
		
		if( posXClicked > rightLimit || posXClicked < leftLimit)
		{
			throw new Exception();
		}
		else if (posYClicked > bottomLimit || posYClicked < topLimit)
		{
			throw new Exception();
		}
		else
		{		
			posXClicked = (posXClicked - leftLimit) / imageSize;
			posYClicked = (posYClicked - topLimit) / imageSize;		
		}

		pointClicked.x = (int)posXClicked;
		pointClicked.y = (int)posYClicked;

		System.out.println(pointClicked.x +" && "+ pointClicked.y);
		System.out.println(posXClicked +" && "+ posYClicked);
		
		return pointClicked;
		
		
	}
	
	public void changeCoord(float x, float y){
		imageX = x;
		imageY = y;
	}
	
	/**
	 * @return the imageX
	 */
	public float getImageX() {
		return imageX;
	}

	/**
	 * @param imageX the imageX to set
	 */
	public void setImageX(float imageX) {
		this.imageX = imageX;
	}

	/**
	 * @return the imageY
	 */
	public float getImageY() {
		return imageY;
	}

	/**
	 * @param imageY the imageY to set
	 */
	public void setImageY(float imageY) {
		this.imageY = imageY;
	}

	
/*
 * (non-Javadoc)
 * @see android.view.View#onDraw(android.graphics.Canvas)
 */
	protected void onDraw(Canvas canvas) {
		
		canvas.drawLine(positionInitialX, positionInitialY, positionFinalX, positionInitialY, new Paint());
		canvas.drawLine(positionInitialX, positionFinalY, positionFinalX, positionFinalY, new Paint());
		canvas.drawLine(positionInitialX, positionInitialY, positionInitialX, positionFinalY, new Paint());
		canvas.drawLine(positionFinalX, positionInitialY, positionFinalX, positionFinalY, new Paint());
		
		//System.out.println("Ligne = " + tLigne + " Colone = " + tColone);
		
		float positionX = positionInitialX, positionY = positionInitialY;
		
		for(int i = 0; i < tLigne; i++){
			if(i != 0){
				positionY += imageSize;
			}
			
			positionX = positionInitialX;
			
			for(int j = 0; j < tColone; j++){
				if(j != 0){
					positionX += imageSize;
				}
				
				char temp = terrainTest[i][j];
								
				if(temp == 'b'){
				canvas.drawBitmap(blockBreakable, positionX, positionY, null);
				}
				else if (temp == 'e'){
					canvas.drawBitmap(blockLadder, positionX, positionY, null);	
				}
				else if (temp == 's'){
					canvas.drawBitmap(blockNotBreakable, positionX, positionY, null);	

				}
			}
		}
		/*
		for(float i = imageX; i < imageX + 100; i+=1){
			canvas.drawBitmap(monImage, i - (monImage.getWidth() / 2), imageY - (monImage.getHeight() / 2), null);
		}*/

		invalidate(); //Efface pour redessiner.
	}
	
	//Cette fonction est appeler lorsque la taille de l'残ran change, par exemple si il y a rotation de l'残ran.
	@Override
	   public void onSizeChanged(int w, int h, int oldW, int oldH) {
	      
	   }
	
}
