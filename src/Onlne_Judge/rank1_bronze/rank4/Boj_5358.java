package Onlne_Judge.rank1_bronze.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5358
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;

        while(((input = br.readLine()) != null) && (!input.isEmpty()))
        {
            for(int i = 0; i < input.length(); i++)
            {
                char c = input.charAt(i);
                if(c == 'i') sb.append('e'); // i -> e
                else if(c == 'e') sb.append('i'); // e -> i
                else if(c == 'I') sb.append('E'); // I -> E
                else if(c == 'E') sb.append('I'); // E -> I
                else sb.append(c);

            }
            sb.append(System.lineSeparator()); // 운영체제에 맞는 줄바꿈 문자를 변환
        }

        System.out.print(sb);
    }
}
