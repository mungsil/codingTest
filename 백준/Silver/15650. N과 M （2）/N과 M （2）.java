import java.util.*;


public class Main {
    public static int range;
    public static int num;
    public static Deque<Integer> buffer = new ArrayDeque<>();
    public static Map<Integer, Boolean> checker = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        range = scan.nextInt();
        num = scan.nextInt();
        
        recur(0);
    }

    public static void recur(int step) {
        if(step==num){
            for(int b : buffer){
                System.out.print(b + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i=1; i< range+1; i++){
            if(checker.getOrDefault(i, false) == true){
                continue;
            }
            if(!buffer.isEmpty() && buffer.peekLast() >= i){
                continue;
            }
            buffer.offerLast(i);
            checker.put(i, Boolean.TRUE);
            recur(step+1);
            buffer.pollLast();
            checker.put(i, Boolean.FALSE);
        }
    }
}