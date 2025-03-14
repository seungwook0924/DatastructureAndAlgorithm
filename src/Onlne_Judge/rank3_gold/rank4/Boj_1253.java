package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1253
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n을 받아옴
        int n = Integer.parseInt(br.readLine());

        // 배열 생성 및 초기화
        int []arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // O(NlogN)
        System.out.println(func1(arr));
    }

    static int func1(int[] arr)
    {
        int count = 0;

        for (int currentIndex = 0; currentIndex < arr.length; ++currentIndex)
        {
            int currentValue = arr[currentIndex];
            int i = 0;
            int j = arr.length - 1;

            while (i < j)
            {
                if(arr[i] + arr[j] == currentValue)
                {
                    if ((i != currentIndex) && (j != currentIndex))
                    {
                        ++count;
                        break;
                    }
                    else if (i == currentIndex) ++i;
                    else if (j == currentIndex) --j;
                }
                else if(arr[i] + arr[j] < currentValue) ++i;
                else --j;
            }
        }
        return count;
    }
}

