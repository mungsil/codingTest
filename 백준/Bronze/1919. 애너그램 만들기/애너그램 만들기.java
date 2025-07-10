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
        char[] firstChars = firstWord.toCharArray();
        char[] secondChars = secondWord.toCharArray();
        
        Map<Character, Integer> firstCharCount = new HashMap<>(); 
        Map<Character, Integer> secondCharCount = new HashMap<>(); 
        for(char c: firstChars){
            firstCharCount.merge(c, 1, (oldValue, newValue) -> oldValue+newValue);
        }
        for(char c: secondChars){
            secondCharCount.merge(c, 1, (oldValue, newValue) -> oldValue+newValue);
        }
        
        // 통합
        for(char key: firstCharCount.keySet()){
            int count = firstCharCount.get(key);
            secondCharCount.merge(key, count, (oldValue, newValue) -> oldValue-newValue);
        }
        
        var counts = secondCharCount.values();
        int answer = 0;
        for(int count : counts){
            answer += Math.abs(count);
        };
        System.out.print(answer);
    }
    
}