import java.util.*;

// 시간 초과 => 오답
public class Main{
    
    private static int N;
    private static int answer;
    private static int[] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new int[N+1];
        System.out.print(recur(1));
    }
    
    private static int recur(int n){
        if(n == N){
            return 0;
        }
        
        if(n > N){
            return Integer.MAX_VALUE;
        }
        
        if (dp[n] != 0) {
            return dp[n]; 
        }
              
        dp[n] = Math.min(recur(n*3) , Math.min(recur(n*2), recur(n+1)))+1;
        
        return dp[n];
    }
    
}
