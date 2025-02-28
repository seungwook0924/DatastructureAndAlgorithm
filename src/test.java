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

        for(int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 기준 숫자
            int c = Integer.parseInt(st.nextToken()); // 0은 다운, 1은 업

            if(x == 1)
            {
               if(arr[i] < x)
               {

               }
            }
            else
            {

            }
        }
    }
}
