package Goorm.sec4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 0; i < t; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if(operation.equals("+")) sum += a + b;
            else if(operation.equals("-")) sum += a - b;
            else if(operation.equals("/")) sum += a / b;
            else if(operation.equals("*")) sum += a * b;
        }
        System.out.print(sum);
    }
}
