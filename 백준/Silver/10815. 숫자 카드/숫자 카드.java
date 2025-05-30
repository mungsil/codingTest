import java.util.*;
/*
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
*/

public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] ownCards = new int[num];
        for(int i=0; i<num; i++){
            ownCards[i] = scan.nextInt();
        }
        Arrays.sort(ownCards);
        
        int guessNum = scan.nextInt();
        int[] guessCards = new int[guessNum];
        for(int i=0; i < guessNum; i++){
            guessCards[i] = scan.nextInt();
        }
        
        int[] answer = new int[guessNum];
        

        for(int i=0; i < guessNum; i++){
            int guessValue = guessCards[i];
            int sp =0;
            int ep = num-1;
            while(sp <= ep){
                int half = (sp + ep)/2;
                int halfValue = ownCards[half];
                if(guessValue == halfValue){
                    answer[i] = 1;
                    break;
                } else if(guessValue > halfValue){
                    sp = half+1;
                } else if(guessValue < halfValue){
                    ep = half-1;
                }
            }
        }
        
        for (int out : answer) {
            System.out.print(out + " ");
        }
    }
    
}