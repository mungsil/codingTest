import java.util.*;
/*
3
4
7
10
*/

public class Main{
    
    private static int[] targetN;
    private static int[] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int totalN = scan.nextInt();
        targetN = new int[totalN];
        
        int max = 0;
        for(int i=0; i<totalN; i++){
            targetN[i] = scan.nextInt();
            max = Math.max(max, targetN[i]);
        }
        
        dp = new int[max+1];
        
        for(int i=0; i<totalN; i++){
            System.out.println(recur(targetN[i]));
        }
    }
    
    private static int recur(int target){
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(dp[target] != 0){
            return dp[target];
        }
        dp[target] = recur(target-1)+recur(target-2)+recur(target-3);

        return dp[target];
    }
    
}