package Onlne_Judge.rank3_gold.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1931
{
    // 회의 클래스
    static class Meeting
    {
        int startTime; // 회의 시작시간
        int endTime; // 회의 종료시간

        public Meeting(int startTime, int endTime)
        {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(startTime, endTime)); // 객체 생성 및 추가
        }

        // 정렬
        meetings.sort((m1, m2) -> {
            if(m1.endTime == m2.endTime) return m1.startTime - m2.startTime; // 종료시간이 같다면 시작시간 순으로 정렬
            return m1.endTime - m2.endTime; // 종료시간이 작은 순으로 정렬
        });

        int count = 0;
        int lastMeetingTime = 0; // 가장 최근에 끝난 회의시간
        for(Meeting m : meetings)
        {
            if(m.startTime >= lastMeetingTime) // 현재 회의시간이 가장 최근에 끝난 회의 시간보다 크거나 같다면
            {
                ++count;
                lastMeetingTime = m.endTime; // 가장 최근에 끝난 회의시간 업데이트
            }
        }
        System.out.print(count);
    }
}
