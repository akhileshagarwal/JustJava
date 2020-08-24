package akki.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LargestWordInDict {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String longestWord = null;
        for (int i = 0; i < n; i++) {
            int dictCount = Integer.parseInt(bf.readLine());
            List<String> list = new ArrayList<>(Arrays.asList(bf.readLine().split(" ")));
            String str = bf.readLine();
            Map<Character, Integer> strMap = countLetterFreq(str);

            int finalWordCount = 0;
            for (String dictString : list
            ) {
                int wordCount = 0;
                Map<Character, Integer> dictWordMap = countLetterFreq(dictString);
                Iterator<Character> it = strMap.keySet().iterator();
                while (it.hasNext()) {
                    Character chKey = it.next();
                    int count = strMap.get(chKey);

                    if (dictWordMap.containsKey(chKey)) {
                        if (dictWordMap.get(chKey) >= count) {
                            wordCount += count;
                        } else {
                            wordCount += dictWordMap.get(chKey);
                        }
                    }
                }
                if (wordCount > finalWordCount) {
                    finalWordCount = wordCount;
                    longestWord = dictString;
                }
            }

            System.out.println(longestWord);
        }


    }

    static Map<Character, Integer> countLetterFreq(String str) {
        Map<Character, Integer> map = new HashMap<>();
        str.chars().mapToObj(c -> (char) c).forEach(character -> {

            map.compute(character, (character1, integer) -> integer == null ? 1 : ++integer);
        });
        return map;
    }
}
