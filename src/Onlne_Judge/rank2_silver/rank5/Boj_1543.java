package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int count = 0;
        int idx = 0;

        while (true) {
            int found = doc.indexOf(word, idx);

            if (found == -1) break;

            count++;
            idx = found + word.length();
        }

        System.out.println(count);
    }
}
