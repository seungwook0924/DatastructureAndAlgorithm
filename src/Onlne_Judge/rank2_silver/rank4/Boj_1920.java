package Onlne_Judge.rank2_silver.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) nArr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) mArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nArr);
        for(int i : mArr)
        {
//            if(Arrays.binarySearch(nArr, i) >= 0) System.out.println(1); // 이미 누군가 구현해놓은 이진탐색 라이브러리
            if(binarySearch(nArr, i) >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }

    static int binarySearch(int[] arr, int value)
    {
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while (leftPtr <= rightPtr)
        {
            int mid = (leftPtr + rightPtr) / 2;

            if(arr[mid] == value) return mid; // 찾은 경우
            if(arr[mid] > value) rightPtr = mid - 1; // 왼쪽 부분 탐색
            else leftPtr = mid + 1; // 오른쪽 부분 탐색
        }

        return -1;
    }
}
