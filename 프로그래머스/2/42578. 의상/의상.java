import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesCountMap = new HashMap<>();
        for(String[] c: clothes){
            String name = c[0];
            String sort = c[1];
            
            clothesCountMap.merge(
                sort,
                1,
                (oldValue, newValue) -> oldValue+newValue
            );
        }
        
        int answer = 1;
        for(int counts: clothesCountMap.values()){
            answer *= counts + 1;
        }
        
        return answer-1;
    }
}