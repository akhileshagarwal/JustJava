package akki.algo.string;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TinyURL {

    private static final char[] corpus   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public static void main(String[] args) {
        System.out.println(getBase62From10(12345));
        System.out.println(getBase10From62("bDmDCbMnmit"));



        System.out.println(getBase10From62("dnh"));
    }

    /*
     * Note if seed is unique then generated base62 number will be unique as well under load balance make sure this value is not same.
     */
    public static final String getBase62From10(final long seed)
    {
        String number = seed + "";
        char[] buf = new char[number.length()];
        int charPos = number.length() - 1;
        BigInteger bigIntegerNumber = new BigInteger(number);
        BigInteger radix = BigInteger.valueOf(62);

        while (bigIntegerNumber.compareTo(radix) >= 0)
        {
            buf[charPos--] = corpus[bigIntegerNumber.mod(radix).intValue()];
            bigIntegerNumber = bigIntegerNumber.divide(radix);
        }
        buf[charPos] = corpus[bigIntegerNumber.intValue()];
        return new String(buf, charPos, (number.length() - charPos));
    }
    /**
     * a positive number in base 62
     * @return the same number, in base 10
     */
    public static final String getBase10From62(final String url)
    {
        BigInteger value = BigInteger.ZERO;
        for (char ch : url.toCharArray())
        {
            value = value.multiply(BigInteger.valueOf(62));
            if ('0' <= ch && ch <= '9')
            {
                value = value.add(BigInteger.valueOf(ch - '0' + 52));
            }
            if ('a' <= ch && ch <= 'z')
            {
                value = value.add(BigInteger.valueOf(ch - 'a'));
            }
            if ('A' <= ch && ch <= 'Z')
            {
                value = value.add(BigInteger.valueOf(ch - 'A' + 26));
            }
        }
        return value.toString();
    }

}

class GFG1 {
    private static final char[] corpus   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String tinyURL = getBase62From10(n);
            String id = getBase10From62(tinyURL);
            System.out.println(tinyURL);
            System.out.println(id);
        }
    }

    public static final String getBase62From10(final long seed)
    {
        String number = seed + "";
        char[] buf = new char[number.length()];
        int charPos = number.length() - 1;
        BigInteger bigIntegerNumber = new BigInteger(number);
        BigInteger radix = BigInteger.valueOf(62);

        while (bigIntegerNumber.compareTo(radix) >= 0)
        {
            buf[charPos--] = corpus[bigIntegerNumber.mod(radix).intValue()];
            bigIntegerNumber = bigIntegerNumber.divide(radix);
        }
        buf[charPos] = corpus[bigIntegerNumber.intValue()];
        return new String(buf, charPos, (number.length() - charPos));
    }
    /**
     * a positive number in base 62
     * @return the same number, in base 10
     */
    public static final String getBase10From62(final String url)
    {
        BigInteger value = BigInteger.ZERO;
        for (char ch : url.toCharArray())
        {
            value = value.multiply(BigInteger.valueOf(62));
            if ('0' <= ch && ch <= '9')
            {
                value = value.add(BigInteger.valueOf(ch - '0' + 52));
            }
            if ('a' <= ch && ch <= 'z')
            {
                value = value.add(BigInteger.valueOf(ch - 'a'));
            }
            if ('A' <= ch && ch <= 'Z')
            {
                value = value.add(BigInteger.valueOf(ch - 'A' + 26));
            }
        }
        return value.toString();
    }
}



