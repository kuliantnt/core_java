package Unit2.Test2_1;

/**
 * the Unit2.Test2_1.Welcome
 *
 * @author 哭脸tnt
 * @version 1.0
 */
public class Welcome {

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
