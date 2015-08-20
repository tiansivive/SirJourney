package sirJourney.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import android.widget.TextView;

public class SirJourneyActivityCredits extends Activity {

	
	TextView width, height, ligne, colone, tailleCellule, model;
	
	int sizeCellule, nLigne, nColone;
	float posXinit, posXfin, posYfin, posYinit, hauteur, largeur;
	
	/** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
        
        width = (TextView) findViewById(R.id.width);
        height = (TextView) findViewById(R.id.height);
        ligne = (TextView) findViewById(R.id.ligne);
        colone = (TextView) findViewById(R.id.colone);
        tailleCellule = (TextView) findViewById(R.id.tailleCellule);
        model = (TextView) findViewById(R.id.model);

        hauteur = getResources().getDisplayMetrics().heightPixels;
        largeur = getResources().getDisplayMetrics().widthPixels;
        
        width.setText(String.valueOf(largeur));
        height.setText(String.valueOf(hauteur));
        
        
        switch (getResources().getDisplayMetrics().densityDpi) {
		case DisplayMetrics.DENSITY_LOW:
			model.setText("LOW");
			tailleCellule.setText("22");
			sizeCellule = 22;
			break;
			
		case DisplayMetrics.DENSITY_MEDIUM:
			model.setText("MEDIUM");
			tailleCellule.setText("28");
			sizeCellule = 28;
		    break;
		
		case DisplayMetrics.DENSITY_HIGH:
			model.setText("HIGH");
			tailleCellule.setText("35");
			sizeCellule = 35;
			break;
			
		case DisplayMetrics.DENSITY_XHIGH:
			model.setText("X-HIGH");
			tailleCellule.setText("44");
			sizeCellule = 44;
		    break;
		}
        
        posXinit = sizeCellule / 2;
        posXfin = largeur - (sizeCellule/2);
        
        posYinit = posXinit;
        posYfin = hauteur - (3*sizeCellule);
        
        nLigne = (int) ((posXfin - posXinit) / sizeCellule);
        nColone = (int) ((posYfin - posYinit) / sizeCellule);
        
        ligne.setText(String.valueOf(nLigne));
        colone.setText(String.valueOf(nColone));
		
        
       }
    
}
