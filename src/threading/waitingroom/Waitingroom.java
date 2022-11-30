package threading.waitingroom;

import java.util.ArrayList;

public class Waitingroom {
    private ArrayList<Patient> patients;
    private int maxPatients;

    public Waitingroom() {
        patients = new ArrayList<Patient>();
        maxPatients = 10;
    }

    public synchronized void enter(Patient patient) {
        while (patients.size() >= maxPatients) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        patients.add(patient);
        System.out.println("Patient " + patient.id + " entered the waitingroom");
        notifyAll();
    }

    public synchronized Patient getPatient(int id) {
        while (patients.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        Patient p = patients.remove(0);
        System.out.println("Doctor " + id + " got a patient (" + p.id + ")");
        notifyAll();
        return p;
    }
}
