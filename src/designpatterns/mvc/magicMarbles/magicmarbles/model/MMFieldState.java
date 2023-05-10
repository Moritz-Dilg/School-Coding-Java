package designpatterns.mvc.magicMarbles.magicmarbles.model;

/**
 * The different possible states of a fields on the game board.
 */
public enum MMFieldState {

	/** The field is occupied with a red marble. */
	RED {
		public String toString(){
			return "r";
		}
	},
	
	/** The field is occupied with a green marble. */
	GREEN {
		public String toString(){
			return "g";
		}
	},
	
	/** The field is occupied with a blue marble. */
	BLUE {
		public String toString(){
			return "b";
		}
	},	
	
	/** The field is empty. */
	EMPTY {
		public String toString(){
			return " ";
		}
	}
	
}


