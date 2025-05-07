package Goorm.sec11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem3
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, Q 입력 처리
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 구름이가 갖고 있는 아이템을 셋에 담는다.
        Set<String> Goorm = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String item = st.nextToken();
            Goorm.add(item);
        }

        // 친구가 갖고 있는 아이템을 셋에 담는다.
        Set<String> Friend = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String item = st.nextToken();
            Friend.add(item);
        }

        // Q번의 교환 요청 처리
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            // a를 구름이가 갖고 있고, b를 친구가 갖고 있으면 교환한다.
            if (Goorm.contains(a) && Friend.contains(b)) {

                // 구름이는 a를, 친구는 b를 잃는다.
                Goorm.remove(a);
                Friend.remove(b);

                // 구름이는 b를, 친구는 a를 얻는다.
                Goorm.add(b);
                Friend.add(a);
            }
        }

        // 아이템의 이름을 사전순으로 출력하기 위해 리스트에 담고 정렬한다.
        List<String> res = new ArrayList<>(Goorm);
        Collections.sort(res);

        // 결과 출력
        for (String item : res) {
            System.out.print(item + " ");
        }
    }
}
