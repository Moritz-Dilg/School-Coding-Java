package matura.patterns.mvc;

public class Multimeter {

    public Multimeter(Circuit circuit, boolean printCurrent) {
        VoltageChangeListener listener = new VoltageChangeListener() {
            @Override
            public void voltageChanged(VoltageChangeEvent evt) {
                if (printCurrent) System.out.println("Current: " + evt.getCurrent() + "A");
                else System.out.println("Voltage: " + evt.getVoltage() + "V");
            }
        };
        circuit.addValueChangeListener(listener);
    }
}
