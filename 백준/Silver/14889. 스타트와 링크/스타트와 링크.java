import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited; 
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(minDiff);
    }

    public static void dfs(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        if (idx == N) {
            return;
        }

        visited[idx] = true;
        dfs(idx + 1, count + 1);

        visited[idx] = false;
        dfs(idx + 1, count);
    }

    public static void calculateDifference() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startScore += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkScore += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startScore - linkScore);
        minDiff = Math.min(minDiff, diff);
    }
}