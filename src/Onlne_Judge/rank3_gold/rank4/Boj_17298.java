package Onlne_Judge.rank3_gold.rank4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17298
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n과 수열을 받아옴
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[n]; // 정답을 저장하는 배열 선언

        // 스택을 이용해서 정답 배열을 초기화
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; ++i)
        {
            while ((!stack.isEmpty()) && (arr[stack.peek()] < arr[i])) answer[stack.pop()] = arr[i];
            stack.push(i);
        }

        while (!stack.isEmpty()) answer[stack.pop()] = -1; // 나머지는 -1로 저장

        for (int i = 0; i < n; ++i) bw.write(answer[i] + " ");
        bw.flush();
    }
}
