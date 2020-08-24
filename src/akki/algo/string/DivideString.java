package akki.algo.string;

import java.math.BigInteger;

public class DivideString {

    public static void main(String[] args) {
        divide("9843657348960239456034298679852349832749800",100);
    }

    static void divide(String str, int number){
        BigInteger numb = new BigInteger(str);
        numb = numb.divide(BigInteger.valueOf(number));
        System.out.println(numb.toString(10));
    }
}
