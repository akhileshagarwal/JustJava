package akki.java10.features;

import java.util.ArrayList;
import java.util.Arrays;

public class Akhilesh {

    public static void main(String[] args) {
        var name = "Akhilesh";
        var idList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        var num = idList.stream().filter(integer -> integer > 7).findAny().orElseThrow();

        System.out.println(num.intValue()  );





    }
}
