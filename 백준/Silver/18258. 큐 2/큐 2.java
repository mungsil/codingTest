import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

public class Main{
    
    private static int[] queue;
    private static int size = 0;
    private static int headIndex = 0;
    private static int tailIndex = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        queue = new int[n];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] operands = br.readLine().split(" ");
            String oper = operands[0];
            if(oper.equals("push")){ // [1, 3,0,0...] : head=1, tail = 2
                queue[tailIndex] = Integer.valueOf(operands[1]);
                tailIndex++;
                size++;
            } else if(oper.equals("pop")){ // [1, 0,0,0...] : head = 2, tail =2;
                int poped = -1;
                if(queue[headIndex] != 0){
                    poped = queue[headIndex];
                    size--;
                    queue[headIndex] = 0;
                    headIndex++;
                } 
                sb.append(poped).append("\n");
            } else if(oper.equals("size")){
                sb.append(size).append("\n");
            } else if(oper.equals("empty")){
                int isEmpty = size == 0 ? 1 : 0;
                sb.append(isEmpty).append("\n");
            } else if(oper.equals("front")){
                int peekFirst = queue[headIndex] == 0 ? -1 : queue[headIndex];
                sb.append(peekFirst).append("\n");
            } else if(oper.equals("back")){
                int peekLast = -1;
                if(tailIndex > 0){
                    peekLast = queue[tailIndex-1] == 0 ? -1 : queue[tailIndex-1];
                }
                sb.append(peekLast).append("\n");
            }
        }
        System.out.print(sb);
    }
    
}