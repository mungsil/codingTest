import java.util.*;

class Solution {

    private final int[][] surrounds = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];

            if (y == n - 1 && x == m - 1) {
                return dist[y][x];
            }

            for (int[] next : surrounds) {
                int ny = y + next[0];
                int nx = x + next[1];

                // 경계 체크 수정
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                // 벽 체크 수정 (maps 배열로 해야 함)
                if (maps[ny][nx] == 0) continue;

                // 방문 여부 체크 수정
                if (dist[ny][nx] != -1) continue;

                dist[ny][nx] = dist[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }

        return -1;
    }
}
