import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if(N == 1){
            System.out.print("*");
            return;
        }
        
        String star = "*";
        String empty = " ";

        for(int i=1; i<N; i++){
            String output = empty.repeat(N-i) + star.repeat(2*i-1);
            System.out.println(output);         
        }

        for(int i=N; i>0; i--){
            String output = empty.repeat(N-i) + star.repeat(2*i-1);
            System.out.println(output);         
        }
    }
}
