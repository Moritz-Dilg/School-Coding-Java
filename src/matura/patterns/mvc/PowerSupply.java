package matura.patterns.mvc;

public class PowerSupply {
    public static void main(String[] args) {
        Circuit circuit = new Circuit(100);
        Multimeter multimeter = new Multimeter(circuit, false);
        Multimeter multimeter1 = new Multimeter(circuit, true);
        circuit.setVoltage(100);
        circuit.setVoltage(200);
        circuit.setVoltage(300);
    }
}
