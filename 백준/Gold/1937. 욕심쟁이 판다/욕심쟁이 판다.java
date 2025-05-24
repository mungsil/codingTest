import java.util.*;

/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
*/

public class Main{
    
    private static int n;
    private static int[][] N;
    private static int[][] dp;
    private static int[][] upDownLeftRight = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    public static void main(String[] args){
        // 입력 
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        N = new int[n][n];
        for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                N[y][x] = scan.nextInt();
            }
        }
        
        // 계산
        
        // 계산된 최대 이동 칸 수 저장할 용도로 사용하는 배열
        dp = new int[n][n]; 
        calcMaxMovesAtEachPoint();
        
        // find MaxMoves from result
        int maxMoves = Integer.MIN_VALUE;
        for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                maxMoves = Math.max(maxMoves, dp[y][x]);
            }
        }
        
        System.out.print(maxMoves+1);
    }
    
    private static void calcMaxMovesAtEachPoint(){
        for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                recur(y,x);
            }
        }
    }
    
    private static int recur(int y, int x){
        if(dp[y][x] != 0){
            return dp[y][x];
        }
        
        for(int[] next: upDownLeftRight){
            int nextY = y+next[0];
            int nextX = x+next[1];
            
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n){
                 if(N[nextY][nextX] > N[y][x]){
                    dp[y][x] = Math.max(dp[y][x], recur(nextY, nextX) + 1);
                }
            }

        }
        
        return dp[y][x];
    }
    
}