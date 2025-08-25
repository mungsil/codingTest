import java.util.*;
import java.io.*;

/*
2
5
1 2 3 4 5
5
2 1 -2 3 -5
*/

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc_num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc_num; t++){
            int N = Integer.parseInt(br.readLine());
            int[] X = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
            int[] dp = new int[N];
            dp[0] = X[0];
            int max = X[0];
            for(int i=1; i<N; i++){
                dp[i] = Math.max(dp[i-1] + X[i], X[i]);
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
    
}