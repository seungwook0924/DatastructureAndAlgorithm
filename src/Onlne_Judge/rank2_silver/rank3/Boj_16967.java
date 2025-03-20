package Onlne_Judge.rank2_silver.rank3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_16967
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // H, W, X, Y를 받아옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 배열 B를 받아옴
        int[][] arr = new int[h + x][w + y];
        for(int i = 0; i < h + x; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w + y; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 배열 B의 (0,0) ~ (W,H) 구역을 배열 A로 원상복구 시키는 루프
        for(int i = 0; i < h; ++i)
        {
            for(int j = 0; j < w; ++j)
            {
                if((i >= x) && (j >= y)) arr[i][j] -= arr[i - x][j - y]; // 겹쳐진 구역이라면 원상복구 시킴
                bw.write(arr[i][j] + " ");
            }
            bw.write(System.lineSeparator());
        }
        bw.flush();
    }
}
