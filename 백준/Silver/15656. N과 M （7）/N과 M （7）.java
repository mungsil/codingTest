import java.util.*;

/*
4 2
9 8 7 1
*/

public class Main{
    
    private static int max;
    private static int num;
    private static int[] inputArray;
    private static int[] buffer;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        max = scan.nextInt();
        num = scan.nextInt();
  
        buffer = new int[num];
        inputArray = new int[max];
        for(int i=0; i<max; i++){
            inputArray[i] = scan.nextInt();
        }
            
        Arrays.sort(inputArray);
        recur(0);
        System.out.print(sb.toString());
    }
    
    public static void recur(int step){
        if(step == num){
            // 출력
            for(int b:buffer){
                sb.append(b + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<max;i++){
            buffer[step] = inputArray[i];
            recur(step+1);
        }
    }
    
}