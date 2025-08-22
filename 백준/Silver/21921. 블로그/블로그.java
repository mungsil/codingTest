import java.util.*;
import java.io.*;

/*
7 5
1 1 1 1 1 5 1
*/
public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        int N = input[0];
        int X = input[1];
        String[] visitNumsStr = br.readLine().split(" ");
        
        int[] visitNums = new int[N+1];
        for(int i=1; i<N+1; i++){
            visitNums[i] = Integer.parseInt(visitNumsStr[i-1]);
        }
        
        int[] visitSums = new int[N+1];
        for(int i=1; i < N+1; i++){
            visitSums[i] = visitNums[i] + visitSums[i-1];
        }
        
        int max = 0;
        int num = 0;
        for(int i=N; i >= X; i--){
            int hap = visitSums[i]-visitSums[i-X]; 
            if(hap > max){
                max = hap;
                num = 1;
            } else if(hap == max){
                num++;
            }
        }
        
        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(num);
        }
    } 
}