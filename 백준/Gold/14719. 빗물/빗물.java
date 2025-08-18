import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        
        int[] blocks = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        
        int answer = 0;
        
        // 각 위치에서 왼쪽 최대 높이와 오른쪽 최대 높이를 미리 계산
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        
        // 왼쪽 최대 높이 계산
        leftMax[0] = blocks[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i-1], blocks[i]);
        }
        
        // 오른쪽 최대 높이 계산
        rightMax[W-1] = blocks[W-1];
        for (int i = W-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], blocks[i]);
        }
        
        // 각 위치에서 고일 수 있는 물의 양 계산
        for (int i = 0; i < W; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            if (waterLevel > blocks[i]) {
                answer += waterLevel - blocks[i];
            }
        }
        
        System.out.println(answer);
    }
}