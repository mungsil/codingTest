import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] inputs = Arrays.stream(citations)
                            .boxed()
                            .toArray(Integer[]::new);
        
        // 내림차순 정렬
        Arrays.sort(inputs, Collections.reverseOrder());
        
        int h_index = 0;
        for(int i=0;i<inputs.length;i++){
            
            if(inputs[i] > inputs.length){
                h_index++;
                continue;
            } 
        
            if((h_index + 1)>inputs[i]){ 
                break;
            } 
            
            h_index++;
        }
        
    
        return h_index;
    }
}

