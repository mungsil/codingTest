import java.io.*;
import java.util.*;

/*
    * // 공백 4개, 별 1개
   ** // 공백 3개, 별 2개
  *** // 공백 2개, 별 3개
 ****
*****
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<num+1; i++){
            int spaceNum = num-i; 
            for(int j=1; j<num+1; j++){
                if(j<=spaceNum){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}