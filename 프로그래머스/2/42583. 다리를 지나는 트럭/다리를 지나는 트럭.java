import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int finish_truck_num = 0;
        int wating_truck_num = truck_weights.length;
        
        int road_weight = 0;
        int road_truck_num = 0;
        
        int limit_weight = weight;
        
        Queue<Integer> waitingTrucks_w = new ArrayDeque<>();
        
        // make a wating truck queue
        for(int truck_w:truck_weights){
            waitingTrucks_w.add(truck_w);
        }
        
        Queue<int[]> runwayTrucks_t = new ArrayDeque<>(); 
        
        while(finish_truck_num != wating_truck_num){
            answer++;
            
            for(int[] runway_truck: runwayTrucks_t){
                runway_truck[0] -= 1; // 0번째 자리 = 시간
                
                if(runway_truck[0]==0){
                    int[] t = runwayTrucks_t.poll();
                    road_weight -= t[1];
                    finish_truck_num++;
                }
            }
            
            if(waitingTrucks_w.peek() == null){
                continue;
            }
            
            // 무게 검사 및 길이 검사
            if(runwayTrucks_t.size() + 1 <= bridge_length // ? + 1 <= 2
                &&
               road_weight + waitingTrucks_w.peek() <= limit_weight) 
            { 
                runwayTrucks_t.add(new int[]{bridge_length, waitingTrucks_w.peek()});
                road_weight += waitingTrucks_w.poll(); 
            }
            
            
        }
    
        return answer;
    }
}
