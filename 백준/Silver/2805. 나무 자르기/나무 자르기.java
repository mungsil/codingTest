import java.util.*;
/*
4 7
20 15 10 17
*/
public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int mustGet = scan.nextInt();
        int[] woods = new int[num]; //20 15 10 17
        
        int maxHeightWood = 0;
        for(int i=0; i<num; i++){
            woods[i] = scan.nextInt();
            maxHeightWood = Math.max(maxHeightWood, woods[i]); //20
        }
        
        int sp =0;
        int ep = maxHeightWood; //20
        
        int answer = 0;
        while(sp<=ep){ // (1,20) (11,20) (16, 20)
            int half = (sp+ep)/2; //10, 15
            long obtainWood = 0;
            for(int i=0; i<num; i++){
                if(woods[i]>half){
                    obtainWood += woods[i]-half;
                }
            }
            
            if(obtainWood >= mustGet){
                answer = half;
                sp = half+1;
            } else{
                ep = half-1;
            }
        }
        
        System.out.print(answer);
        
    }
    
}