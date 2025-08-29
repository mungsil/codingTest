import java.util.*;
import java.io.*;

/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
*/

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = br.readLine().split(" ");
        int N = Integer.parseInt(nmk[0]);
        int M = Integer.parseInt(nmk[1]);
        int K = Integer.parseInt(nmk[2]);
        
        long[] input = new long[N+1]; // 입력
        long[] arr = new long[N+1]; // 누적합
        for(int i=0; i<N; i++){
            long element = Long.parseLong(br.readLine());
            input[i+1] = element; 
            arr[i+1] = element + arr[i]; 
        }
        
        StringBuilder sb = new StringBuilder();
        int iterNum = M+K;
        for(int i=0; i<iterNum; i++){
            String[] instruction = br.readLine().split(" ");
            int flag = Integer.parseInt(instruction[0]);
            if(flag == 1){
                int targetIndex = Integer.parseInt(instruction[1]);
                long changeValue = Long.parseLong(instruction[2]);
                long dv = changeValue - input[targetIndex];
                for(int j = targetIndex; j<N+1; j++){
                    arr[j] += dv;
                }
                input[targetIndex] = changeValue;
            } else{
                int startIndex = Integer.parseInt(instruction[1]);
                int endIndex = Integer.parseInt(instruction[2]);
                sb.append(arr[endIndex] - arr[startIndex-1]).append("\n");
            }

        }
        
        System.out.print(sb);
        
    }
    
}