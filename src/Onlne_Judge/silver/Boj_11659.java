package Onlne_Judge.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String inputArr = br.readLine();
        st = new StringTokenizer(inputArr);

        int[] numArr = new int[N];
        for (int i = 0; i < numArr.length; i++) numArr[i] = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) prefixSum[i] = numArr[i - 1] + prefixSum[i-1];

        for(int i = 0; i < M ; ++i)
        {
            String inputTwo = br.readLine();
            st = new StringTokenizer(inputTwo);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int sum = prefixSum[end] - prefixSum[start - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
