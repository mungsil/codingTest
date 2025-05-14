import java.util.*;

/*
4 2
9 8 7 1
*/

public class Main{
    
    private static int max;
    private static int num;
    private static int[] inputArray;
    private static Deque<Integer> buffer = new ArrayDeque<>();
    private static Map<Integer,Boolean> checker = new HashMap<>();
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        max = scan.nextInt();
        num = scan.nextInt();
  
        inputArray = new int[max];
        for(int i=0; i<max; i++){
            inputArray[i] = scan.nextInt();
        }
            
        Arrays.sort(inputArray);
        recur(0,0);
    }
    
    public static void recur(int step, int sp){
        if(step == num){
            // 출력
            for(int b:buffer){
                System.out.print(b+" ");
            }
            return;
        }
        // num = 4, sp = 3
        for(int i=sp;i<max;i++){
            if(checker.getOrDefault(inputArray[i], Boolean.FALSE)== true){
                continue;
            }
            buffer.offerLast(inputArray[i]);
            checker.put(inputArray[i], Boolean.TRUE);
            recur(step+1, i+1);
            buffer.pollLast();
            checker.put(inputArray[i], Boolean.FALSE);
        }
    }
    
}