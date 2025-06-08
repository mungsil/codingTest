import java.util.*;
import java.io.*;

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
*/
public class Main{
    
    private static int M; 
    private static int N;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] leftRightUpDown = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        
        int k = Integer.parseInt(st.nextToken());
        int[][] coloredParts = new int[k][4];

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            coloredParts[i] = new int[]{x1, y1, x2, y2};
        }
        
        // 입력받은대로 색칠하기
        for(int[] part : coloredParts){
            for(int x1 = part[0]; x1 < part[2] ; x1++){ 
                for(int y1 = part[1]; y1 < part[3]; y1++){ 
                    map[y1][x1] = 1;
                }
            }
        }
        
        visited = new boolean[M][N]; 
        List<Integer> areas = new ArrayList<>();
        for(int y = 0; y < M; y++){
            for(int x = 0; x < N; x++){
                if(!visited[y][x] && map[y][x] != 1){
                    areas.add(visit(y, x));
                }
            }
        }
        
        Collections.sort(areas);
        System.out.println(areas.size());
        for(int area : areas){
            System.out.print(area + " ");
        }
    }
    
    private static int visit(int y, int x){
        visited[y][x] = true;
        int size = 1;
        
        for(int[] next : leftRightUpDown){
            int nx = x + next[0];
            int ny = y + next[1];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(!visited[ny][nx] && map[ny][nx] != 1){
                    size += visit(ny, nx);
                } 
            }
        }
        
        return size;
    }
    
}