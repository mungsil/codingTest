import java.util.*;

public class Main {

    private static int N;
    private static Long[][] dp; // dp[pos][digit] = pos 길이에서 digit으로 끝나는 계단 수 개수
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Long[N+1][10];

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer = (answer + recur(N-1, i)) % MOD;
        }
        System.out.println(answer);
    }

    private static long recur(int pos, int digit) {
        if (pos == 0) return 1;

        if (dp[pos][digit] != null) return dp[pos][digit];

        long count = 0;
        if (digit > 0) count = (count + recur(pos-1, digit-1)) % MOD;
        if (digit < 9) count = (count + recur(pos-1, digit+1)) % MOD;

        return dp[pos][digit] = count;
    }
}
