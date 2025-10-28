import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for(int i=0; i < size; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int[] subArr = new int[end-start];
            System.arraycopy(array, start, subArr, 0, end-start);
            Arrays.sort(subArr);
            answer[i] = subArr[commands[i][2]-1];
        }
        
        return answer;
    }
    
}