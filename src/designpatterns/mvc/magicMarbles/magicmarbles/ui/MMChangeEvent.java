package designpatterns.mvc.magicMarbles.magicmarbles.ui;

import java.util.EventObject;

public class MMChangeEvent extends EventObject {
    private final boolean isGameOver;
    public MMChangeEvent(Object source, boolean isGameOver) {
        super(source);
        this.isGameOver = isGameOver;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
