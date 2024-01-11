package inheritance.schoolApp;

public class Student extends Person {
    private int number;

    Student(int number, String firstName, String lastName) {
        super(firstName, lastName);
        this.number = number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "Number " + number + ": " + super.toString();
    }
}
