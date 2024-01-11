package inheritance.schoolApp;

public class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void set(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return this.firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
