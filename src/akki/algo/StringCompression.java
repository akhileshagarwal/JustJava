package akki.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StringCompression {

    public static void main(String[] args) {
        compress(new char[0]);
    }


    public static int compress(char[] chars) {
        Map<Character, Integer> map = new TreeMap<>();
        int len = chars.length;
            for (char c: chars){
                map.compute(c, (character, integer) ->
                     map.containsKey(character)? map.get(character).intValue()+1: 1
                );
            }
            int counter =0;
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()){

                char[] entryValueArr;
                char entryKey = characterIntegerEntry.getKey();
                Integer entryValue = characterIntegerEntry.getValue();

                chars[counter] = entryKey;
                if(entryValue!=1){

                    entryValueArr = String.valueOf(entryValue).toCharArray();
                    for (char c:entryValueArr){
                        counter++;
                        chars[counter]=c;
                    }
                }
                counter++;

            }
           return  map.values().stream().map(String::valueOf).map(String::length).mapToInt(Integer::intValue).sum()+map.size();

    }
}
