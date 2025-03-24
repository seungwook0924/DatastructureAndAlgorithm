package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1427
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        int[] numArr = new int[charArr.length];
        for (int i = 0; i < charArr.length; ++i) numArr[i] = Character.getNumericValue(charArr[i]); // 문자를 숫자로 변환

        // 선택 정렬
        for(int i = 0; i < numArr.length - 1; ++i)
        {
            int tmp = numArr[i];
            int minValue = numArr[i];
            int minIndex = i;
            for(int j = i + 1; j < numArr.length; ++j)
            {
                if(numArr[j] < minValue)
                {
                    minValue = numArr[j];
                    minIndex = j;
                }
            }
            numArr[i] = numArr[minIndex];
            numArr[minIndex] = tmp;
        }

        // 내림차순이므로 역순으로 출력
        for(int i = numArr.length - 1; i >= 0; --i) System.out.print(numArr[i]);
    }
}
