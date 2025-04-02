package Onlne_Judge.rank3_gold.rank1;

import java.io.*;

public class Boj_1300
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long leftPtr = 1, rightPtr = K;
        long answer = 0;

        // 이진 탐색 수행
        while (leftPtr <= rightPtr)
        {
            long mid = (leftPtr + rightPtr) / 2;
            long count = 0;

            for (int i = 1; i < N + 1; ++i) count += Math.min(mid / i, N); // mid보다 작거나 같은 수는 몇 개인지 계산

            if (count < K) leftPtr = mid + 1;
            else
            {
                answer = mid;
                rightPtr = mid - 1;
            }
        }

        bw.write(answer + System.lineSeparator());
        bw.flush();
    }
}
