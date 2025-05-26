import java.util.*;


public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] inputArr = new int[num+1];
        int[] dp = new int[num+1];
        
        for(int i=1; i<num+1; i++){
            inputArr[i] = scan.nextInt();
            dp[i] = 1;
        }
        
        for(int i=1; i<num+1; i++){
            for(int j=i-1; j>0; j--){
                // 이전 값보다 크면
                if(inputArr[j] < inputArr[i]){ 
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }         
            }
        }
        
        int answer = 0;
        for(int i=1; i<num+1; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(answer);
    }
    
    
}