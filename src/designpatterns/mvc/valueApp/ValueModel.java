package designpatterns.mvc.valueApp;

import java.util.ArrayList;
import java.util.List;

public class ValueModel {
    private int value;
    private final List<ValueChangeListener> listeners = new ArrayList<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        fireChangeEvent();
    }

    public void incr() {
        this.value++;
        fireChangeEvent();
    }

    public void decr() {
        this.value--;
        fireChangeEvent();
    }

    public void reset() {
        this.value = 0;
        fireChangeEvent();
    }

    public void addValueChangeListener(ValueChangeListener listener) {
        listeners.add(listener);
    }

    public void removeValueChangeListener(ValueChangeListener listener) {
        listeners.remove(listener);
    }

    private void fireChangeEvent() {
        ValueChangeEvent evt = new ValueChangeEvent(this, value);
        for (ValueChangeListener l : listeners) {
            l.valueChanged(evt);
        }
    }
}
