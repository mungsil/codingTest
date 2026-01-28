import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String numsInStr = scan.next();
        int leftP = 0;
        int rightP = N-1;
        int answer = 0;

        while(leftP <= rightP){
            if(leftP == rightP){
                answer += numsInStr.charAt(leftP) - '0';
            } else{
                int leftV = numsInStr.charAt(leftP) - '0';
                int rightV = numsInStr.charAt(rightP) - '0';
                
                answer += leftV;
                answer += rightV;                
            }

            leftP++;
            rightP--;
        }
        System.out.print(answer);
    }
}
