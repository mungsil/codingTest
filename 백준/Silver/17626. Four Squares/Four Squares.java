import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        if(isSquare(target)){
            System.out.print("1");
            return;
        }
        
        for(int i=1; i*i<target; i++){
            if(isSquare(target-i*i)){
                System.out.print("2");
                return;
            }
        }
        
        for(int i=1; i*i<target; i++){
            for(int j=1; j*j<target; j++){
                if(isSquare(target-i*i-j*j)){
                    System.out.print("3");
                    return;
                }
            }
        }
       
        System.out.print("4");
        return;
    }
    
    private static boolean isSquare(int n){
        int root = (int) Math.sqrt(n);
        return root*root == n;
    } 
    
}