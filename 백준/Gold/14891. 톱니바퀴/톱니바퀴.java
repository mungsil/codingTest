import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] wheels = new int[4][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<4; i++){
            wheels[i] = readWheel(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        
        for(int i=0; i<k; i++){
            rotate(br.readLine());
        }
        int score = 0;
        for(int i=0; i<4; i++){
            int result = wheels[i][0];
            if(result == 1){ // S
                score+= (int) Math.pow(2, i);
            }
        }
        System.out.print(score);
    }
    
    private static void rotate(String input){
        // 회전시킬 톱니바퀴 번호
        String[] parts = input.split(" ");
        int wheelNum = Integer.parseInt(parts[0])-1;
        // 회전 방향 {1:시계}, {-1:반시계}
        int direct = Integer.parseInt(parts[1]);
        
        // === 풀이
        boolean[] rotated = new boolean[4]; // 바퀴 회전 여부
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{wheelNum, direct});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cn = curr[0];
            int cd = curr[1];
            rotated[cn] = true;
            
            int[] wheel = wheels[cn];
            for(int dx: new int[]{-1, 1}){
                int nextWheelNum = cn+dx;
                if(nextWheelNum >= 0 && nextWheelNum <4 &&
                    rotated[nextWheelNum] == false
                ){
                    int[] nWheel = wheels[nextWheelNum];
                    if(dx == 1){ // 오른쪽
                        if(wheel[2] != nWheel[2+4]){
                            queue.add(new int[]{nextWheelNum, cd == 1 ? -1 : 1});
                        }                        
                    } else {
                        if(wheel[2+4] != nWheel[2]){
                            queue.add(new int[]{nextWheelNum, cd == 1 ? -1 : 1});
                        }                        
                    }                    

                }
            }

            int wheelLength = 8;
            // 시계 방향 회전
            // 101
            int[] rotatedWheel = new int[8];
            if(cd==1){
                for(int i=0; i<wheelLength; i++){
                    int toIdx = (i+1) % wheelLength; 
                    rotatedWheel[toIdx] = wheel[i];
                }                
            } else{ // 반시계 방향 회전
               for(int i=0; i<wheelLength; i++){
                    int toIdx = (i+7) % wheelLength; 
                    rotatedWheel[toIdx] = wheel[i];
                } 
            }
            
            wheels[cn] = rotatedWheel;
        }
    }
    
    private static int[] readWheel(String input){
        int[] arr = new int[8];
        for(int i=0; i<8; i++){
            arr[i] = input.charAt(i)-'0';
        }
        return arr;
    }
 }
