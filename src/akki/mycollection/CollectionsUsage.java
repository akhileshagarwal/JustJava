package akki.mycollection;

import java.util.Collections;
import java.util.Map;

public class CollectionsUsage {

    public static void main(String[] args) {
        Map<Integer, Integer> integerIntegerMap= Collections.emptyMap();
        integerIntegerMap.put(1,1);
        integerIntegerMap.put(4,4);
        integerIntegerMap.put(2,2);

        integerIntegerMap.keySet().forEach(System.out::println);
    }
}
