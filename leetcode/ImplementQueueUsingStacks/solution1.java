import java.util.*;

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // stack 1의 요소를 stack 2로 옮기기
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        // stack 1에 push x
        stack1.push(x);

        // stack 2 -> stack 1 복구
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
