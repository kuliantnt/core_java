package unit4.Test4_6;

import unit4.Test4_7.*;
import static java.lang.System.*;

public class Package_Test {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Hacker", 50_000, 1989, 10, 1);
        harry.raiseSalary(5);
        out.printf("Name = %s, Salary = %.2f \n", harry.getName(), harry.getSalary());
    }
}