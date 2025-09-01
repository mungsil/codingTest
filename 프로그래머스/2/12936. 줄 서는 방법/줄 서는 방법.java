import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> people = new ArrayList<>();
        long[] fact = new long[n+1];
        
        fact[0] = 1;
        for(int i=1; i<n+1; i++){
            fact[i] = i*fact[i-1];
            people.add(i);
        }
        
        k--;
        
        for(int i=0; i<n; i++){
            long blockSize = fact[n-1-i];
            int index = (int) (k/blockSize);
            answer[i] = people.remove(index);
            k %= blockSize;
        }
        
        return answer;
    }

}
