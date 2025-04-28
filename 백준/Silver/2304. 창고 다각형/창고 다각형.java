import java.util.*;
/**
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6
**/

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        // inputs[2] = 4, inputs[11] = 4...
        // create max index 1001
        int[] inputs = new int[1002];
        
        int index_max = 0;
        for(int i = 0; i<num; i++){
            int index = scan.nextInt();
            int value = scan.nextInt();
            
            inputs[index] = value;
            index_max = Math.max(index_max, index);
        }
        
        // 문제 풀이
        // 메모이제이션 + 투포인트
        int[] maxHigh = new int[1002];
        
        int left_p = 0;
        int right_p = index_max+1;
        
        while(left_p != right_p){
            if(inputs[left_p] <= inputs[right_p]){
                left_p++;
                if(inputs[left_p] > maxHigh[left_p - 1]){
                    maxHigh[left_p] = inputs[left_p];
                } else{
                    maxHigh[left_p] = maxHigh[left_p - 1];
                }
            }
            
            
            if(inputs[left_p] > inputs[right_p]){
                right_p--;
                 if(inputs[right_p] > maxHigh[right_p + 1]){
                    maxHigh[right_p] = inputs[right_p];
                } else{
                    maxHigh[right_p] = maxHigh[right_p + 1];
                }
            }
        }
        
        int answer=0;
        for(int i=1;i<=index_max;i++){
            answer += maxHigh[i];
        }
        
        System.out.print(answer);       
    }
}