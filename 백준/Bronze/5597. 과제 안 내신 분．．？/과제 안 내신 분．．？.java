import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출석번호 리스트(1-30)
        // unchecked[i]=0이면 미출석
        int[] unchecked = new int[31];
        
        for(int i=0; i<28; i++){
            int checkNum = Integer.parseInt(br.readLine());
            unchecked[checkNum] = 1;
        }
        for(int i=1; i<31; i++){
            if(unchecked[i] == 0){
                System.out.println(i);
            }
        }
    }
}
