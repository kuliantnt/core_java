package Unit4.Test4_3;

class Employee {

    private static int nextID = 1;
    private final String name;
    private int id;
    private double salary;

    Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    static int getNextID() {
        return nextID;
    }

    public static void main(String[] args) {
        Employee e = new Employee("harry", 50_000);
        System.out.println(e.getName() + " " + e.getSalary());
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    int getId() {
        return id;
    }

    void setId() {
        id = nextID;
        nextID++;
    }
}
