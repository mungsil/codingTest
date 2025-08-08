import java.util.*;
/*
8
4
3
6
8
7
5
2
1
*/
public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;
        stack.push(current);
        sb.append('+').append('\n');    

        for(int i = 0; i < num; i++){
            int target = scan.nextInt();
            while(target > current){
                current++; 
                stack.push(current); 
                sb.append('+').append('\n');                    
            }
            
            Integer top = stack.pop();
            if(top != null && top == target){
                sb.append('-').append('\n');
            } else{
                System.out.print("NO");
                return;
            } 
        }
        
        System.out.print(sb);
    }
    
}