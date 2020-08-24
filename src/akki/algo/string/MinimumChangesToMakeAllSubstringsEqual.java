package akki.algo.string;

public class MinimumChangesToMakeAllSubstringsEqual {
    public static void main(String[] args) {
        System.out.println(countCharacters("aebaecedabbee"));
    }

    static int countCharacters(String str){
        int[] strArr = new int[26];
        int count=0;
        for (char ch:str.toCharArray()
             ) {
            if(strArr[ch-97]!=0){
                count++;
            }else {
                strArr[ch-97] = 1;
            }
        }
        return count;
    }
}
