import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int answer = 1;
        if(n == 0 || n==1){
            System.out.print(answer);
            return;
        }
        for(int i=2; i<=n; i++){
            answer*= i;
        }
        System.out.print(answer);
    }
}
