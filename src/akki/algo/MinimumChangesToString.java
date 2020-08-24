package akki.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinimumChangesToString {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map= new HashMap<>();
            char[] charArr = bufferedReader.readLine().toCharArray();
            for (char c:charArr){
                map.compute(c, (character, count) -> map.containsKey(character)?++count:0);
            }
            System.out.println(map.values().stream().mapToInt(value -> value).sum());
        }

    }
}
