package Onlne_Judge.rank1_bronze.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Boj_1924
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        // System.out.println(func1(month, day));
        System.out.println(func2(month, day));
    }


    // LocalDate 사용
    static String func1(int month, int day)
    {
        LocalDate date = LocalDate.of(2007, month, day);
        return date.getDayOfWeek().toString().substring(0, 3);
    }

    // 수학 구현
    static String func2(int month, int day)
    {
        String[] dayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}; // 요일
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daySum = 0;
        for (int i = 0; i < month; ++i) daySum += months[i]; // 날짜 합
        daySum += day - 1; // 당일은 더하지 않음
        return dayOfWeek[daySum % 7];
    }
}
