import java.util.*;
/*
aabbcc
xxyybb
*/
public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String firstWord = sc.next();
        String secondWord = sc.next();
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char c : firstWord.toCharArray()) {
            charCount.merge(c, 1, Integer::sum);
        }
        for (char c : secondWord.toCharArray()) {
            charCount.merge(c, -1, Integer::sum); 
        }
        
        int answer = 0;
        for (int count : charCount.values()) {
            answer += Math.abs(count);
        }
        System.out.print(answer);
    }
    
}