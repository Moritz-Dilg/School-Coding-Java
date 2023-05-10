package designpatterns.mvc.valueApp;

import java.util.EventObject;

public class ValueChangeEvent extends EventObject {
    private final int value;

    public ValueChangeEvent(Object source, int value) {
        super(source);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
