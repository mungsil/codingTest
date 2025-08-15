import java.util.*;
import java.io.*;

/*
5
10 10 11 4 3 7
*/
public class Main {
    
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");

        StringBuilder sb = new StringBuilder();
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            int currTop = Integer.parseInt(parts[i]);
            
            while(!stack.isEmpty() && stack.peek()[1] < currTop){
                stack.pop();
            }
                
            if(stack.isEmpty()){
                sb.append("0").append(" ");
            } else{
                int[] received = stack.peek();
                sb.append(received[0]+1).append(" ");
            }

            stack.push(new int[]{i, currTop}); 
        }
        
        System.out.print(sb);
    }
    
}