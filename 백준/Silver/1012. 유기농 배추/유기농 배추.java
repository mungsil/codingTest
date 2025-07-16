import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {-1, 0}, {1,0}};
    private static int M, N;
    private static int[][] beChuuMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaseNum; t++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            int beChuuNum = Integer.parseInt(inputs[2]);

            beChuuMap = new int[N][M];

            for (int i = 0; i < beChuuNum; i++) {
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                beChuuMap[y][x] = 1;
            }

            int answer = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (beChuuMap[y][x] == 1) {
                        bfs(y, x);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        beChuuMap[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int[] d : DIRECTIONS) {
                int nx = cx + d[0];
                int ny = cy + d[1];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && beChuuMap[ny][nx] == 1) {
                    beChuuMap[ny][nx] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}