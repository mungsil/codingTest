import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scv : scoville){
            pq.add(scv);
        }
        
        while(pq.size() >= 2 ){
            if(pq.peek() >= K ){ pq.poll(); }
            else{
                pq.add(pq.poll() + pq.poll() * 2);
                answer ++;
            }       
        }
        
        if(pq.size() == 1 && pq.poll() < K){
            return -1;
        }
        
        return answer;
    }
}