package sirJourney.app.core.piece.block;

import sirJourney.app.core.piece.Piece;


// TODO: Auto-generated Javadoc
/**
 * The Class Block.
 */
public abstract class Block extends Piece {

	/** The char of a block. */
	//protected char charBlock;
	
	/**
	 * Instantiates a new block.
	 */
	public Block() {
		super();
	}
	
	/**
	 * Instantiates a new block.
	 *
	 * @param line the number of line
	 * @param column the number of column
	 */
	public Block(int line, int column) {
		super(line, column);
	}

	
}
