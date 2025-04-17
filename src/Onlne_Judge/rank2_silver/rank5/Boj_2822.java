package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2822
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[8];
        int[] originalIndexes = new int[8];

        for (int i = 0; i < 8; i++)
        {
            scores[i] = Integer.parseInt(br.readLine());
            originalIndexes[i] = i + 1;
        }

        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);

        int sum = 0;
        List<Integer> selectedIndexes = new ArrayList<>();

        for (int i = 3; i < 8; i++)
        {
            int score = sortedScores[i];
            sum += score;

            for (int j = 0; j < 8; j++)
            {
                if (scores[j] == score && !selectedIndexes.contains(originalIndexes[j]))
                {
                    selectedIndexes.add(originalIndexes[j]);
                    break;
                }
            }
        }

        Collections.sort(selectedIndexes);

        System.out.println(sum);
        for (int index : selectedIndexes) System.out.print(index + " ");
    }
}
