import java.util.*;


public class Main {
    public static int range;
    public static int num;
    public static List<Integer> buffer = new ArrayList<>();
    public static Map<Integer, Boolean> checker = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        range = scan.nextInt();
        num = scan.nextInt();
        
        recur(0);
    }

    public static void recur(int step) {
        if (step == num) {
            for (int b : buffer) {
                System.out.print(b + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= range; i++) {
            if (checker.getOrDefault(i, false)) {
                continue;
            }
            checker.put(i, true);
            buffer.add(i);
            recur(step + 1);
            buffer.remove(buffer.size() - 1);
            checker.put(i, false);
        }
    }
}