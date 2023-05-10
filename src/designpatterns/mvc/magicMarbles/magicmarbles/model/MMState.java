package designpatterns.mvc.magicMarbles.magicmarbles.model;

/**
 * The different possible states of a game.
 */
public enum MMState {
	/** The game is still running, i.e. fields can be opened. */
	RUNNING,
	/** The game is terminated, i.e., there are no more two equally colored marbles next to each other. */
	END
}
