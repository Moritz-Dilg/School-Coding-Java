package designpatterns.mvc.magicMarbles.magicmarbles.model;

import designpatterns.mvc.magicMarbles.magicmarbles.ui.MMChangeEvent;
import designpatterns.mvc.magicMarbles.magicmarbles.ui.MMChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation of the magic marbles game
 */
public class MMGameImpl implements MMGame {
    private final int width;
    private final int height;
    private MMState state;
    private int points;
    private final MMFieldState[][] field;

    private final List<MMChangeListener> listeners = new ArrayList<>();

    /**
     * Constructor
     *
     * @param width  the width of the game board
     * @param height the height of the game board
     */
    public MMGameImpl(int width, int height) {
        this.width = width;
        this.height = height;
        this.state = MMState.RUNNING;
        this.points = 0;
        this.field = new MMFieldState[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                switch (new Random().nextInt(3)) {
                    case 0 -> field[row][col] = MMFieldState.RED;
                    case 1 -> field[row][col] = MMFieldState.GREEN;
                    case 2 -> field[row][col] = MMFieldState.BLUE;
                }
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public MMState getGameState() {
        return state;
    }

    @Override
    public int getGamePoints() {
        return points;
    }

    @Override
    public MMFieldState getFieldState(int row, int col) {
        return field[row][col];
    }

    @Override
    public void select(int row, int col) throws MMException {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new MMException("Invalid field");
        }

        if (field[row][col] == MMFieldState.EMPTY) {
            throw new MMException("Field is empty");
        }

        if (!hasSameColorNeighbor(row, col)) {
            throw new MMException("No same color neighbours");
        }

        int fieldsRemoved = 1;
        fieldsRemoved += remove(row - 1, col, field[row][col]);
        fieldsRemoved += remove(row + 1, col, field[row][col]);
        fieldsRemoved += remove(row, col - 1, field[row][col]);
        fieldsRemoved += remove(row, col + 1, field[row][col]);

        field[row][col] = MMFieldState.EMPTY;
        points += fieldsRemoved * fieldsRemoved;

        removeEmptyFields();

        if (isGameOver()) {
            state = MMState.END;

            int remainingFields = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (field[j][i] != MMFieldState.EMPTY) remainingFields++;
                }
            }
            points -= remainingFields * 10;
            fireChangeEvent(true);
            return;
        }

        fireChangeEvent(false);
    }

    private boolean hasSameColorNeighbor(int row, int col) {
        if (row > 0 && field[row - 1][col] == field[row][col]) return true;
        if (row < height - 1 && field[row + 1][col] == field[row][col]) return true;
        if (col > 0 && field[row][col - 1] == field[row][col]) return true;
        return col < width - 1 && field[row][col + 1] == field[row][col];
    }

    @Override
    public void addValueChangeListener(MMChangeListener listener) {
        listeners.add(listener);
    }

    private void fireChangeEvent(boolean isGameOver) {
        MMChangeEvent evt = new MMChangeEvent(this, isGameOver);
        for (MMChangeListener l : listeners) {
            l.fieldChanged(evt);
        }
    }

    private boolean isGameOver() {
        if (field[height - 1][width - 1] == MMFieldState.EMPTY) {
            return true;
        }

        return !hasConnectedNeighbour();
    }

    private boolean hasConnectedNeighbour() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[j][i] == MMFieldState.EMPTY) continue;

                if (hasSameColorNeighbor(j, i)) return true;
            }
        }

        return false;
    }

    private int remove(int row, int col, MMFieldState color) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            return 0;
        }
        if (field[row][col] == MMFieldState.EMPTY) {
            return 0;
        }
        int points = 0;

        if (field[row][col] == color) {
            field[row][col] = MMFieldState.EMPTY;
            points += remove(row - 1, col, color);
            points += remove(row + 1, col, color);
            points += remove(row, col - 1, color);
            points += remove(row, col + 1, color);
            return points + 1;
        }
        return 0;
    }

    private void removeEmptyFields() {
        for (int i = 0; i < width; i++) {
            for (int j = height - 1, k = height - 1; k >= 0; j--) {
                if (j < 0) {
                    for (int l = k; l >= 0; l--) {
                        field[l][i] = MMFieldState.EMPTY;
                    }
                    break;
                }
                if (field[j][i] != MMFieldState.EMPTY) {
                    field[k][i] = field[j][i];
                    k--;
                }
            }
        }

        for (int i = width - 1, j = width - 1; j >= 0; i--) {
            if (i < 0) {
                for (int k = j; k >= 0; k--) {
                    for (int l = 0; l < height; l++) {
                        field[l][k] = MMFieldState.EMPTY;
                    }
                }
                break;
            }

            if (field[height - 1][i] != MMFieldState.EMPTY) {
                for (int k = 0; k < height; k++) {
                    field[k][j] = field[k][i];
                }
                j--;
            }

        }
    }
}
