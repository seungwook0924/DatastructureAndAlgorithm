package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Boj_1744
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> positives = new ArrayList<>(); // 2 이상
        List<Integer> negatives = new ArrayList<>(); // 음수
        boolean existsZero = false; // 0의 존재 유무
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i)
        {
            int number = Integer.parseInt(br.readLine());
            if(number > 1) positives.add(number);
            else if(number == 1) ++sum;
            else if(number == 0) existsZero = true;
            else negatives.add(number);
        }
        Collections.sort(positives, Comparator.reverseOrder()); // 내림차순
        Collections.sort(negatives); // 오름차순

        // 양수 처리
        for (int i = 0; i < positives.size() - 1; i += 2) sum += positives.get(i) * positives.get(i + 1);
        if (positives.size() % 2 == 1) // 양수의 개수가 홀수라면
        {
            sum += positives.get(positives.size() - 1); // 가장 작은 양수를 더함
        }

        // 음수 처리
        for (int i = 0; i < negatives.size() - 1; i += 2) sum += negatives.get(i) * negatives.get(i + 1);
        if (negatives.size() % 2 == 1) // 음수의 개수가 홀수라면
        {
            if (!existsZero) sum += negatives.get(negatives.size() - 1); // 0의 개수가 없을 때 합계에 음수를 더함
        }

        System.out.print(sum);
    }
}
