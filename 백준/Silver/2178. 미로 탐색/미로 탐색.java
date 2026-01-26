import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Deque<int[]> queue;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken()); // y
        M = Integer.parseInt(st1.nextToken()); // x
        
        board = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] =s.charAt(j)-'0';
            }
        }
        
        queue = new ArrayDeque<>();
        queue.addLast(new int[]{0,0,1});
        visited[0][0] = 1;
        visit();
        System.out.print(answer);
    }
    
    private static void visit(){   
        while(queue.size() != 0){
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            int moveNum = node[2];
            
            if(y == N-1 && x == M-1){
                answer = Math.min(answer, moveNum);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int ny = node[0]+dy[i];
                int nx = node[1]+dx[i];
                //System.out.println("다음 이동 노드 탐색");
                if( nx >= 0 && nx < M && ny >= 0 && ny < N
                    && visited[ny][nx] == 0
                    && board[ny][nx] != 0 
                ){
                    // System.out.println("이동 가능: "+ny+","+nx);
                    visited[ny][nx] = 1;
                    queue.addLast(new int[]{ny, nx, node[2]+1});
                }           
            }
        }
    }
}
