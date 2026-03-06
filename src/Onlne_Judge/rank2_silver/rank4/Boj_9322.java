package Onlne_Judge.rank2_silver.rank4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_9322 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());

            String[] key1 = br.readLine().split(" ");
            String[] key2 = br.readLine().split(" ");
            String[] cipher = br.readLine().split(" ");

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) map.put(key2[i], i);

            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                int idx = map.get(key1[i]);
                answer[i] = cipher[idx];
            }

            for (String s : answer) System.out.print(s + " ");
            System.out.println();
        }
    }
}
