import java.util.*;

class Main {

    private static long a;
    private static long b;
    private static long c;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        a = scan.nextLong(); 
        b = scan.nextLong();
        c = scan.nextLong(); 
        
       
        System.out.print(pow(a,b,c));
    }
    
    private static long pow(long base, long exp, long mod){
        if(exp == 0) return 1%mod;
        if(exp == 1) return base % mod;
        
        long half = pow(base, exp/2, mod);
        long result = (half*half) % mod;
        
        if(exp%2==1){
            result = (result*base) %mod;
        }
        return result;
    }

}
