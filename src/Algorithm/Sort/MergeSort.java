package Algorithm.Sort;

public class MergeSort
{
    public static void sort(int[] arr)
    {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid); // 왼쪽 부분 정렬
            mergeSort(arr, temp, mid + 1, end); // 오른쪽 부분 정렬
            merge(arr, temp, start, mid, end); // 정렬된 두 부분을 병합
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end)
    {

        for (int i = start; i <= end; i++) temp[i] = arr[i]; // 임시 배열에 복사

        int part1 = start;    // 첫 번째 부분의 시작 위치
        int part2 = mid + 1;  // 두 번째 부분의 시작 위치
        int index = start;    // 결과를 저장할 배열의 현재 위치

        // 두 부분을 비교하면서 병합
        while (part1 <= mid && part2 <= end)
        {
            if (temp[part1] <= temp[part2])
            {
                arr[index] = temp[part1];
                part1++;
            }
            else
            {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        // 남은 왼쪽 부분 복사
        while (part1 <= mid)
        {
            arr[index] = temp[part1];
            part1++;
            index++;
        }
        // 오른쪽 부분은 이미 제자리에 있으므로 복사할 필요 없음
    }
}
