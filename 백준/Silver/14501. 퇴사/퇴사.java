import java.util.*;
/*
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
*/
public class Main{
    private static int workableDay;
    private static int[][] days;
    private static int maxPrice =Integer.MIN_VALUE;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        workableDay = scan.nextInt();
        
        days = new int[workableDay][2];
        for(int i = 0; i<workableDay; i++){
            days[i][0] = scan.nextInt();
            days[i][1] = scan.nextInt();
        }
        
        recur(0,0,0);
        System.out.print(maxPrice);
    }
    
    private static void recur(int step, int price, int watingDay){
        if(step==workableDay){
            maxPrice = Math.max(maxPrice, price);
            return;
        }
        
        if(watingDay > 0){
            recur(step+1, price, watingDay-1);
        }else if( days[step][0] + step <= workableDay){
            recur(step+1, price + days[step][1], days[step][0]-1);
            recur(step+1, price, watingDay);
        }else{
            recur(step+1, price, watingDay);
        }
        
    }
}