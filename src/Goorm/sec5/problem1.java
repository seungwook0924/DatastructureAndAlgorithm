package Goorm.sec5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무 수
        int m = Integer.parseInt(st.nextToken()); // 벌목 높이 제한
        int location = Integer.parseInt(st.nextToken()) - 1; // 처음 위치(인덱스는 0부터 시작하므로 1 빼줌)

        int[] h = new int[n]; // 나무 높이 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) h[i] = Integer.parseInt(st.nextToken());

        String[] d = new String[Integer.parseInt(br.readLine())]; // 행동 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < d.length; ++i) d[i] = st.nextToken();

        int answer = 0;
        for(int i = 0; i < d.length; ++i)
        {
            for(int j = 0; j < h.length; ++j) System.out.print(h[j] + " ");
            System.out.println("location = " + location);
            if(h[location] >= m)
            {
                answer += h[location];
                h[location] = 0;
            }

            if(d[i].equals("L")) location = (location - 1 + n) % n;
            else if(d[i].equals("R")) location = (location + 1) % n;

            for(int j = 0; j < h.length; ++j) ++h[j];
        }

        System.out.print(answer);
    }


//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int location = Integer.parseInt(st.nextToken()) - 1;
//
//        int[] h = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; ++i) h[i] = Integer.parseInt(st.nextToken());
//
//        int q = Integer.parseInt(br.readLine());
//        String[] d = new String[q];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < q; ++i) d[i] = st.nextToken();
//
//        long answer = 0;
//        for(int i = 0; i < q; ++i)
//        {
//            for(int j = 0; j < h.length; ++j) System.out.print(h[j] + i + " ");
//            System.out.println("location = " + location);
//            if(h[location] + i >= m)
//            {
//                answer += h[location] + i;
//                h[location] = -i;
//            }
//
//            if(d[i].equals("L")) location = (location - 1 + n) % n;
//            else if(d[i].equals("R")) location = (location + 1) % n;
//        }
//
//        System.out.print("정답: " + answer);
//    }
}
