package Inflearn_Algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sec05_04 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if(Character.isDigit(c)) stack.push(Character.getNumericValue(c));
            else
            {
                int right = stack.pop();
                int left = stack.pop();
                if(c == '+') stack.push(left + right);
                else if(c == '-') stack.push(left - right);
                else if(c == '*') stack.push(left * right);
                else if(c == '/') stack.push(left / right);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
