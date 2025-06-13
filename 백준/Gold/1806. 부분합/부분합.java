import java.util.*;
import java.io.*;
/*
10 15
5 1 3 5 10 7 4 9 2 8
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken());
        int minSum = Integer.parseInt(st1.nextToken());

        int[] array = new int[num];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }

        int sp = 0;
        int sum = 0; 
        int minLength = Integer.MAX_VALUE;
        for(int ep = 0; ep < num; ep++){
            sum += array[ep];
            while(sum >= minSum){
                minLength = Math.min(minLength, ep-sp+1);
                sum -= array[sp];
                sp++;
            }
        }
        
        System.out.print(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
