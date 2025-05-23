import java.util.*;

/*
3
26 40 83
49 60 57
13 89 99
*/

public class Main{
    
    private static int[][] houses;
    private static int[][] dp;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        houses = new int[num+1][3];
        dp = new int[num+1][3];
        for(int i=1; i < num+1; i++){
            houses[i][0] = scan.nextInt();
            houses[i][1] = scan.nextInt();
            houses[i][2] = scan.nextInt();
        }
        
        calcMinPrice();
        int min = Math.min(dp[num][0], Math.min(dp[num][1], dp[num][2]));
        System.out.print(min);
    }
    
    private static void calcMinPrice(){
        for(int y = 1; y < dp.length; y++){
            for(int x = 0; x < 3; x++){
                int c1;
                int c2;
                if(x==0){
                    c1 = 1;
                    c2 = 2;
                } else if(x==1){
                    c1 = 0;
                    c2 = 2;
                } else{
                    c1 = 0;
                    c2 = 1;
                }
                dp[y][x] = Math.min(dp[y-1][c1] + houses[y][x], dp[y-1][c2] + houses[y][x]);
            }
        }
    }
    
}