package akki.algo.string;

import java.util.*;
import java.util.stream.Collectors;

public class MatchSpecificPattern {

    private static Map<Character, Integer> map = new HashMap();

    public static void main(String[] args) {
        System.out.println(findMatchedWords(new ArrayList<String>(Arrays.asList("aab", "ddf", "fgdfg")), "ggn"));
    }

    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
    {
        String hash = encodeString(pattern);

        return (ArrayList<String>) dict.stream().filter(str -> encodeString(str).equals(hash)).collect(Collectors.toList());
        //add code here.
    }

   static String encodeString(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()
        ) {
            if(!map.containsKey(ch)){
                map.put(ch, ++i);
            }
            sb.append(map.get(ch));
        }
        return sb.toString();
    }


}
