import java.util.*;

public class Main{
    
    private static int n;
    private static int[] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dp = new int[n+1];
        calcAnswer();
        System.out.print(dp[n]);
    }
    
    private static void calcAnswer(){
        for(int i=1; i < n+1; i++){
            if(i==1){
                dp[i] = 1;
            }else if(i==2){
                dp[i] = 2;
            }else{
                dp[i] = (dp[i-1]+dp[i-2])%10007;
            }
        }
    }
    
}