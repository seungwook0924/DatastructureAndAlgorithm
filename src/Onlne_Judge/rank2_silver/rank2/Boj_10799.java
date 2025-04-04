package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '(') stack.push('('); // '(' 일 때
            else // ')' 일 때
            {
                stack.pop();
                if (input.charAt(i - 1) == '(') result += stack.size(); // 레이저일 때
                else result += 1; // 쇠막대기 종료일 때
            }
        }

        System.out.print(result);
    }
}
