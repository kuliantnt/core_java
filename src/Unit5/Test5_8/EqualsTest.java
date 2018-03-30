package Unit5.Test5_8;

import Unit5.Test5_10.Manager;
import Unit5.Test5_9.Employee;
import java.util.Locale;

public class EqualsTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee alice1 = new Employee("Alice Adams", 75_000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75_000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50_000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice1 == alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + (alice1.equals(alice3)));

        System.out.println("alice1.equals(bob): " + (alice1.equals(bob)));

        Manager carl = new Manager("Carl Craker", 80_000, 1987, 12, 15);
        Manager boss = new Manager("Carl Craker", 80_000, 1987, 12, 15);
        boss.setBonus(5_000);
        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boos): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashcode():" + carl.hashCode());
    }
}
