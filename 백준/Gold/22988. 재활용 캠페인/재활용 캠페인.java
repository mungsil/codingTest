import java.util.*;
/*
7 13
0 1 2 3 5 8 13
*/
public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        long volume = scan.nextLong();     
        long[] items = new long[num];
        scan.nextLine(); // 개행 제거

        String[] tokens = scan.nextLine().split(" ");
        for(int i = 0; i < num; i++) {
            items[i] = Long.parseLong(tokens[i]);
        }
        
        Arrays.sort(items);
        int sp = 0;
        int ep = num-1;
        int answer = 0;
        int remain = 0;
        
        while(sp <= ep){
            if(items[ep] == volume){
                ep--;
                answer++;
                continue;
            }
            
            if(sp == ep){
                remain++;
                break;
            }
            
            if(items[sp] + items[ep] >= ((volume+1)/2)){
                answer++;
                sp++;
                ep--;
            } else{
                sp++;
                remain++;
            }
        }
        System.out.println(answer + (remain / 3));

    }
    
}