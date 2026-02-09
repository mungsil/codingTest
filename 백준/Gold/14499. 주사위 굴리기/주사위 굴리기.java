import java.util.*;
import java.io.*;

public class Main {
    
    static int[] input = new int[6];
    static int[][] map;
    static int N; // 세로, x
    static int M; // 가로, y
    static int x; // 0<= x <= n-1
    static int y; // 0<= y <= m-1
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // map 초기화
        map = new int[N][M];
        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        // 이동
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int direct = Integer.parseInt(st3.nextToken());
            move(direct);
        }
    }
    
    static int[] dy = {0,0,-1,1}; // 동, 서, 북, 남
    static int[] dx = {1,-1,0,0}; 
    static int[] dice = new int[6];
    // dice = {상단, 북, 동, 남, 서, 하단}
    
    private static void move(int direct){
        // 다음 이동 위치 계산
        int ny = dy[direct-1] + y;
        int nx = dx[direct-1] + x;
        // 이동 가능하다면 이동
        if(ny >= 0 && ny < N && nx >=0 && nx < M){
            x = nx;
            y = ny;
            updateDice(direct);
            if(map[y][x] == 0){
                map[y][x] = dice[5];
            } else{
                dice[5] = map[y][x];
                map[y][x] = 0;
            }
            System.out.println(dice[0]);
        }

    }
    
    
    private static void updateDice(int direct){
        int[] d = dice.clone();
        // 남쪽
        if(direct == 4){
            // 남쪽 => 하단, 하단 => 북쪽, 북쪽 => 상단, 상단 => 남쪽
            dice[5] = d[3];
            dice[1] = d[5];
            dice[0] = d[1];
            dice[3] = d[0];
        }
        else if(direct == 3){
            // 남쪽 => 상단, 상단 => 북쪽, 북쪽 => 하단, 하단 => 남쪽
            dice[0] = d[3];
            dice[1] = d[0];
            dice[5] = d[1];
            dice[3] = d[5];
        }
        // dice = {상단, 북, 동, 남, 서, 하단}
        // 서쪽
        else if(direct==2){
            // 서쪽 => 하단, 하단 => 동쪽, 동쪽 => 상단, 상단 => 서쪽
            dice[5] = d[4];
            dice[2] = d[5];
            dice[0] = d[2];
            dice[4] = d[0];
        }
        else if(direct == 1){
            // 서쪽 => 상단, 상단 => 동쪽, 동쪽 => 하단, 하단 => 서쪽
            dice[0] = d[4];
            dice[2] = d[0];
            dice[5] = d[2];
            dice[4] = d[5];
        }
              
    }
}
