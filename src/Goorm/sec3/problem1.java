package Goorm.sec3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        double oneRM = W * (1 + R / 30.0);

        System.out.println((int)oneRM); // 소수점 이하 버림
    }
}
