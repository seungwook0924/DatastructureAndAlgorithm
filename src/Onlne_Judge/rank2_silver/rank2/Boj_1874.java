package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // n 입력 받음
        int max = 0; // 수열의 최대값 저장

        for (int i = 0; i < n; i++)
        {
            int input = Integer.parseInt(br.readLine());

            // 입력받은 값이 최대값보다 크다면
            while (max < input)
            {
                stack.push(++max); // 최대값까지 push
                sb.append("+").append(System.lineSeparator());
            }

            // 입력받은 값이 스택의 top에 있는지 확인
            if (stack.peek() == input)
            {
                stack.pop();
                sb.append("-").append(System.lineSeparator());
            }
            else
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}