package Algorithm.Sort;

// 선택 정렬
public class SelectionSort
{
    public static void sort(int[] arr)
    {
        for(int i = 0; i < arr.length - 1; ++i)
        {
            int tmp = arr[i];
            int minValue = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < arr.length; ++j)
            {
                if(arr[j] < minValue)
                {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }
}
