import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int M;
    static int[][] arr;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        // process input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        solve(3);
        System.out.print(answer);
    }
    
    private static void solve(int num){ // 3
        if(num==0){            
            int size = calculateResultAndGetSafeAreaSize();
            answer = Math.max(size, answer);
            return;
        }
        // find one
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    solve(num-1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    
    private static int calculateResultAndGetSafeAreaSize(){
        // 바이러스 퍼뜨리기
        int[][] copiedArr = copy();
        startVirous(copiedArr);   
        
        // 0 계산하기
        int safeArea = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copiedArr[i][j] == 0){
                    safeArea++;  
                }
            }
        }
        
        return safeArea;
    }
    
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    private static void startVirous(int[][] copiedArr){
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copiedArr[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int cy = node[0];
            int cx = node[1];
            
            copiedArr[cy][cx] = 2;
            
            for(int i=0; i<4; i++){
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M){
                    continue;
                }
                if(copiedArr[ny][nx] == 0){
                    copiedArr[ny][nx] = 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
    
    private static int[][] copy(){
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}
