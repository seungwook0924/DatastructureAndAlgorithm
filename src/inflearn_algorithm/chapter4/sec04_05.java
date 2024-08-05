package inflearn_algorithm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sec04_05 {
    public static int solution(int N, int K , Integer[] arr) {
        int count = 1;
        TreeSet<Integer> reverseTreeSet = new TreeSet<>(Comparator.reverseOrder());
        for(int i = 0 ; i < N - 2 ; ++i)
        {
            for(int j = i + 1 ; j < N - 1 ; ++j)
            {
                for(int k = j + 1 ; k < N ; ++k) reverseTreeSet.add(arr[i] + arr[j] + arr[k]);
            }
        }

        for(Integer i : reverseTreeSet) if(count++ == K) return i;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, K, arr));
    }
}