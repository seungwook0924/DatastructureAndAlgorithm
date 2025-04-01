package Algorithm.Search.NumberSearch;

public class BinarySearch
{
    static int binarySearch(int[] arr, int value)
    {
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while (leftPtr <= rightPtr)
        {
            int mid = (leftPtr + rightPtr) / 2;

            if(arr[mid] == value) return mid; // 찾은 경우
            if(arr[mid] > value) rightPtr = mid - 1; // 왼쪽 부분 탐색
            else leftPtr = mid + 1; // 오른쪽 부분 탐색
        }

        return -1;
    }
}
