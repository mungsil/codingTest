import java.util.*;

public class Main{
    
    private static int n;
    private static int m;
    private static Deque<Integer> buffer = new ArrayDeque<>();
    
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        
        recur(0,1);
        System.out.print(sb.toString());
    }
    
    public static void recur(int step, int start){// (2,2)
        if(step == m){
            for(int b: buffer){
                sb.append(b+" ");
            }
            sb.append("\n");
            return;
        }
        
        // buffer = 0, 1, 2, 3 
        for(int i=start; i<n+1; i++){// i=1~4
            buffer.offerLast(i);
            recur(step+1, i);
            buffer.pollLast();
        }
    }
    
}