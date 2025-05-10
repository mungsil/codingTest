import java.util.Scanner;

public class Main {
    private static int n, m;
    private static int[] buffer;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        buffer = new int[m];

        recur(0);
        System.out.print(sb);
    }

    public static void recur(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(buffer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            buffer[depth] = i;
            recur(depth + 1);
        }
    }
}
