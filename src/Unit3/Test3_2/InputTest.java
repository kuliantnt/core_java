package Unit3.Test3_2;

import java.util.Scanner;


/**
 * Class InputTest
 *
 * @author lianlian
 * @version 1.0
 */
public class InputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        //get second input
        System.out.print("What old are you? ");
        int age = in.nextInt();

        System.out.printf("Hello%s. Next year, you'll be %d", name, age + 1);
    }
}
