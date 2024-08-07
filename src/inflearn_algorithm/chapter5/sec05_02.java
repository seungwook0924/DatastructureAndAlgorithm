package inflearn_algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sec05_02 {
//    public static String solution(String str)
//    {
//        StringBuilder sb = new StringBuilder();
//        int left = 0;
//        for(char c : str.toCharArray())
//        {
//            if(c == '(') ++left;
//            else if(c == ')') --left;
//            else if(left == 0) sb.append(c);
//        }
//        return sb.toString();
//    }

    public static String solution(String str)
    {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray())
        {
            if(c == ')') while(stack.pop() != '(');
            else stack.push(c);
        }

        for(int i = 0; i < stack.size(); ++i) sb.append(stack.get(i));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
