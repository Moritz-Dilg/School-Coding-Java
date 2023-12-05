package matura.patterns.mvc;

import java.util.EventObject;

public class VoltageChangeEvent extends EventObject {
    private final double voltage, current;

    public VoltageChangeEvent(Object source, double voltage, double current) {
        super(source);
        this.voltage = voltage;
        this.current = current;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getCurrent() {
        return current;
    }
}
