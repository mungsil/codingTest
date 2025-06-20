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
        recur(0, 0);   
    }
    
    private static void recur(int step, int visit){
        visited[visit] = 1;
        visitNums[step] = visit;

        if(step == N){
            StringBuilder sb = new StringBuilder();
            for(int n: visitNums){
                if(n==0)continue;
                sb.append(n);
                sb.append(" ");
            }
            System.out.println(sb);
            visitNums[step] = 0;
            visited[visit] = 0;
            return;
        }
        
        for(int i=1; i<=N; i++){
            if(visited[i] == 0){
                recur(step+1, i);
            }           
        }
        visited[visit] = 0;
    }
    
}