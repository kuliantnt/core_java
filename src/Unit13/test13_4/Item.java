package Unit13.test13_4;

import java.util.Objects;

public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(getDescription(), item.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDescription(), partNumber);
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber,o.partNumber);
    }
}
