import java.util.*;

class MyQueue {

    Deque<Integer> input;
    Deque<Integer> output;

    public MyQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        moveToOutputIfEmpty();

        return output.pop();
    }
    
    public int peek() {
        moveToOutputIfEmpty();

        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void moveToOutputIfEmpty(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }
}
