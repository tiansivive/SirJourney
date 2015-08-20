package sirJourney.app.core.piece;

// TODO: Auto-generated Javadoc
/**
 * The Class Piece.
 * 
 */
public abstract class Piece {

	/** The column and the line of a piece. */
	private int
		line,
		column;
	
	/** The char that define a piece. */
	private char 
		charPiece;
	
	/**
	 * Default constructor for a piece.
	 */
	public Piece(){
	}

	/**
	 * Instantiates a new piece.
	 *
	 * @param line the line
	 * @param column the column
	 */
	public Piece(int line, int column){
		this.line = line;
		this.column = column;
	}
	
	/**
	 * Gets the line.
	 *
	 * @return the line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Sets the line.
	 *
	 * @param line the new line
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Sets the column.
	 *
	 * @param column the new column
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the charPiece
	 */
	public char getChar() {
		return charPiece;
	}

	/**
	 * @param charPiece the charPiece to set
	 */
	public void setChar(char charPiece) {
		this.charPiece = charPiece;
	}
	
}
