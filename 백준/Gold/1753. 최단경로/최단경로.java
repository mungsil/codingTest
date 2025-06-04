import java.util.*;
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/

public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int nodeNum = scan.nextInt(); 
        int linkNum = scan.nextInt();
        int startNodeNum = scan.nextInt();
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeNum; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distances = new int[nodeNum+1];
        Arrays.fill(distances, 1_000_000_000);
        
         for(int i=0; i < linkNum; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int dist = scan.nextInt();
            graph.get(from).add(new int[]{to, dist});
        }
       
        PriorityQueue<int[]> toVisitNodeQ = new PriorityQueue<>((a, b)-> Integer.compare(a[0], b[0]));
        toVisitNodeQ.offer(new int[]{0, startNodeNum}); 
        distances[startNodeNum] = 0;
        
        while(!toVisitNodeQ.isEmpty()){
            int[] visitNode = toVisitNodeQ.poll();
            int currentNode = visitNode[1];
            
            for(int[] connectedNode : graph.get(currentNode)){
                int nextNode = connectedNode[0];
                int toNextDistance = connectedNode[1];
                if(distances[currentNode] + toNextDistance < distances[nextNode]){
                    distances[nextNode] = distances[currentNode] + toNextDistance;
                    toVisitNodeQ.offer(new int[]{distances[nextNode], nextNode});
                }
            }
        }
        
        for(int i=1; i < nodeNum+1; i++){
            if(distances[i] == 1_000_000_000){
                System.out.println("INF");
                continue;
            }
            System.out.println(distances[i]);
        }
    }
    
}