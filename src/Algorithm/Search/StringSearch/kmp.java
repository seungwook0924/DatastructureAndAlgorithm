package Algorithm.Search.StringSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class kmp
{
    static public ArrayList<Integer> KMP(String str, String pattern)
    {
        ArrayList<Integer> idxList = new ArrayList<>(); //찾는 문자열을 발견시 해당 문자열의 시작 인덱스를 저장하는 리스트
        int LPS[] = new int[pattern.length()]; //LPS 배열 생성
        int index = 0; //IDX, 찾을 문자열의 비교 인덱스를 뜻하기도 하며, 접두사와 접미사가 같을 때 최대 길이를 뜻하기도 함
        for (int i = 1; i < pattern.length(); i++) //LPS배열의 값을 입력
        {
            if (pattern.charAt(i) == pattern.charAt(index)) LPS[i] = ++index; //접두사와 접미사가 같을 때, index를 1 증가
            else  //접두사와 접미사가 같지 않을 때
            {
                if (index != 0) //0이면 더 이상 돌아갈 위치가 없음
                {
                    index = LPS[index - 1]; //LPS[index - 1] : 이전 위치로 돌아가야 할 위치를 나타냄, 이 위치에서부터 비교를 다시 시작하여 일치하는 부분을 찾음
                    --i; // 현재 위치에서부터 다시 패턴 매칭을 시도(여기서 --i하고 이후 루프에서 ++i가 될테니)
                }
            }
        }
        index = 0; //0으로 초기화
        for(int i = 0; i < str.length(); i++) //문자열 탐색 시작
        {
            while(index > 0 && str.charAt(i) != pattern.charAt(index)) index = LPS[index - 1]; //LPS[index - 1] : 이전으로 돌아가야할 위치
            if(str.charAt(i) == pattern.charAt(index)) //접두사와 접미사가 같을 때
            {
                if(index == pattern.length() - 1) //IDX는 접두사와 접미사가 같을 때 최대 길이를 뜻하기도 하는데, 이것이 pattern의 길이와 같다면 탐색 성공
                {
                    idxList.add(i - (index - 1)); //일치하는 첫 번째 인덱스를 추가
                    index = LPS[index]; //LPS[index] : 현재 일치하는 부분의 최대 길이를 나타내며, 이 길이만큼은 이미 패턴과 일치함이 보장
                }
                else ++index; //길이가 같지 않다면 index를 1증가
            }
        }
        return idxList;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();
        ArrayList<Integer> list = KMP(str, pattern); //시작 인덱스들을 받아옴
        System.out.println(list.size() + "개 발견");
        System.out.print("인덱스 : ");
        for (Integer i : list) System.out.print(i + " "); //시작 인덱스들을 출력
    }
}