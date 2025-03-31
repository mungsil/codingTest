import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] inputs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<inputs.length; i++){
            if(inputs[i] == '('){
                stack.push(inputs[i]);
                continue;
            }
            // ')' 일 경우
            if(stack.size()==0 | (stack.size() != 0 && stack.pop() != '(')){
                stack.push(inputs[i]);
            }
        }
        
        System.out.println("remain components in stack");
        for(Character c: stack){
            System.out.println(c);
        }
        
        if(stack.size() != 0){
            return false;
        }
        
        return true;
    }
}