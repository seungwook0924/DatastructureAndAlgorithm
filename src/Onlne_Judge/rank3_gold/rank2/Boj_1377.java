package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1377
{
    // 정렬 전 인덱스와 값을 저장하는 객체
    static class Pair implements Comparable<Pair>
    {
        int index; // index 저장
        int value; // value 저장

        // 생성자
        Pair(int index, int value)
        {
            this.index = index;
            this.value = value;
        }

        // 정렬할 때 이 메서드의 반환값에 따라 정렬 결과가 달라짐
        @Override
        public int compareTo(Pair o)
        {
            // 음수 반환: 현재 객체가 파라미터 객체보다 작다
            // 양수 반환: 현재 객체가 매개변수 객체보다 크다
            // 0 반환: 두 객체가 같다.
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n을 받아옴
        int n = Integer.parseInt(br.readLine());

        // 정렬 전 인덱스와 값을 저장하는 배열을 선언하고 초기화
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; ++i) arr[i] = new Pair(i, Integer.parseInt(br.readLine()));

        // Arrays.sort()는 내부적으로 정렬할 객체가 Comparable을 구현했는지 확인하고,
        // 구현했다면 해당 객체의 compareTo() 메서드를 사용하여 정렬
        Arrays.sort(arr);

        int max = 0;
        for(int i = 0; i < n; ++i)
        {
            int diff = arr[i].index - i; // 정렬 전 인덱스 - 정렬 후 인덱스
            if(diff > max) max = diff;
        }
        System.out.print(max + 1); // swap이 일어나지 않는 반복문이 한 번더 실행되는것을 감안하여 1 더해줌
    }
}
