import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] positionByValue = new String[100];
        int max = Integer.MIN_VALUE;
        String position = null;
        
        // 목표: 최댓값 찾기, 최댓값의 위치(행, 열)
        // 입력
        for(int y=0; y<9; y++){
            int[] row = Arrays.stream(br.readLine().split(" "))
            .mapToInt(i-> Integer.parseInt(i))
            .toArray();
            
            for(int x=0; x<9; x++){
                if(max < row[x]){
                    max = row[x];
                    position = (y+1) + " " + (x+1);
                }
            }
        }
        
        System.out.println(max);
        System.out.println(position);
        
        // solution 2. 값은 자연수
        // - 값을 인덱스로, 위치를 값으로.
        // - 100부터 0이 아닌 값을 가지는 인덱스를 찾는다.
    }
}
