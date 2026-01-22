import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boundaris = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = boundaris[0];
        int m = boundaris[1]; 
        
        // 바구니 생성
        int[] containers = new int[n+1];
        int order = 1;
        for(int i=1; i<n+1; i++){
            containers[i] = order++;
        }
        
        // 바구니 뒤집기
        for(int mp = 0; mp < m; mp++){
            int[] ij = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 1<= i<=j <= N
            int leftP = ij[0];  
            int rightP = ij[1]; 
            
            while(leftP<rightP){
                int temp = containers[leftP];
                containers[leftP] = containers[rightP];
                containers[rightP] = temp;
                leftP++; rightP--;             
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(containers[i]).append(" ");
        }
        System.out.print(sb);
    }
}
