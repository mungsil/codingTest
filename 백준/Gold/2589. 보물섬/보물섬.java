import java.util.*;
import java.io.*;

public class Main {
    
    private static int row;
    private static int col;
    private static char[][] map;
    private static int[][] upDownLeftRight = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken()); 
        col = Integer.parseInt(st.nextToken()); 

        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray(); 
        }
        
        int answer = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                char node = map[i][j];
                if(node == 'L'){
                    answer = Math.max(answer, bfs(i,j));
                }                
            }
        }
        
        System.out.print(answer);
    }
    
    private static int bfs(int sy, int sx){
        int[][] visited = new int[row][col]; 
        int[][] distance = new int[row][col]; 
        Queue<int[]> visitQueue = new ArrayDeque<>();
        visitQueue.offer(new int[]{sy,sx});
        visited[sy][sx] = 1;
        
        int max = 0;
        while(!visitQueue.isEmpty()){
            int[] visit = visitQueue.poll();
            int y = visit[0];
            int x = visit[1];
            for(int[] candidate : upDownLeftRight){
                int dy = candidate[0];
                int dx = candidate[1];
                
                int ny = y + dy;
                int nx = x + dx;
                if(ny >= 0 && ny < row && nx >= 0 && nx < col){
                    if(map[ny][nx] == 'L'){
                        if(visited[ny][nx] == 0){
                            distance[ny][nx] = distance[y][x]+1;
                            visitQueue.offer(new int[]{ny,nx});
                            visited[ny][nx] = 1;
                            
                            max = Math.max(max, distance[ny][nx]);
                        }
                    }
                }
            }
            
        }
        
        return max;
    }
}