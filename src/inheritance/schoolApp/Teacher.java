package inheritance.schoolApp;

public class Teacher extends Person{
    private final String id;

    Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.id = lastName.substring(0, 3) + firstName.charAt(0);
    }

    String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id " + id + ": " + super.toString();
    }
}
