import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        int totalNum = scanner.nextInt();
        // 풀이
        int[] array = new int[totalNum];
        for (int i = 0; i < totalNum; i++) {
            int x = scanner.nextInt();
            array[i] = x;
        }
        String answer = new Main().solve(array);
        System.out.println(answer);
    }

    private String solve(int[] array) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            // x가 0이 아니면 추가
            int x = array[i];
            if (x != 0) {
                nodes.add(new Node(x));
            } else { // x가 0이면 작은값을 pop
                if (nodes.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(nodes.poll().getValue()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    class Node implements Comparable {
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Node) {
                Node node = (Node) o;
                // 절댓값 비교, 내가 더 크면 1 반환
                int targetV = node.getValue();
                int absTarget = Math.abs(targetV);

                int absValue = Math.abs(this.value);
                if (absValue > absTarget){
                    return 1;
                }
                if (absValue < absTarget){
                    return -1;
                }

                // value 비교, 내가 더 크면 1 반환
                return Integer.compare(this.value, targetV);
            }
            return 0;
        }

        public int getValue() {
            return value;
        }

    }

}