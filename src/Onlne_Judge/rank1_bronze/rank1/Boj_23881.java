package Onlne_Judge.rank1_bronze.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23881
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = N - 1; i > 0; --i)
        {
            int maxIndex = i;
            for(int j = i - 1; j >= 0; --j) if(arr[j] > arr[maxIndex]) maxIndex = j;
            if(maxIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
                ++count;
                if(count == K)
                {
                    System.out.println(arr[maxIndex] + " " + arr[i]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
