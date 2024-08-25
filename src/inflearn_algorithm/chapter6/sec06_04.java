package inflearn_algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec06_04 {
    public static int[] solution(int S, int[] arr) {
        int[] cache = new int[S];
        for (int i : arr)
        {
            int pos = -1;
            for(int j = 0; j < cache.length; ++j) if(cache[j] == i) pos = j; //캐시 히트인지 미스인지 탐색
            if(pos == -1) //Cache Miss
            {
                for(int j = cache.length - 1; j > 0; --j) cache[j] = cache[j - 1]; //모든 작업을 한 칸씩 당긴다.
            }
            else //Chche Hit
            {
                for(int j = pos; j > 0; --j) cache[j] = cache[j - 1]; //pos 부터 맨 앞까지 작업을 한 칸씩 당긴다.
            }
            cache[0] = i; //새로운 작업을 맨 앞에 삽입
        }
        return cache;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(S, arr)) System.out.print(i + " ");
    }
}
