import java.util.*;

/*
657 3
1 5 7
*/

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String K = sc.next();
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int si = 0; si <= N; si++){
            sb.append(si);
            if(si < 10){
                sb.append(0);
            }
            for(int bun = 0; bun <= 59; bun++){
                sb.append(bun);
                if(bun < 10){
                    sb.append(0);
                }
                for(int cho = 0; cho <= 59; cho++){
                    sb.append(cho);
                    if(cho < 10){
                        sb.append(0);
                    }                    
                    if(sb.indexOf(K) >= 0){
                        count++;
                    }
                    sb.delete(4,6);
                }
                sb.delete(2,4);
            }
            sb.delete(0,2);
        }
        System.out.print(count);
        
    }
    
}