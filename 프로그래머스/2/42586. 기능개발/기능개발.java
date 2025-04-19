import java.util.*;

class Solution {
    class Progress{
        int init;
        int updated;
        int speed;
        
        public Progress(int init, int speed){
            this.init = init;
            this.updated = init;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        Queue<Progress> progressQueque = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            progressQueque.offer(new Progress(progresses[i], speeds[i]));
        }
        
        while(progressQueque.peek() != null){
            
            while(progressQueque.peek() != null && progressQueque.peek().updated<100){
                for(Progress updating : progressQueque){
                    updating.updated += updating.speed;
                }
            }
            
            int count = 0;
            while(progressQueque.peek() != null && progressQueque.peek().updated >= 100){
                progressQueque.poll();
                count++;
            }
            
            answers.add(count);
        }
        
        return answers.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    
    
}














