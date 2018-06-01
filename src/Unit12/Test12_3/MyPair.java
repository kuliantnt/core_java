package Unit12.Test12_3;

import java.util.Objects;

public class MyPair<T> {

    private T first;
    private T second;

    public MyPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public MyPair() {
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyPair)) {
            return false;
        }
        MyPair<?> myPair = (MyPair<?>) o;
        return Objects.equals(first, myPair.first) &&
                Objects.equals(second, myPair.second);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }
}
