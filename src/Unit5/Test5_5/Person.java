package Unit5.Test5_5;

public abstract class Person {

    private String name;

    /**
     * @param n the Person name
     */
    public Person(String n) {
        name = n;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
