import java.util.*;
import java.io.*;
/*
3 3
1 1 0
1 1 1
1 0 1
1 1 1
*/

/*
현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
현재 칸의 주변 4칸이 모두 청소되었다면,
바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
반시계 방향으로 90도 회전한다.
바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 칸인 경우 한 칸 전진한다.
1번으로 돌아간다.
*/
public class Main{
    
    // 북: 0, 동:1, 남 :2, 서: 3
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    private static int cleaned = 0;
    private static int[][] map;
    private static int N;
    private static int M;
    
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        
        // N,M
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        
        // 로봇 청소기 좌표
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());
        
        // 지도 입력
        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        visit(startY, startX, direct);
        System.out.print(cleaned);
    }
    
    private static void visit(int y, int x, int direct){    
        if(map[y][x] == 0){ // 청소 안됨 => 0, 벽 => 1
            map[y][x] = 2; // 청소 완료 => 2
            cleaned++;
        }
        
        // 주변 칸 탐색
        boolean foundUnclean = false;
        for(int i=0; i<4; i++){
            direct = (direct+3)%4; // 회전
            int ny = y + dy[direct];
            int nx = x + dx[direct];
            if(inRange(ny, nx) && map[ny][nx] == 0){ // 청소되지 않은 빈칸
                visit(ny, nx, direct);
                return;
            }
        }
        
        if(!foundUnclean){
            int back = (direct+2)%4;
            int ny = y + dy[back];
            int nx = x + dx[back];
            if(inRange(ny, nx) && map[ny][nx] != 1){ 
                visit(ny, nx, direct); // 1번으로 돌아감
            }    
        }
    }
    
    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
    
}
