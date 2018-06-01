package Unit6.Test6_1;

import Unit6.Test6_2.Employee;
import java.util.Arrays;


public class EmployeeSortTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        Arrays.sort(staff);
        for (Employee e : staff) {
            System.out.printf("name = %s, salary = %.2f\n", e.getName(), e.getSalary());
        }
    }
}
