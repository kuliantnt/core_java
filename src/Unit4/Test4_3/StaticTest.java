package Unit4.Test4_3;




import java.util.Locale;

public class StaticTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tom", 40_000);
        staff[1] = new Employee("Dick", 60_000);
        staff[2] = new Employee("Harry", 65_000);

        for (Employee e : staff) {
            e.setId();
            System.out.printf("name = %6s,\tid = %2d,\tsalary = %.2f\n"
                    , e.getName(), e.getId(), e.getSalary());
        }
        int n = Employee.getNextID();
        System.out.println("Next available id= " + n);
    }
}
