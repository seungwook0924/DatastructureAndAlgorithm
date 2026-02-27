package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_7596 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            if (n == 0) break;

            List<String> books = new ArrayList<>(n);
            for (int i = 0; i < n; i++) books.add(br.readLine());

            Collections.sort(books);

            sb.append(tc).append('\n');
            for (String s : books) sb.append(s).append('\n');

            tc++;
        }

        System.out.print(sb.toString());
    }
}
