package Onlne_Judge;

import java.util.Scanner;

public class Boj_5988 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();

        if(N != 0){
            for (int i = 0; i < N; i++) {
                String[] arr = sc.next().split("");
                System.out.println(Integer.parseInt(arr[arr.length - 1]) % 2 == 1 ? "odd": "even");
            }
        }
    }
}
