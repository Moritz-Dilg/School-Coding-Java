package designpatterns.mvc.magicMarbles.magicmarbles.textui;

import designpatterns.mvc.magicMarbles.inout.In;
import designpatterns.mvc.magicMarbles.inout.Out;
import designpatterns.mvc.magicMarbles.magicmarbles.model.*;

public class Main {

	public static void main(String[] args) {
		MMGame field = createField();

		while (field.getGameState() == MMState.RUNNING) {
			printField(field);
			Out.println("********************");
			Out.println("Current Score: " + field.getGamePoints());
			Out.println("********************");
			doMove(field);

		}
		printField(field);

		Out.println();
		if (field.getGameState() == MMState.END) {
			Out.println("********************");
			Out.println("Final Score: " + field.getGamePoints());
			Out.println("********************");
			Out.println("Game over!");
		}
	}

	private static MMGame createField() {
		int width, height;

		do {
			Out.print("Height: ");
			height = In.readInt();
			In.readLine();
		} while (height < 1 || height > 99);

		do {
			Out.print("Width: ");
			width = In.readInt();
			In.readLine();
		} while (width < 1 || width > 99);

		return new MMGameImpl(width, height);
	}

	private static void doMove(MMGame field) {
		int row, col;

		do{
			Out.println("Please select a non-empty field");
			do {
				Out.print("Row: ");
				row = In.readInt();
				In.readLine();
			} while (row < 1 || row > field.getHeight());

			do {
				Out.print("Column: ");
				col = In.readInt();
				In.readLine();
			} while (col < 1 || col > field.getWidth());
		}while (field.getFieldState(row-1, col-1)== MMFieldState.EMPTY);

		try {
			field.select(row - 1, col - 1);
		} catch (MMException e) {
			System.out.println(e.getMessage());
			System.out.printf("Invalid move ");
		}
	}

	private static void printField(MMGame field) {
		Out.println();
		Out.print("  ");
		for (int col = 0; col < field.getWidth(); col++) {
			Out.print("  ");
			Out.print((col + 1) / 10);
		}
		Out.println();

		Out.print("  ");
		for (int col = 0; col < field.getWidth(); col++) {
			Out.print("  ");
			Out.print((col + 1) % 10);
		}
		Out.println();

		for (int row = 0; row < field.getHeight(); row++) {
			Out.print((row + 1) / 10);
			Out.print((row + 1) % 10);

			for (int col = 0; col < field.getWidth(); col++) {
				Out.print("  ");
				Out.print(field.getFieldState(row, col).toString());
			}
			Out.println();
		}
	}
}
