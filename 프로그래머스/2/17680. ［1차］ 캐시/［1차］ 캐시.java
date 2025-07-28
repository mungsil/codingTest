import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new ArrayDeque<>();

        int answer = 0;
        for(String city: cities){
            city = city.toLowerCase();
            
            // 찾는 도시가 큐에 존재하는 경우의 처리 수행
            int updateFlag = 0;
            Iterator<String> visitor = queue.iterator();
            while(visitor.hasNext()){
                String s = visitor.next();
                if(s.equals(city)){
                    visitor.remove();
                    queue.offer(city); 
                    answer += 1; // cache hit
                    updateFlag = 1;
                    break;
                } 
            }
            
            if(updateFlag == 1){
                continue;
            }
        
           if(queue.size() >= cacheSize){
               queue.poll();               
           }
            
            if(cacheSize != 0){
                queue.offer(city);
            }
            
            answer += 5; 
        }
        
        return answer;
    }
}