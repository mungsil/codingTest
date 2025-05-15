/*
2
3 8
5 8
*/

import java.util.*;

public class Main{
    private static int givenIngreNum;
    private static List<Ingredient> givenIngres = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    
    static class Ingredient{
        int sour;
        int bitter;
        
        Ingredient(int sour, int bitter){
            this.sour = sour;
            this.bitter = bitter;
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        givenIngreNum = scan.nextInt();
        for(int i=0; i<givenIngreNum; i++){
            int sour = scan.nextInt();
            int bitter = scan.nextInt();
            givenIngres.add(new Ingredient(sour, bitter));
        }
        
        recur(0, 1, 0, 0);
        System.out.print(min);
    }
    
    private static void recur(int step, int priorSour, int priorBitter, int used){
        if(step == givenIngreNum){
            if(used > 0){
                min = Math.min(min, Math.abs(priorSour - priorBitter));
            }
            
            return;
        }
        
        int currentSour = givenIngres.get(step).sour;
        int currentBitter = givenIngres.get(step).bitter;
        
        recur(step + 1, priorSour, priorBitter, used);
        recur(step + 1, priorSour*currentSour, priorBitter+currentBitter, ++used);
    }
    
}