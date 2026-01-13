import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startN = scan.nextInt();
        int endN= scan.nextInt();
        for(int i=startN; i<=endN; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    
    private static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2; i*i<= n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}