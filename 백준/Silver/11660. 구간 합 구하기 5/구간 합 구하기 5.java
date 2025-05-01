import java.util.*;

class Main {
    static class Area {
        int x1, y1, x2, y2;

        Area(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] table = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1]; // 누적합 저장 배열 선언

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                table[i][j] = scan.nextInt();
            }
        }

        // 누적합 배열 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] 
                          - sum[i - 1][j - 1] + table[i][j];
            }
        }

        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            int hap = sum[x2][y2]
                    - sum[x1 - 1][y2]
                    - sum[x2][y1 - 1]
                    + sum[x1 - 1][y1 - 1];
            
            System.out.println(hap);
        }
    }
}
