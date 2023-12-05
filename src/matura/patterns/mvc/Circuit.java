package matura.patterns.mvc;

import java.util.ArrayList;

public class Circuit {
    private final int resistance;
    private double voltage;
    private ArrayList<VoltageChangeListener> listeners = new ArrayList<>();

    public Circuit(int resistance) {
        this.resistance = resistance;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
        fireChangeEvent();
    }

    public void addValueChangeListener(VoltageChangeListener listener) {
        listeners.add(listener);
    }

    public void removeValueChangeListener(VoltageChangeListener listener) {
        listeners.remove(listener);
    }

    private void fireChangeEvent() {
        VoltageChangeEvent evt = new VoltageChangeEvent(this, voltage, voltage / resistance);
        for (VoltageChangeListener l : listeners) {
            l.voltageChanged(evt);
        }
    }
}
