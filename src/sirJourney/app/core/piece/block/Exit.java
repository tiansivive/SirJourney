package sirJourney.app.core.piece.block;

import sirJourney.app.core.piece.PieceData;;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit.
 */
public class Exit extends Block {

	/**
	 * Instantiates a new exit.
	 */
	public Exit(){
		super();
		super.setChar(PieceData.charExit);
	}
	
	/**
	 * Instantiates a new exit.
	 *
	 * @param line the line
	 * @param column the column
	 */
	public Exit(int line, int column){
		super(line, column);
		super.setChar(PieceData.charExit);
	}
	
}
