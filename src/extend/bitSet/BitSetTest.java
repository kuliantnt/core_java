package extend.bitSet;

import java.util.BitSet;
import org.junit.jupiter.api.Test;

class BitSetTest {
    @Test
    void TestLength(){
        BitSet bitSet = new BitSet(11);
        bitSet.set(5);
        System.out.println(bitSet.length());
        bitSet.clear(5);
        System.out.println(bitSet.length());
    }

}
