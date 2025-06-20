import java.util.*;

public class Main{
    
    private static int N;
    private static int[] visited;
    private static int[] visitNums;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        visited = new int[N+1];
        visitNums = new int[N+1];
        recur(0);   
    }
    
    private static void recur(int step){
        if(step == N){
            StringBuilder sb = new StringBuilder();
            for(int n: visitNums){
                if(n==0)continue;
                sb.append(n);
                sb.append(" ");
            }
            System.out.println(sb);
            return;
        }
        
        for(int i=1; i<=N; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                visitNums[step] = i;
                recur(step+1);
                visited[i] = 0;
            }           
        }
    }
    
}