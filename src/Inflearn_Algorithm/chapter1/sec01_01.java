package Inflearn_Algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_01 {
    public static int solution(String fullText, char character) {
        String lowerFullText = fullText.toLowerCase();
        char lowerChar = Character.toLowerCase(character);
        int count = 0;

        for (int i = 0; i < lowerFullText.length(); i++) {
            if (lowerFullText.charAt(i) == lowerChar) {
                count++;
            }
        }

        return count;
    }

    public static int solution2(String fullText, char character) {
        String lowerFullText = fullText.toLowerCase();
        char lowerCharacter = Character.toLowerCase(character);
        int count = 0;

        for (char c : lowerFullText.toCharArray()){
            if(c == lowerCharacter) ++count;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fullText = br.readLine();
        char character = br.readLine().charAt(0);
        System.out.println(solution(fullText, character));
    }
}
