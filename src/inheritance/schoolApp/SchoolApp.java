package inheritance.schoolApp;

public class SchoolApp {
    public static void main(String[] args) {
        Person person = new Person("Felix", "Hofinger");
        System.out.println(person.getLastName() + ", " + person.getFirstName());
        person.setFirstName("Justin");
        person.setLastName("Gascho");
        System.out.println(person);

        Student student = new Student(1, "Constantin", "Barth");
        student.setNumber(5);
        System.out.println(student);

        Teacher teacher = new Teacher("Matthias", "Grimmer");
        System.out.println("ID Teacher: " + teacher.getId());
        System.out.println(teacher);
    }
}
