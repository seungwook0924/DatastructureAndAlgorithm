package Inflearn_Algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec05_05 {
    public static int solution(String str) {
        int count = 0;
        int metalStick = 0;
        for(int i = 0; i < str.length(); ++i)
        {
            if(str.charAt(i) == '(') ++metalStick;
            else if(str.charAt(i - 1) == '(') //레이저
            {
                --metalStick;
                if(metalStick > 0) count += metalStick;
            }
            else //막대 끝
            {
                --metalStick;
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
