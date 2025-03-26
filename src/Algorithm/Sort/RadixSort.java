package Algorithm.Sort;

import java.util.Arrays;

// 기수 정렬
public class RadixSort
{
    public static void sort(int[] arr)
    {
        int max = getMax(arr); // 배열에서 최대값 찾기
        for (int exp = 1; max / exp > 0; exp *= 10) countingSort(arr, exp); // 각 자릿수별로 계수 정렬 수행
    }

    // 배열에서 최대값을 찾는 메서드
    private static int getMax(int[] arr)
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // 특정 자릿수를 기준으로 계수 정렬을 수행하는 메서드
    private static void countingSort(int[] arr, int exp)
    {
        int n = arr.length;

        int[] output = new int[n]; // 결과를 저장할 배열
        int[] count = new int[10]; // 카운트 배열 (0-9 숫자의 출현 횟수를 저장)
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++; // 현재 자릿수를 기준으로 숫자 세기
        for (int i = 1; i < 10; i++) count[i] += count[i - 1]; // count 배열을 누적합으로 변경

        // 뒤에서부터 순회하여 output 배열 구성
        for (int i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n); // 원본 배열에 정렬된 결과 복사
    }
}
