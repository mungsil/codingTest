import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int a : arr){
            while(!stack.isEmpty() && stack.peek().equals(a)){
                stack.pop();
            }
            stack.push(a);
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!stack.isEmpty()){
            answer.add(stack.pollLast());
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}