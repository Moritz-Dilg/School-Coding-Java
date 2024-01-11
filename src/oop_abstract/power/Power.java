package oop_abstract.power;

public class Power {
    public static void main(String[] args) {
        Cable c1 = new Cable("c1");
        PowerStrip ps1 = new PowerStrip("ps1", 5);
        PowerStrip ps2 = new PowerStrip("ps2", 4);

        Computer c11 = new Computer("c11", 700);
        Computer c12 = new Computer("c12", 300);
        Computer c21 = new Computer("c21", 600);
        Computer c22 = new Computer("c22", 1500);

        Lamp l11 = new Lamp("l11", 30);
        Lamp l12 = new Lamp("l12", 50);
        Lamp l21 = new Lamp("l21", 10);
        Lamp l22 = new Lamp("l22", 70);

        c1.plug(ps1);

        ps1.plug(c11);
        ps1.plug(l11);
        ps1.plug(c12);
        ps1.plug(l12);
        ps1.plug(ps2);

        ps2.plug(c21);
        ps2.plug(l21);
        ps2.plug(c22);
        ps2.plug(l22);

        System.out.println(c1);
        System.out.println("Total consumption: " + c1.calcConsumption() + " watts");
    }
}
