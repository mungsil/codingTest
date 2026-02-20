import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int len = input.length();

        if (len == 1) {
            System.out.println(input.toUpperCase());
            return;
        }

        Map<String, Integer> count = new HashMap<>();

        for (char c : input.toCharArray()) {
            String s = String.valueOf(c).toUpperCase();
            count.merge(s, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())
        );

        for (Map.Entry<String, Integer> node : count.entrySet()) {
            pq.add(node);
        }

        Map.Entry<String, Integer> first = pq.poll(); // 가장 빈도가 높은 노드
        
        if (!pq.isEmpty() && Objects.equals(first.getValue(), pq.peek().getValue())) {
            System.out.println("?");
        } else {
            System.out.println(first.getKey());
        }
    }
}