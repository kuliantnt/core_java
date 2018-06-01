package extend.collection;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionEasyTest {
    @Test
    void TestIndexOfSubList(){
        List<String> list = Arrays.asList("s","t","a","r");
        List<String> list2 = Arrays.asList("t","a","r");
        System.out.println(Collections.indexOfSubList(list, list2));
        System.out.println(Collections.lastIndexOfSubList(list, list2));


    }
}
