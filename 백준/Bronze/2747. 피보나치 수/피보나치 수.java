import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Main main = new Main();
        System.out.print(main.findFibonachi(num));
    }
    
    private int findFibonachi(int num){
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=num; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[num];
    }
    
}