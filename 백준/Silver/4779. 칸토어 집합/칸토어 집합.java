import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) { 
            int n = scan.nextInt();
            StringBuilder hipens = new StringBuilder();
            int hipenNum = (int) Math.pow(3, n);
            for(int i=0; i < hipenNum; i++){
                hipens.append("-");
            }
            removeMidHipen(0, hipenNum, hipens);
            System.out.println(hipens);
        }
    }
    
    private static void removeMidHipen(
        int inclusiveStartIdx, int exclusiveEndIdx, StringBuilder hipens
    ){
        if(exclusiveEndIdx - inclusiveStartIdx <= 1){
            return;
        }
        
        int partSize = (exclusiveEndIdx - inclusiveStartIdx) / 3;
        int midStart = inclusiveStartIdx + partSize; 
        int midEnd = inclusiveStartIdx + 2*partSize; 
        for (int i = midStart; i < midEnd; i++) {
            hipens.setCharAt(i, ' ');
        }
        
        removeMidHipen(inclusiveStartIdx, midStart, hipens);
        removeMidHipen(midEnd, exclusiveEndIdx, hipens);
    }
    
}