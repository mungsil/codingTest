import java.util.*;
/*
13
0
1
2
0
0
3
2
1
0
0
0
0
0
*/
public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            int input = scan.nextInt();
            if(input == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            } else { 
                 pq.offer(input);  
            }
        }
        System.out.print(sb);
    }
    
}