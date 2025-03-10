package Onlne_Judge.rank1_bronze.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11720
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(func3(n, str));
    }

    static int func1(int n, String str)
    {
        int sum = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < n; i++) sum += Character.getNumericValue(charArray[i]);
        return sum;
    }

    static int func2(int n, String str)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += Character.getNumericValue(str.charAt(i));
        return sum;
    }

    static int func3(int n, String str)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        return sum;
    }
}
