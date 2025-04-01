package Algorithm.Search.StringSearch;

public class BruteForce
{
    public static int bruteForceSearch(String text, String pattern)
    {
        for (int i = 0; i <= text.length() - pattern.length(); i++)
        {
            int j;
            for (j = 0; j < pattern.length(); j++)
            {
                if (text.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == pattern.length())  return i; // 패턴이 발견된 위치 반환
        }
        return -1; // 패턴이 발견되지 않음
    }

    public static void main(String[] args)
    {
        String text = "Hello, World!";
        String pattern = "World";

        int result = bruteForceSearch(text, pattern);

        if (result != -1) System.out.println("패턴이 발견된 위치: " + result);
        else System.out.println("패턴이 발견되지 않음");
    }
}