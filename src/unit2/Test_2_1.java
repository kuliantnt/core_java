package Unit2;

/**
 * the Unit2.Test_2_1
 * @version 1.0
 * @author 哭脸tnt
 */
public class Test_2_1 {
    public static void main(String[] args) {
        String[] geeting = new String[3];
        geeting[0] = "Welcome to Core Java";
        geeting[1] = "By Cay Horstmann";
        geeting[2] = "and Gary Cornell";
        for (String g : geeting) {
            System.out.println(g);
        }
    }
}
