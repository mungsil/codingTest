/**
1
2
3
4
5
6
7
8
9
10
**/

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
         for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        //[1,2,3,4,5,6,7,8,9,10]
        
        int answerNum=0;
        for(int i=0; i<42; i++){
            int answerMarker =0;
            
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                int input = iter.next();
                if (input % 42 == i) {
                    iter.remove();
                    answerMarker = 1;
                }
            }
            if(answerMarker==1){
                answerNum++;
            }
            if(answerNum==10){
                break;
            }
        }
        System.out.print(answerNum);
    }
} 