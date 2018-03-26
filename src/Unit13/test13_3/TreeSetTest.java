package Unit13.test13_3;

import Unit13.test13_4.Item;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget" ,4562));
        parts.add(new Item("Model",9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>((o1, o2) -> {
            String descrA = o1.getDescription();
            String descrB = o2.getDescription();
            return descrA.compareTo(descrB);
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
