import java.util.*;

public class Main{
    private static int workableDay;
    private static int[][] days;
    private static int maxPrice =Integer.MIN_VALUE;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        workableDay = scan.nextInt();
        
        days = new int[20][2];
        for(int i = 0; i<workableDay; i++){
            days[i][0] = scan.nextInt();
            days[i][1] = scan.nextInt();
        }
        
        recur(0,0);
        System.out.print(maxPrice);
    }
    
    private static void recur(int step, int price){
        if(step>workableDay){
            return;
        }
        if(step==workableDay){
            maxPrice = Math.max(maxPrice, price);
            return;
        }
        
        recur(step + days[step][0], price+days[step][1]);
        recur(step+1, price);
    }
}