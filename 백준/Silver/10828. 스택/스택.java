import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        while(N-- > 0) {
            String input = br.readLine(); // 한 줄 읽기
            StringTokenizer st = new StringTokenizer(input);

            String command = st.nextToken();
            
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value); // Deque를 스택으로 쓸 땐 push가 addFirst와 같아여
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0); 
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } 
        }
    }
}