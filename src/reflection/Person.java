package reflection;

public class Person {
    private String name;
    private final int age;

    private int x = 42;

    public Person () {
        this("John", 30);
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
}
