package inflearn_algorithm.chapter1;

import java.io.IOException;
import java.util.Scanner;

public class sec01_04 {
    public static void solution(String[] str) {
        StringBuilder sb = new StringBuilder(new String(""));
        for (String s : str) {
            sb.append(new StringBuilder(s).reverse()).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = sc.next();
        }
        solution(strings);
    }
}
