package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec02_06 {
//    public static void solution(int N, String str) {
//        String[] strArr = str.split(" ");
//        int[] numArr = new int[N];
//
//        for(int i = 0; i < N; ++i)
//        {
//            StringBuilder sb = new StringBuilder();
//            numArr[i] = Integer.parseInt(
//                    sb.append(strArr[i])
//                            .reverse()
//                            .toString());
//        }
//
//        for(int i = 0; i < N; ++i)
//        {
//            if(numArr[i] == 2) System.out.print(2 + " ");
//            else if(numArr[i] > 2)
//            {
//                boolean flag = true;
//                for(int j = 2; j < numArr[i]; ++j){
//                    if(flag && numArr[i] % j == 0){
//                        flag = false;
//                        break;
//                    }
//                }
//                if(flag) System.out.print(numArr[i] + " ");
//            }
//        }
//
//    }

    public static void solution(int N, String str) {
        String[] strArr = str.split(" ");
        int[] numArr = new int[N];

        for (int i = 0; i < N; ++i) {
            StringBuilder sb = new StringBuilder(strArr[i]);
            numArr[i] = Integer.parseInt(sb.reverse().toString());
        }

        for (int num : numArr) {
            if (isPrime(num)) System.out.print(num + " ");
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false; //짝수는 return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) //홀수에 대해서 제곱근까지만 검사
        {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        solution(N, input);
    }
}