package akki.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String s=br.readLine().trim();

            System.out.println(checkPangram (s)==true?1:0);
        }

    }

    public static boolean checkPangram  (String s)
    {
        Set<Character> set = new HashSet<>();
        for (char str:s.toCharArray()){
            if(('a'<=str && str<='z') ||  ('A'<=str && str<='Z')){
                set.add(Character.toUpperCase(str));
            }
            if(set.size() == 26)return true;

        }
        return false;
    }
}


