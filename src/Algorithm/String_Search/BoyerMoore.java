package Algorithm.String_Search;

public class BoyerMoore
{
    static int bmMatch(String txt, String pat)
    {
        int pt;                           // txt를 따라가는 커서
        int pp;                           // pat를 따라가는 커서
        int txtLen = txt.length();        // txt의 문자 개수
        int patLen = pat.length();        // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1];    // 건너뛰기 표(skip 테이블)

        // skip 테이블 작성
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) skip[pt] = patLen;
        for (pt = 0; pt < patLen - 1; pt++) skip[pat.charAt(pt)] = patLen - pt - 1;  // pt == patLen - 1
        // 검색
        while (pt < txtLen)
        {
            pp = patLen - 1;                         // pat의 마지막 문자에 주목

            while (txt.charAt(pt) == pat.charAt(pp))
            {
                if (pp == 0) return pt;                  // 검색 성공
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;                             // 검색 실패
    }

    public static void main(String[] args) {

        String s1 = "ABASDASD";                   // 텍스트용 문자열
        String s2 = "ASD";                    // 패턴용 문자열

        int idx = bmMatch(s1, s2);                    // 문자열 s1에서 문자열 s2를 BM법으로 검색

        if (idx == -1) System.out.println(-1);
        else  System.out.println(idx);
    }
}