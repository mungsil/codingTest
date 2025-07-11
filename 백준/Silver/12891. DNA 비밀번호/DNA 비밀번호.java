import java.util.*;
/*
9 8
CCTGGATTG
2 0 1 1
*/
public class Main{
    
    private static char[] genes = {'A', 'C', 'G', 'T'};
    private static int[] geneRules = new int[30];
    private static int[] charCount;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int givenCharSize = sc.nextInt();
        int partialCharSize = sc.nextInt();
        char[] givenChars = sc.next().toCharArray();
        
        for(char g: genes){
            geneRules[g-'A'] = sc.nextInt();
        }
        
        // 풀이
        int answer = 0;
        charCount = new int[30];
        for(int i=0; i<partialCharSize; i++){
            charCount[givenChars[i]-'A'] += 1;
        }
        
        if(ensureSatisfyRule()){
            answer++;
        }
        
        for(int i= partialCharSize; i<givenCharSize; i++){
            charCount[givenChars[i-partialCharSize]-'A']--;
            charCount[givenChars[i]-'A']++;
            if(ensureSatisfyRule()){
                answer++;
            }
        }
        
        System.out.print(answer);        
    }
    
    private static boolean ensureSatisfyRule(){
       for(char g: genes){
          if(geneRules[g-'A'] > charCount[g-'A']){
             return false;
          }
       }
        
        return true;
    }
    
}