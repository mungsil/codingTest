import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] dp = new int[15][15];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int sum = getPeopleCount(k, n);
            System.out.println(sum); 
        }
    }

        private static int getPeopleCount(int floor, int num){
            if(dp[floor][num] !=0){
                return dp[floor][num];
            }
                        
            if(floor == 0){
                dp[floor][num] = num;
                return num;
            }
            
            int sum = 0;
            int downFloor = floor-1;
            
            if(num ==1){
                sum += getPeopleCount(downFloor, num);
                dp[floor][num] = num;
            } else{
                sum = getPeopleCount(floor, num-1) +
                 getPeopleCount(downFloor, num);
            }
            
            return sum;
        }
}
