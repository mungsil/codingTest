import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int array_length = scan.nextInt();
        int continuous = scan.nextInt();
        
        int[] inputs = new int[array_length];
        
        for(int i=0;i<array_length;i++){
            inputs[i] = scan.nextInt();
        }
        
        // 문제 풀이
        
        // 메모이제이션
        int[] sums = new int[array_length+1];
        sums[0] = 0;
        for(int i=1; i<array_length+1; i++){
            sums[i] = sums[i-1] + inputs[i-1];
        }
        
        // 1 2 3 4 5
        
        /**
        10 2
        inputs = [3 -2 -4 -9 0 3 7 13 8 -3]
        inputs[1]와 inputs[0]의 합 = sums[2]- sums[0]
        inputs[2]와 inputs[1]의 합 = sums[3]- sums[1]
        
        sums = [0, 3, 1, -3, -12]
        **/
        int max = Integer.MIN_VALUE;
        for(int i=continuous; i<array_length+1; i++){
            int hap = sums[i] - sums[i-continuous];
            max = Math.max(max, hap);
        }
        
        System.out.print(max);
    }
}