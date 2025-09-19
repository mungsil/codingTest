import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = 0;
        for(int i=1; i<N; i++){
            int sum = i;
            for(char c: String.valueOf(i).toCharArray()){
                sum += c-'0';
            }
            if(sum == N){
                M = i;
                break;
            }
        }
        System.out.print(M);
        
    }
    
}