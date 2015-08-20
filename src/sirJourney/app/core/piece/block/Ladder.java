package sirJourney.app.core.piece.block;

import sirJourney.app.core.piece.PieceData;;

// TODO: Auto-generated Javadoc
/**
 * The Class Ladder.
 */
public class Ladder extends Block {
	
	/**
	 * Instantiates a new ladder.
	 */
	public Ladder(){
		super();
		super.setChar(PieceData.charLadder);
	}
	
	/**
	 * Instantiates a new ladder.
	 *
	 * @param line the line
	 * @param column the column
	 */
	public Ladder(int line, int column){
		super(line, column);
		super.setChar(PieceData.charLadder);
	}
}
