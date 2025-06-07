import java.util.*;

public class Main{
    
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] parents;
    private static int[] visited;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int nodeNum = scan.nextInt();
        parents = new int[nodeNum+1];
        visited = new int[nodeNum+1];
        
        for(int i=0; i<nodeNum+1; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<nodeNum-1; i++){
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        recur(1, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= nodeNum; i++) {
            sb.append(parents[i]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static void recur(int curr, int parent){
        parents[curr] = parent;
        visited[curr] = 1;
        for(int child: graph.get(curr)){
            if(visited[child] != 1){
                recur(child, curr);
            }
        }
    }
    
}