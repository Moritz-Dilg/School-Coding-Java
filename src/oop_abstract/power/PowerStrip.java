package oop_abstract.power;

public final class PowerStrip extends Socket {
    private final int n;
    private int currentDevices = 0;
    private final Device[] devices;

    public PowerStrip(String name, int nSockets) {
        super(name);
        devices = new Device[nSockets];
        n = nSockets;
    }

    @Override
    public int calcConsumption() {
        int consumption = 0;
        for (Device device : devices) {
            if (device != null) {
                consumption += device.calcConsumption();
            }
        }
        return consumption;
    }

    @Override
    public void plug(Device device) {
        if (hasFreePlug()) {
            devices[currentDevices] = device;
            currentDevices++;
        }
    }

    @Override
    public void unplug(Device device) {
        for (int i = 0; i < currentDevices; i++) {
            if (devices[i].name.equals(device.name)) {
                if (currentDevices - 1 - i >= 0) System.arraycopy(devices, i + 1, devices, i, currentDevices - 1);
                currentDevices--;
                return;
            }
        }

    }

    @Override
    public boolean hasFreePlug() {
        return currentDevices < n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentDevices - 1; i++) {
            sb.append(devices[i].name).append(", ");
        }
        sb.append(devices[currentDevices - 1].name);

        StringBuilder devicesSb = new StringBuilder();
        for (int i = 0; i < currentDevices; i++) {
            devicesSb.append(devices[i].toString()).append("\n");
        }
        return sb + " are connected to " + this.name + "\n" + devicesSb;
    }
}
