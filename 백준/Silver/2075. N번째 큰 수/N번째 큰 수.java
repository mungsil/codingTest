import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }
        
        System.out.print(pq.peek());
    }
    
}