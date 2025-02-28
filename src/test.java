import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = N - 1; i > 0; --i)
        {
            for(int j = i - 1; j >= 0; --j)
            {
                if(arr[j] > arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    if(++count == K) System.out.println(arr[j] + " " + arr[i]);
                }
            }
        }
        if(count < K) System.out.println(-1);
    }
}
