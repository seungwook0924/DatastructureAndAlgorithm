package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1312 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int remainder = A % B;
        int answer = 0;

        for (int i = 0; i < N; ++i) {
            remainder *= 10;
            answer = remainder / B;
            remainder %= B;
        }

        System.out.println(answer);
    }
}
