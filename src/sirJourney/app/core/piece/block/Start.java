package sirJourney.app.core.piece.block;

import sirJourney.app.core.piece.PieceData;;

// TODO: Auto-generated Javadoc
/**
 * The Class Start.
 */
public class Start extends Block{

	/**
	 * Instantiates a new start.
	 */
	public Start(){
		super();
		super.setChar(PieceData.charStart);
	}
	
	/**
	 * Instantiates a new start.
	 *
	 * @param line the line
	 * @param column the column
	 */
	public Start(int line, int column){
		super(line, column);
		super.setChar(PieceData.charStart);
	}
	
}
