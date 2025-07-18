// 큐 두 개 이용 풀이

class MyStack {

    Queue<Integer> mainQueue;
    Queue<Integer> subQueue;

    public MyStack() {
        mainQueue = new ArrayDeque<>();
        subQueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(mainQueue.isEmpty()){
            mainQueue.offer(x);
        } else{
            while(!mainQueue.isEmpty()){
                subQueue.offer(mainQueue.poll());
            }
            mainQueue.offer(x);

            while(!subQueue.isEmpty()){
                mainQueue.offer(subQueue.poll());
            }
        }
    }
    
    public int pop() {
        return mainQueue.poll();
    }
    
    public int top() {
        return mainQueue.peek();
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
