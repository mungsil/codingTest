import java.io.*;
import java.util.*;

public class Main{
    
    static int[][] gear = new int[4][8];
    static int[] d; // 각 톱니바퀴 회전 방향
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = line.charAt(j) - '0';
            }
        }
        
        int K = Integer.parseInt(br.readLine()); // 회전 횟수
        while(K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1; // 바퀴 번호 (0~3)
            int dir = Integer.parseInt(st.nextToken()); // 방향 (1: 시계, -1: 반시계)
            
            d = new int[4];
            d[idx] = dir;
            
            checkLeft(idx);
            checkRight(idx);
            
            for(int i=0; i<4; i++){
                if(d[i]!=0)rotate(i, d[i]);
            }
        }
        
        int score = 0;
        for(int i=0; i<4; i++){
            if(gear[i][0] == 1) {
                score+=Math.pow(2,i);
            }
        }
        System.out.println(score);
    }
    
    static void checkLeft(int idx){
        if(idx > 0 && gear[idx][6] != gear[idx-1][2]){
            d[idx-1] = -d[idx];
            checkLeft(idx-1);
        }
    }
    
    static void checkRight(int idx){
        if(idx < 3 && gear[idx][2] != gear[idx+1][6]){
            d[idx+1] = -d[idx];
            checkRight(idx+1);
        }
    }
    
    static void rotate(int idx, int dir){
        if(dir == 1){ // 시계
            int temp = gear[idx][7];
            for(int i=7; i>0; i--){
                gear[idx][i] = gear[idx][i-1];
            }
            gear[idx][0] = temp;
        } else{ // 반시계
            int temp = gear[idx][0];
            for(int i=0; i<7; i++){
                gear[idx][i] = gear[idx][i+1];
            }
            gear[idx][7] = temp;
        }
    }
    
}