package inflearn_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_12 {
    public static String solution(int n, String message) {
        StringBuilder sb = new StringBuilder();
        String binary;
        String[] binaryCharArr = new String[n];
        int idx = 0;
        sb.append(message.trim().replace('#', '1').replace('*', '0'));
        binary = sb.toString();
        sb = new StringBuilder();
        for(int i = 0; i < binary.length(); i += 7){
            binaryCharArr[idx++] = binary.substring(i, i + 7);
            sb.append((char) Integer.parseInt(binaryCharArr[idx - 1], 2));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String message = br.readLine();
        System.out.println(solution(N, message));
    }
}
