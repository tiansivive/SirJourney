package sirJourney.app.core.piece.character;

import sirJourney.app.core.piece.PieceData;;

// TODO: Auto-generated Javadoc
/**
 * The Class Hero.
 */
public class Hero extends Character {

	/** The life hero. */
	private int lifeHero = PieceData.lifeBeginHero;
	
	/** The Hero state */
	private boolean alive;
	
	/**
	 * Instantiates a new hero.
	 */
	public Hero(){
		super();
		super.setChar(PieceData.charHero);
		this.alive = true;
	}
	
	/**
	 * Instantiates a new hero.
	 *
	 * @param line the number of line
	 * @param column the number of column
	 */
	public Hero(int line, int column){
		super(line,column);
		super.setChar(PieceData.charHero);
		this.alive = true;
	}
	
	/**
	 * @return the lifeHero
	 */
	public int getLifeHero() {
		return lifeHero;
	}

	/**
	 * @param lifeHero the lifeHero to set
	 */
	public void setLifeHero(int lifeHero) {
		this.lifeHero = lifeHero;
	}

	/**
	 * Take life to the hero.
	 */
	public void takeLife(){
		this.lifeHero--;
		if(this.lifeHero <= 0){
			this.alive = false;
		}
	}
	
	/**
	 * Adds the life to the hero.
	 */
	public void addLife(){
		this.lifeHero++;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive state to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}
