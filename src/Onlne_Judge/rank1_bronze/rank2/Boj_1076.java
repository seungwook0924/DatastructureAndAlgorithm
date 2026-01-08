package Onlne_Judge.rank1_bronze.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();

        String string = String.valueOf(map.get(one)) + String.valueOf(map.get(two));
        long value = Long.parseLong(string) * (long)Math.pow(10, map.get(three));
        System.out.println(value);
    }
}
