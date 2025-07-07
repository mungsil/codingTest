import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> countMap = new HashMap<>();
        for(String p:participant){
            countMap.merge(p, 1, (old, newValue) -> old + newValue);
        }
        for(String c: completion){
            countMap.put(c, countMap.get(c) -1);
        }
        
        for(String s: countMap.keySet()){
            if(countMap.get(s) == 1){
                answer = s;
            }
        }
        return answer;
    }
}