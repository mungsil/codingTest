import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder dfsRoute = new StringBuilder();
    static StringBuilder bfsRoute = new StringBuilder();
    static int[][] graph;
    static int[] dfsVisited;
    static int[] bfsVisited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        N = inputs[0];
        int L = inputs[1];
        int startNode = inputs[2];

        graph = new int[N+1][N+1];

        for (int i=0; i<L; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();
            int n1 = line[0];
            int n2 = line[1];
            graph[n1][n2] = 1;
            graph[n2][n1] = 1; // 무방향 그래프
        }

        dfsVisited = new int[N+1];
        bfsVisited = new int[N+1];

        dfs(startNode);
        bfs(startNode);

        System.out.println(dfsRoute);
        System.out.println(bfsRoute);
    }

    private static void dfs(int visitNum) {
        dfsVisited[visitNum] = 1;
        dfsRoute.append(visitNum).append(" ");
        for (int i=1; i<=N; i++) {
            if (graph[visitNum][i] == 1 && dfsVisited[i] == 0) {
                dfs(i);
            }
        }
    }

    private static void bfs(int visitNum) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(visitNum);
        bfsVisited[visitNum] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            bfsRoute.append(curr).append(" ");
            for (int i=1; i<=N; i++) {
                if (graph[curr][i] == 1 && bfsVisited[i] == 0) {
                    bfsVisited[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}
