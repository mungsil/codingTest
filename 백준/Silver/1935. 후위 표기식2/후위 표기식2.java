import java.util.*;
/*
5
ABC*+DE/-
1
2
3
4
5
*/
public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] alphaValues = new int[N+1];
        
        String inputChars = scan.next();
        for(int i=1; i<N+1; i++){
            alphaValues[i] = scan.nextInt();
        }
        
        Deque<Double> stack = new ArrayDeque<>();
        for(char c: inputChars.toCharArray()){
            if(isAlpha(c)){
                int value = alphaValues[c - 64];
                stack.push((double)value);
            }else{
                double n2 = stack.pop();
                double n1 = stack.pop();
         
                if(c == '*'){
                    stack.push(n1*n2);
                } else if(c == '+'){
                    stack.push(n1+n2);
                } else if(c== '-'){
                    stack.push(n1-n2);
                } else if(c== '/'){
                    stack.push(n1/n2);
                }
                
            }          
        }
        System.out.printf("%.2f\n", stack.pop());
    }
    
    private static boolean isAlpha(char c){
        if(c >= 65 && c<= 90){
            return true;
        }
        
        return false;
    }
    
}