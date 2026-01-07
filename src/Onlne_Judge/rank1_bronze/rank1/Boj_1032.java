package Onlne_Judge.rank1_bronze.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; ++i) arr[i] = br.readLine();

        for (int i = 0; i < arr[0].length(); ++i) {

            boolean flag = false;
            int ptr = 0;

            for (int j = 1; j < n; ++j) {
                ptr = j;
                if (arr[j].charAt(i) != arr[j - 1].charAt(i)) {
                    flag = true;
                    break;
                }
            }

            if (flag) sb.append("?");
            else sb.append(arr[ptr].charAt(i));
        }

        System.out.println(sb);
    }
}
