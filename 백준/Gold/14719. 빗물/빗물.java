import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        int num = size[1];
  
        int[] blocks = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int answer = 0;
        int leftP = 0;
        int leftMaxH = blocks[leftP];
        int rightP = num-1;
        int rightMaxH = blocks[rightP];
 
        while(leftP < rightP){
            leftMaxH = Math.max(leftMaxH, blocks[leftP]);
            rightMaxH = Math.max(rightMaxH, blocks[rightP]);
            
            if(leftMaxH <= rightMaxH){
                answer += leftMaxH - blocks[leftP];
                leftP++;
            } else{
                answer += rightMaxH - blocks[rightP];
                rightP--;
            }
        }
        
        System.out.println(answer);
    }
    
}