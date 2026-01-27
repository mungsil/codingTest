import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int sharkY, sharkX, sharkSize = 2, ateFish = 0, totalTime = 0;
    static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    board[i][j] = 0; // 상어 위치 초기화
                }
            }
        }
        
        while(true){
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1[2] != o2[2]){
                    return Integer.compare(o1[2],o2[2]);
                }
                if(o1[0] != o2[0]){
                    return Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            });
            
            boolean[][] visited = new boolean[N][N];
            pq.add(new int[]{sharkY, sharkX, 0});
            visited[sharkY][sharkX] = true;
            
            boolean ate = false;
            
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                
                // 먹을 수 있는 물고기를 찾음
                if(board[curr[0]][curr[1]] > 0 && board[curr[0]][curr[1]] < sharkSize){
                    board[curr[0]][curr[1]] = 0;
                    ateFish++;
                    if (ateFish == sharkSize) {
                        sharkSize++;
                        ateFish = 0;
                    }
                    
                    totalTime += curr[2]; // 거리만큼 시간 추가
                    sharkY = curr[0];
                    sharkX = curr[1];
                    ate = true;
                    break;
                }
                
                for(int i=0; i<4; i++){
                    int ny = curr[0] + dy[i];
                    int nx = curr[1] + dx[i];
                    
                    if(ny >= 0 && ny < N
                         && nx >=0 && nx < N 
                         && !visited[ny][nx]){
                        if(board[ny][nx] <= sharkSize){
                            visited[ny][nx] = true;
                            pq.add(new int[]{ny, nx, curr[2] + 1});
                        }
                    }
                }
            }
            if (!ate) break;
        }
        System.out.println(totalTime);
    }
}
