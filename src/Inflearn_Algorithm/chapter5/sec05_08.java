package Inflearn_Algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sec05_08 {
    public static class Person
    {
        private int priority;
        private int idx;

        Person(int priority, int idx)
        {
            this.priority = priority;
            this.idx = idx;
        }
    }

//    public static int solution(int N, int M, int[] arr)
//    {
//        Queue<Person> queue = new LinkedList<>();
//        for (int i = 0; i < N; ++i) queue.offer(new Person(arr[i], i));
//
//        int count = 0;
//        while (!queue.isEmpty())
//        {
//            Person current = queue.poll();
//            boolean hasHigherPriority = false;
//
//            for (Person person : queue) {
//                if (person.priority > current.priority)
//                {
//                    hasHigherPriority = true;
//                    break;
//                }
//            }
//
//            if (hasHigherPriority) queue.offer(current);
//            else
//            {
//                count++;
//                if (current.idx == M) return count;
//            }
//        }
//
//        return count;
//    }

    public static int solution(int N, int M, int[] arr)
    {
        Queue<Person> que = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++)
        {
            que.offer(new Person(arr[i], i));
            pq.offer(arr[i]);
        }

        int count = 0;
        while (!que.isEmpty())
        {
            Person current = que.poll();
            if (current.priority == pq.peek())
            {
                count++;
                pq.poll();
                if (current.idx == M) return count;
            }
            else que.offer(current);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, M, arr));
    }
}
