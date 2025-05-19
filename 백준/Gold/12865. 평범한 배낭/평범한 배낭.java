import java.util.*;

public class Main{
    private static int maxNumInBag;
    private static int maxWeightInBag;
    private static int[][] candidates;
    private static int maxValue = Integer.MIN_VALUE;
    private static int[][] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        maxNumInBag = scan.nextInt();
        maxWeightInBag = scan.nextInt();
        dp = new int[maxNumInBag][1000000];
        for (int i = 0; i < maxNumInBag; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        candidates = new int[maxNumInBag][2]; 
              
        for(int i=0; i<maxNumInBag; i++){
            candidates[i][0] = scan.nextInt(); // 무게
            candidates[i][1] = scan.nextInt(); // 가치
        }
        
        System.out.print(recur(0, 0));
    } 
    
    private static int recur(int idx, int weight){
        if(weight > maxWeightInBag){
            return Integer.MIN_VALUE;
        }
        if(idx == maxNumInBag){
            return 0;
        }
        if(dp[idx][weight] > -1){
            return dp[idx][weight];
        }
        
        dp[idx][weight] = Math.max(
            recur(idx +1, weight + candidates[idx][0]) + candidates[idx][1]
            , recur(idx +1, weight) );
        
        return dp[idx][weight];
    }
    
}