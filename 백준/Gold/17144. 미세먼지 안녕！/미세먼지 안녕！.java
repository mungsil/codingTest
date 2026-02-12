import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] room;
    static int R;
    static int C;
    static int upAirCleanerRow = 0;
    static int downAirCleanerRow = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        R = Integer.parseInt(st.nextToken());
        // 가로
        C = Integer.parseInt(st.nextToken());
        // time
        int T = Integer.parseInt(st.nextToken());
        
        room = new int[R][C];
        for(int r=0; r<R; r++){
            int[] line = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            for(int c = 0; c<C; c++){
                room[r][c] = line[c];
                if(line[c] == -1){
                    if(upAirCleanerRow == 0){
                        upAirCleanerRow = r;
                    } else{
                        downAirCleanerRow = r;
                    }
                    
                }
            }
        }
        
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        
        // 풀이
        // loop for T sec
        while(T-- > 0) { 
            int[][] dustMovedRoom = new int[R][C];
            // 미세먼지 확산
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    int dust = room[r][c];
                    int out = dust/5;
                    if(dust == -1){
                        dustMovedRoom[r][c] = -1;
                        continue;
                    }
                    if(dust > 0){
                        int outNum = 0;
                        for(int d=0; d<4; d++){
                            int nr = dr[d] + r;
                            int nc = dc[d] + c;
                            if(nr >= R || nr < 0 || nc >= C || nc < 0 ||
                                room[nr][nc] == -1){
                                continue;
                            }
                            dustMovedRoom[nr][nc] += out; 
                            outNum++;
                        }
                        dustMovedRoom[r][c] += room[r][c] - out*outNum; // 8 - 3 = 5
                    }
                }
            }
            
            room = dustMovedRoom;
            purify();
        } 
         
        // 미세먼지 총합 계산
        int answer = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(room[r][c] > 0){
                    answer += room[r][c];
                }
            }
        }
        
        System.out.print(answer);
    }
    
    private static void purify(){
        // 윗칸 반시계 회전
        for(int i=upAirCleanerRow-1; i>0; i--){
            room[i][0] = room[i-1][0];
        }
        for(int i=0; i<C-1; i++){
            room[0][i] = room[0][i+1];
        }
        for(int i=0; i<upAirCleanerRow; i++){
            room[i][C-1] = room[i+1][C-1];
        }
        for(int i=C-1; i>1; i--){
            room[upAirCleanerRow][i] = room[upAirCleanerRow][i-1];
        }
        room[upAirCleanerRow][1] = 0;
        
        // 아랫칸 시계 회전
        for (int i = downAirCleanerRow + 1; i < R - 1; i++) room[i][0] = room[i + 1][0];
        for (int i = 0; i < C - 1; i++) room[R - 1][i] = room[R - 1][i + 1];
        for (int i = R - 1; i > downAirCleanerRow; i--) room[i][C - 1] = room[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) room[downAirCleanerRow][i] = room[downAirCleanerRow][i - 1];
        room[downAirCleanerRow][1] = 0;
    }
    
}
