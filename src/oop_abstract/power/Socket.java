package oop_abstract.power;

public abstract class Socket extends Device {
    Socket(String name) {
        super(name);
    }

    public abstract void plug(Device device);

    public abstract void unplug(Device device);

    public abstract boolean hasFreePlug();
}
