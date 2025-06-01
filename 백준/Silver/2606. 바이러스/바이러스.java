import java.util.*;

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
*/

public class Main{
    
    private static int[] visited;
    private static List<List<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int computerNum = scan.nextInt();
        
        for(int i=0; i < computerNum+1; i++){
            graph.add(new ArrayList<>());
        }
        
        int linkNum = scan.nextInt();
        for(int i=0; i < linkNum; i++){
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        
        visited = new int[computerNum+1];
        recur(1);
        
        int sum = 0;
        for(int log : visited){
            sum += log;
        }
        System.out.print(sum-1);
    }
    
    private static void recur(int visit){
        visited[visit] = 1;
        
        List<Integer> toVisit = graph.get(visit);
        for(int to : toVisit){
            if(visited[to] == 1){
                continue;
            }
            recur(to);
        }
    }
    
}