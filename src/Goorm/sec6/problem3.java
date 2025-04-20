package Goorm.sec6;

import java.io.*;
import java.util.*;

public class problem3 {
    static int N;
    static String[][] board;
    static Map<String, int[]> directionMap = new HashMap<>();

    static {
        directionMap.put("U", new int[]{-1, 0});
        directionMap.put("D", new int[]{1, 0});
        directionMap.put("L", new int[]{0, -1});
        directionMap.put("R", new int[]{0, 1});
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] goormPosition = parsePosition(br.readLine());
        boolean[][] goormVisited = new boolean[N][N];

        int[] playerPosition = parsePosition(br.readLine());
        boolean[][] playerVisited = new boolean[N][N];

        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();
            }
        }

        int goormScore = simulateMovement(goormPosition, goormVisited);
        int playerScore = simulateMovement(playerPosition, playerVisited);

        if (goormScore > playerScore) {
            System.out.println("goorm " + goormScore);
        } else {
            System.out.println("player " + playerScore);
        }
    }

    private static int[] parsePosition(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        return new int[]{x, y};
    }

    private static int wrapCoordinate(int coordinate) {
        if (coordinate == -1) return N - 1;
        if (coordinate == N) return 0;
        return coordinate;
    }

    private static int simulateMovement(int[] position, boolean[][] visited) {
        int x = position[0];
        int y = position[1];
        visited[x][y] = true;
        int score = 1;

        while (true) {
            String command = board[x][y];
            int distance = Integer.parseInt(command.substring(0, command.length() - 1));
            String direction = command.substring(command.length() - 1);
            int[] delta = directionMap.get(direction);

            for (int i = 0; i < distance; i++) {
                x = wrapCoordinate(x + delta[0]);
                y = wrapCoordinate(y + delta[1]);

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    score++;
                } else {
                    return score;
                }
            }
        }
    }
}