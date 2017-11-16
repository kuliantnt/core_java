package Unit5.Test5_5;

public abstract class Person {
    public abstract String getDescription();
    private String name;

    /**
     * @param n the Person name
     */
    public Person(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}
