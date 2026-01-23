import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L;
    static int[][] board;
    static Map<Integer, String> moveInfo = new HashMap<>();
    static int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌 (시계방향)
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 보드 크기
        board = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine()); // 사과 개수
        
        // 사과 위치 표시
        for(int i=0; i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 2;
        }
        
        // 뱀의 방향 변환 정보를 맵에 저장
        int L = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            moveInfo.put(x, d);
        }
        
        solve();
    }
    
    private static void solve(){
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1,1});
        board[1][1] = 1;
        
        int time = 0;
        int currDir = 1; // 오른쪽
        
        while(true){
            time++;
            // 머리 사전 준비
            int[] head = snake.peek();
            int nx = head[1] + dx[currDir];
            int ny = head[0]+ dy[currDir];
            
            if(nx < 1 || nx > N || ny < 1 || ny > N){
                System.out.println(time);
                return;
            }
            
            if(board[ny][nx] == 1){
                System.out.println(time);
                return;
            }
            
            // 꼬리 이동
            if(board[ny][nx] != 2){
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }
            
            // 머리 이동
            board[ny][nx] = 1;
            snake.addFirst(new int[]{ny, nx});
            
            // 대가리 방향 전환
            if(moveInfo.containsKey(time)){
                String d = moveInfo.get(time);
                if(d.equals("D")){ // 오른쪽 전환
                    currDir = (currDir+1) %4;                  
                } else{
                    currDir = (currDir+3) %4;  
                }
            }
        }
    }
}
