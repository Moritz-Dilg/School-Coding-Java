package designpatterns.mvc.magicMarbles.magicmarbles.model;

import designpatterns.mvc.magicMarbles.magicmarbles.ui.MMChangeListener;

/**
 * Definition of a magic marbles game.
 */
public interface MMGame {
	/**
	 * Width of the game board, i.e. the number of columns.
	 * 
	 * @return The width of the game board.
	 */
	int getWidth();

	/**
	 * Height of the game board, i.e. the number of rows.
	 * 
	 * @return The width of the field.
	 */
	int getHeight();

	/**
	 * The overall state of the game.
	 * 
	 * @return The game state.
	 */
	MMState getGameState();

	/**
	 * The current number of game points achieved.
	 * 
	 * @return The game points.
	 */
	int getGamePoints();
	
	/**
	 * The state of an individual field.
	 * 
	 * @param col
	 *            The column of the field to query.
	 * @param row
	 *            The row of the field to query.
	 * @return The state of the specified field.
	 */
	MMFieldState getFieldState(int row, int col);


	/**
	 * Selects the specified field. 
	 * 
	 * @param col
	 *            The column of the field to select.
	 * @param row
	 *            The row of the field to select.
	 * @throws MMException 
	 *            when move is invalid. 
	 */
	void select(int row, int col) throws MMException;

	void addValueChangeListener(MMChangeListener listener);
}
