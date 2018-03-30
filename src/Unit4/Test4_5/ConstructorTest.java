package Unit4.Test4_5;

import java.util.Locale;

public class ConstructorTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tom", 40_000);
        staff[1] = new Employee(60_000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.printf("name = %6s,\tid = %2d,\tsalary = %.2f\n"
                    , e.getName(), e.getId(), e.getSalary());
        }
    }
}

