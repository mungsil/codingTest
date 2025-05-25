import java.util.*;

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
*/

public class Main{
    
    private static int m; // 세로
    private static int n; // 가로
    private static int[][] map;
    private static int[][] dp;
    private static int[][] upDownLeftRight = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public static void main(String[] args){
        // 입력 
        Scanner scan = new Scanner(System.in);
        
        m = scan.nextInt();
        n = scan.nextInt();
        map = new int[m][n];
        dp = new int[m][n];
        
        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                map[y][x] = scan.nextInt();
                dp[y][x] =-1;
            }
        }
        
        // 계산
        System.out.print(recur(0,0));
        
    }
    
    private static int recur(int y, int x){
        if(x==n-1 && y==m-1){
            return 1;
        }
        
        if(dp[y][x] != -1){
            return dp[y][x];
        }
        
        // 방문했어도 0인 경우
        int route = 0;
        for(int[] nextChange: upDownLeftRight){
            int nextX = nextChange[0] + x;
            int nextY = nextChange[1] + y;
            
            // 지도 범위 안
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                // 내리막길
                if(map[y][x] > map[nextY][nextX]){
                    route += recur(nextY, nextX);
                }
            }
        }
        
        dp[y][x] = route;
        return dp[y][x];
    }
     
}