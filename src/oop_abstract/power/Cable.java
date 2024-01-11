package oop_abstract.power;

public final class Cable extends Socket {
    private Device device;

    public Cable(String name) {
        super(name);
        device = null;
    }

    @Override
    public void plug(Device device) {
        this.device = device;
    }

    @Override
    public void unplug(Device device) {
        if (this.device == device)
            this.device = null;
    }

    @Override
    public boolean hasFreePlug() {
        return device == null;
    }

    @Override
    public int calcConsumption() {
        if (device != null)
            return device.calcConsumption();

        return 0;
    }

    @Override
    public String toString() {
        if (device == null)
            return name + "is not connected";
        else
            return device.name + " is connected to " + name + "\n" + device;
    }
}
