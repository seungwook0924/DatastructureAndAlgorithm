package Algorithm.Sort;

public class QuickSort
{
    public static void v1(int[] arr, int start, int end)
    {
        if (start >= end) return;

        int pivot = arr[end]; // 마지막 요소를 pivot으로 선택
        int leftPtr = start;
        int rightPtr = end - 1;

        while (leftPtr <= rightPtr)
        {
            while (leftPtr <= rightPtr && arr[leftPtr] <= pivot) ++leftPtr; // 왼쪽에서 pivot보다 큰 값을 찾는다
            while (leftPtr <= rightPtr && arr[rightPtr] >= pivot) --rightPtr; // 오른쪽에서 pivot보다 작은 값을 찾는다
            if (leftPtr < rightPtr) swap(arr, leftPtr, rightPtr); // 조건을 만족하면 swap
        }

        swap(arr, leftPtr, end); // pivot을 leftPtr 위치와 교환하여 pivot을 정확한 위치에 둔다

        // 분할된 두 구간에 대해 재귀적으로 정렬 수행
        v1(arr, start, leftPtr - 1);
        v1(arr, leftPtr + 1, end);
    }

    public static void v2(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(arr, low, high); // 피벗을 기준으로 배열을 분할하고 피벗의 최종 위치를 얻음
            quickSort(arr, low, pivot - 1); // 피벗을 기준으로 왼쪽 부분 정렬
            quickSort(arr, pivot + 1, high); // 피벗을 기준으로 오른쪽 부분 정렬
        }
    }

    private static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high]; // 맨 오른쪽 요소를 피벗으로 선택
        int i = (low - 1); // i는 피벗보다 작은 요소들의 경계를 나타냄

        for (int j = low; j < high; ++j)
        {
            // 현재 요소가 피벗보다 작으면
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j); // arr[i]와 arr[j]를 교환
            }
        }

        // 피벗을 올바른 위치로 이동
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
