import java.util.*;

/**
10
2 1 -4 3 4 -4 6 5 -5 1
**/
class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] inputs = new int[num];
        for(int i=0; i<num; i++){
            inputs[i] = scan.nextInt();
        }
        
        // solve
        
        /**
        2 1 -4 3 4 -4 6 5 -5 1
  -9999 2 3 -1 3 7  3 9 14 9 10
        연속적으로 더한 값이 새로 시작하는 경우(==본인)보다 큰 경우 더한다.
        **/
        int[] sum = new int[num+1];
        sum[0] = -2000;
        for(int i=1; i<num+1; i++){
            sum[i] = Math.max(sum[i-1]+inputs[i-1], inputs[i-1]);
        }
        
        Arrays.sort(sum);
        System.out.print(sum[num]);
    }
}