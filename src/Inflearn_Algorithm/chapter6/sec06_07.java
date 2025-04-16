package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sec06_07 {

    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static ArrayList<Point> solution(ArrayList<Point> list) {
        Collections.sort(list, (a , b) ->{
            if (a.x == b.x) return a.y - b.y;
            else return a.x - b.x;
        });
        return list;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < N; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point newPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(newPoint);
        }
        for (Point point : solution(list)) System.out.println(point.x + " " + point.y);
    }
}
