package Inflearn_Algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec01_10 {
    public static int[] solution(String s, char t) {
        int[] numArr = new int[s.length()];
        int ptr = 1000;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == t)
            {
                ptr = 0;
                numArr[i] = ptr;
            }
            else numArr[i] = ++ptr;
        }

        for(int i = s.length() - 1; i >= 0; --i){
            if(s.charAt(i) == t) ptr = 0;
            else
            {
                ++ptr;
                numArr[i] = (numArr[i] < ptr) ? numArr[i] : ptr; //Math.min(numArr[i], ptr)
            }
        }
        return numArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        Character t = st.nextToken().charAt(0);
        for (int i : solution(s, t))
        {
            System.out.print(i + " ");
        }
    }
}
