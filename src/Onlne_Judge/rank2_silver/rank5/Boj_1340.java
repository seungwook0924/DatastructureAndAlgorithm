package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1340 {
    static boolean isLeap(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        // 예: "February 29, 2004 12:00"
        // tokens: [February, 29,, 2004, 12:00]
        StringTokenizer st = new StringTokenizer(s);

        String monthStr = st.nextToken();
        String dayComma = st.nextToken(); // "29,"
        int day = Integer.parseInt(dayComma.substring(0, dayComma.length() - 1));
        int year = Integer.parseInt(st.nextToken());
        String time = st.nextToken(); // "12:00"

        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));

        Map<String, Integer> monthIndex = new HashMap<>();
        monthIndex.put("January", 1);
        monthIndex.put("February", 2);
        monthIndex.put("March", 3);
        monthIndex.put("April", 4);
        monthIndex.put("May", 5);
        monthIndex.put("June", 6);
        monthIndex.put("July", 7);
        monthIndex.put("August", 8);
        monthIndex.put("September", 9);
        monthIndex.put("October", 10);
        monthIndex.put("November", 11);
        monthIndex.put("December", 12);

        int m = monthIndex.get(monthStr);

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year)) days[2] = 29;

        // 이전 달까지 총 일수
        int daysBefore = 0;
        for (int i = 1; i < m; i++) daysBefore += days[i];

        // 해 시작부터 지난 "분"
        long passedMinutes = ((long) (daysBefore + (day - 1)) * 24 * 60) + (long) hour * 60 + minute;

        // 해 전체 "분"
        long totalMinutes = (long) (isLeap(year) ? 366 : 365) * 24 * 60;

        double percent = (double) passedMinutes / (double) totalMinutes * 100.0;

        System.out.println(percent);
    }
}
