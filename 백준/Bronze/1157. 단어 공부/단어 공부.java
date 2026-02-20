import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next().toUpperCase();
        
        int alphaNum = 'Z'-'A'+1;
        int[] alpha = new int[alphaNum];
        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i)-'A';
            alpha[idx]++;
        }
        
        int maxCount = -1;
        char result = '?';
        for(int i=0; i<alphaNum; i++){
            if(alpha[i] > maxCount){
                maxCount = alpha[i];
                result = (char)(i + 'A');
            } else if (alpha[i] == maxCount){
                result = '?';
            }
        }
        
        System.out.println(result);
    }
}