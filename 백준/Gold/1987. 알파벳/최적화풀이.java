// gpt가 알려줬어요

import java.util.Scanner;

public class Main {

    private static char[][] map;
    private static boolean[] visitedAlpha = new boolean[26]; // A~Z
    private static int rowNum, colNum;
    private static int maxMoveCount = 0;

    // 상, 하, 좌, 우
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowNum = scanner.nextInt();
        colNum = scanner.nextInt();
        map = new char[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {
            map[i] = scanner.next().toCharArray();
        }

        // 시작 알파벳 방문 표시
        visitedAlpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxMoveCount);
    }

    private static void dfs(int y, int x, int count) {
        maxMoveCount = Math.max(maxMoveCount, count);

        for (int[] dir : directions) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (ny >= 0 && ny < rowNum && nx >= 0 && nx < colNum) {
                int alphaIndex = map[ny][nx] - 'A';
                if (!visitedAlpha[alphaIndex]) {
                    visitedAlpha[alphaIndex] = true;
                    dfs(ny, nx, count + 1);
                    visitedAlpha[alphaIndex] = false; // 백트래킹
                }
            }
        }
    }
}
