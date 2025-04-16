package Inflearn_Algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class sec05_03 {
    public static int solution(int[][] board, int[] moves)
    {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : moves)
        {
            for(int j = 0; j < board.length; ++j) //y축
            {
                if(board[j][i - 1] != 0)
                {
                    if((!stack.isEmpty()) && (stack.peek() == (board[j][i - 1])))
                    {
                        stack.pop();
                        count += 2;
                    }
                    else stack.push(board[j][i - 1]);

                    board[j][i - 1] = 0;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int [N][N];
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) moves[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(board, moves));
    }
}
