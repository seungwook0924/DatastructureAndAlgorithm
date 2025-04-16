package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_5635
{
    static class Person
    {
        String name;
        int year;
        int month;
        int day;

        Person(String name, int day, int month, int year)
        {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];

        for(int i = 0; i < n; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr[i] = new Person(name, day, month, year);
        }

        Arrays.sort(arr, (p1, p2) -> {
            if (p1.year != p2.year) return p1.year - p2.year;
            else if (p1.month != p2.month) return p1.month - p2.month;
            else return p1.day - p2.day;
        });

        System.out.println(arr[arr.length - 1].name);
        System.out.println(arr[0].name);
    }
}
