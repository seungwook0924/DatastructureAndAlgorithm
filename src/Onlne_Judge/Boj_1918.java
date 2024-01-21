package Onlne_Judge;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Boj_1918{
    public static int priority(char operator)
    {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String prefix = br.readLine();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < prefix.length(); ++i)
        {
            char ch = prefix.charAt(i);
            if (ch == '(') stack.push(ch);
            else if (ch == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(') postfix.append(stack.pop());
                stack.pop(); // Pop '('
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) postfix.append(stack.pop());
                stack.push(ch);
            }
            else postfix.append(ch);
        }
        while (!stack.isEmpty()) postfix.append(stack.pop());
        System.out.print(postfix.toString());
    }
}
