import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum=0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i< K; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                sum-=stack.poll();
            } else{
                stack.push(input);
                sum+=input;
            }
        }
        
        System.out.print(sum);
    }
}
