package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 힙 정렬 방식을 재정의
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>()
            {
                // compare() 메서드가 음수를 리턴하면 o1이 우선순위가 높은것
                // compare() 메서드가 양수를 리턴하면 o2이 우선순위가 높은것
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2); // 절댓값이 같다면 더 작은수 리턴
                    else return Math.abs(o1) - Math.abs(o2); // 양수 -> o1의 절댓값이 더큼 / 음수 -> o2의 절댓값이 더 큼
                }
            }
        );

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i)
        {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
            {
                if (absHeap.isEmpty()) sb.append(0).append(System.lineSeparator());
                else sb.append(absHeap.poll()).append(System.lineSeparator());
            }
            else absHeap.add(input);
        }

        System.out.print(sb);
    }
}
