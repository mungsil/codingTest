import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Set<String> cache = new LinkedHashSet<>();
        
        int answer = 0;
        for(String city: cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else{
                if(cacheSize ==0){
                    answer += 5;
                    continue;
                }
                
                if(cache.size() >= cacheSize){
                    Iterator visitor = cache.iterator();
                    visitor.next();
                    visitor.remove();
                }
                cache.add(city);
                answer += 5;
            }
        }
    
        return answer;
    }
}