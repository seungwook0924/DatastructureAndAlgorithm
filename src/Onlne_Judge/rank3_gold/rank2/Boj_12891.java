package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m을 받아옴
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 문자열을 받아옴
        String str = br.readLine();

        // 입력 받은 부분문자열에 포함되어야 할 최소 개수를 받아옴
        st = new StringTokenizer(br.readLine());
        int []inputACGT = new int[4]; // 입력 받은 부분문자열에 포함되어야 할 최소 개수
        for (int i = 0; i < inputACGT.length; i++) inputACGT[i] = Integer.parseInt(st.nextToken());

        // 초기 윈도우 구성
        int[] countACGT = new int[4]; // 구간에 포함된 부분문자열에 포함된 개수
        char[] window = new char[m];
        for (int i = 0; i < m; ++i) window[i] = str.charAt(i);

        // 슬라이딩 윈도우
        int endIndex = m + 1;
        for (int i = 1; i < n - window.length; ++i)
        {

        }
    }
}
