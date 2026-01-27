import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] board;
    static int N;
    static int caseNum = 1; // 테스트 케이스 번호 카운트
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break; // 문서 끝 체크
            
            N = Integer.parseInt(line.trim()); // 공백 제거 후 N 읽기
            if (N == 0) break; // 0이면 종료

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            caseNum++; 
        }
    }
    
    static int[] dy = {-1,1,0,0}; // 상하좌우
    static int[] dx = {0,0,1,-1}; 
    
    private static void solve(){
        int answer = 0;
        int[][] dij = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
               dij[i][j] = Integer.MAX_VALUE;    
            }
       }
    
        dij[0][0] = board[0][0];
        
        // int[3] = {y,x,rupee}
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                return Integer.compare(o1[2], o2[2]);
        });
            
        queue.offer(new int[]{0,0,dij[0][0]});
        
        while(queue.peek() != null){
            int[] node = queue.poll();
            
            
            for(int i=0; i<4; i++){
                int ny = dy[i] + node[0];
                int nx = dx[i] + node[1];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N ){
                    int nextCost = board[ny][nx] + node[2];
                    if(nextCost < dij[ny][nx]){
                        dij[ny][nx] = nextCost;
                        queue.add(new int[]{ny, nx, nextCost});
                    }
                }
            }

        }
        
        System.out.println("Problem " + caseNum + ": " + dij[N - 1][N - 1]);
    }
}
