import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesCountMap = new HashMap<>();
        for(String[] c: clothes){
            String sort = c[0];
            String name = c[1];
            
            clothesCountMap.merge(
                name,
                1,
                (oldValue, newValue) -> oldValue+newValue
            );
        }
        
        int answer = 1;
        for(String key: clothesCountMap.keySet()){
            int count = clothesCountMap.get(key) + 1;
            answer *= count;
        }
        
        return answer-1;
    }
}