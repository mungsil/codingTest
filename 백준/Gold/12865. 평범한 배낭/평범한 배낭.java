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
        dp = new int[maxNumInBag+1][maxWeightInBag+1];
        
        candidates = new int[maxNumInBag+1][2]; 
              
        for(int i=1; i < maxNumInBag+1; i++){
            candidates[i][0] = scan.nextInt(); // 무게
            candidates[i][1] = scan.nextInt(); // 가치
        }
        
        getMaxValue();
        System.out.print(dp[maxNumInBag][maxWeightInBag]);
    } 
    
    private static void getMaxValue(){
        for(int y=1; y < maxNumInBag+1; y++){
            int weight = candidates[y][0];
            int value = candidates[y][1];
            
            for(int x=1; x < maxWeightInBag+1; x++){
                if(x < weight){
                    dp[y][x] = dp[y-1][x];
                }else{
                    dp[y][x] = Math.max(dp[y-1][x-weight] + value, dp[y-1][x]);
                }
            }
        }
    }
    
}