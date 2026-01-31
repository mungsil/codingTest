import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int M;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        // map initailization
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j]=line.charAt(j)-'0';
            }
        }
        
        System.out.print(visit());
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static int visit() {        
        boolean[][][] visited = new boolean[N][M][2];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1,0});
        visited[0][0][0] = true;
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            
            int cy = node[0];
            int cx = node[1];
            int cd = node[2];
            int broken = node[3]; // 0이면 not, 1이면 ok
            
            if (cy == N - 1 && cx == M - 1) return cd;
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                // map 범위 내
                if(nx >= 0 && nx < M &&
                    ny >= 0 && ny < N){ 
                        //이동 가능한 경로일 때
                        if(map[ny][nx] == 0 &&
                            visited[ny][nx][broken] == false
                        ){
                            queue.add(new int[]{ny, nx, cd + 1, broken});
                            visited[ny][nx][broken] = true;
                        }
                        
                        // 이동 불가능한 경로일 때
                        if(map[ny][nx] == 1 &&
                            visited[ny][nx][1] == false
                        ){
                            if(broken == 0){
                                queue.add(new int[]{ny, nx, cd + 1, 1});
                                visited[ny][nx][1] = true;
                            }
                        }
                    }
            }
        }
        return -1;
    }
}
