package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2343
{
    static int N, M;
    static int[] lesson;
    static int left, right;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lesson = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; ++i)
        {
            lesson[i] = Integer.parseInt(st.nextToken());
            sum += lesson[i];
            left = Math.max(left, lesson[i]);
        }
        right = sum;

        System.out.println(binarySearch(left,right));

    }

    public static long binarySearch(long leftPtr, long rightPtr)
    {
        while(leftPtr <= rightPtr)
        {
            long sum = 0;
            long mid = (leftPtr + rightPtr) / 2;
            int count = 1;

            for (int i = 0; i < N; ++i)
            {
                sum += lesson[i];
                if(sum > mid)
                {
                    sum = lesson[i]; // 새 블루레이 시작
                    ++count; // 블루레이 개수 증가
                }
            }
            if(count <= M) rightPtr = mid - 1; //필요한 블루레이 갯수가 M보다 작거나 같으면
            else leftPtr = mid + 1; //총 필요한 블루레이 개수가 M보다 크다면
        }
        return leftPtr;
    }
}
