package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891
{
    static int[] inputACGT = new int[4]; // 입력 받은 부분문자열에 포함되어야 할 최소 개수
    static int[] countACGT = new int[4];  // 구간에 포함된 부분문자열에 포함된 개수

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0; // 정답을 저장하는 변수

        // n과 m을 받아옴
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 문자열을 받아옴
        char[] str = br.readLine().toCharArray();

        // 입력 받은 부분문자열에 포함되어야 할 최소 개수를 받아옴
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputACGT.length; i++) inputACGT[i] = Integer.parseInt(st.nextToken());

        // 초기 윈도우 구성
        for (int i = 0; i < m; ++i) add(str[i]);
        if (check()) ++count;

        // 슬라이딩 윈도우
        for (int startPtr = 0; startPtr < n - m; ++startPtr)
        {
            int endPtr = startPtr + m;
            remove(str[startPtr]); // str의 앞 문자열을 제거
            add(str[endPtr]); // str의 뒷 문자열을 추가
            if (check()) ++count;
        }

        System.out.println(count);
    }

    static void add(char c)
    {
        if (c == 'A') ++countACGT[0];
        else if (c == 'C') ++countACGT[1];
        else if (c == 'G') ++countACGT[2];
        else ++countACGT[3];
    }

    static void remove(char c)
    {
        if (c == 'A') --countACGT[0];
        else if (c == 'C') --countACGT[1];
        else if (c == 'G') --countACGT[2];
        else --countACGT[3];
    }

    static boolean check()
    {
        for (int i = 0; i < 4; ++i) if (countACGT[i] < inputACGT[i]) return false;
        return true;
    }
}
