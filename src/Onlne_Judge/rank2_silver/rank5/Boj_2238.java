package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_2238 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, String> firstName = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            count.put(price, count.getOrDefault(price, 0) + 1);
            if (!firstName.containsKey(price)) firstName.put(price, name);
        }

        int bestCount = Integer.MAX_VALUE;
        int bestPrice = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int price = e.getKey();
            int c = e.getValue();

            if (c < bestCount || (c == bestCount && price < bestPrice)) {
                bestCount = c;
                bestPrice = price;
            }
        }

        System.out.println(firstName.get(bestPrice) + " " + bestPrice);
    }
}
