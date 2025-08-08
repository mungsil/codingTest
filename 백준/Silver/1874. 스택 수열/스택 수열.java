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
        int currentNum = 1;
        stack.push(currentNum);
        sb.append('+').append('\n');   

        for(int i = 0; i < num; i++){
            int out = scan.nextInt();
            if(stack.isEmpty()){
                stack.push(++currentNum);
                sb.append('+').append('\n');  
            }
            
            if(out < stack.peek()){
               System.out.print("NO");
               return;
            }

            while(out > stack.peek()){
                currentNum++; 
                stack.push(currentNum); 
                sb.append('+').append('\n');                    
            }
            
            stack.pop();
            sb.append('-').append('\n');
        }
        
        System.out.print(sb);
    }
    
}