import java.util.*;


public class Main{
    
    private static int N;
    private static int answer;
    private static int[] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new int[N+1];
        dp[1] =0;
        recur(2);
        System.out.print(dp[N]);
    }
    
    private static void recur(int n){
        if(n == N+1){
            return;
        }
        
        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;
        int v3 = Integer.MAX_VALUE;
        
        if(n%2 == 0){
            v2 = dp[n/2]+1;
        }
        if(n%3 == 0){
            v3 = dp[n/3]+1;
        }
        if(n<N+1){
            v1 = dp[n-1]+1;
        }
        dp[n] = Math.min(v1, Math.min(v2, v3));
        recur(n+1);
    }
    
}