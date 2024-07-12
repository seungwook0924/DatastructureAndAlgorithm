package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec02_03 {
    public static void solution(int N, String A, String B) {
        StringTokenizer aSt = new StringTokenizer(A);
        StringTokenizer bSt = new StringTokenizer(B);
        int[] aArr = new int[N];
        int[] bArr = new int[N];

        for(int i = 0; i < N; ++i){
            aArr[i] = Integer.parseInt(aSt.nextToken());
            bArr[i] = Integer.parseInt(bSt.nextToken());
            if(aArr[i] == bArr[i]) System.out.println("D");
            else if
            (
                (aArr[i] == 1 && bArr[i] == 3) ||
                (aArr[i] == 2 && bArr[i] == 1) ||
                (aArr[i] == 3 && bArr[i] == 2)
            ) System.out.println("A");
            else System.out.println("B");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String aInput = br.readLine();
        String bInput = br.readLine();
        solution(N, aInput, bInput);
    }
}
