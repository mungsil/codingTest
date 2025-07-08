import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer;
        int selectableNum = nums.length/2;
        
        Set<Integer> ponketmoneSortSet = new HashSet<>();
        for(int n: nums){
            ponketmoneSortSet.add(n);
        }
        int maxSort = ponketmoneSortSet.size();
        
        if(maxSort >= selectableNum){
            answer = selectableNum;
        } else{
            answer = maxSort;
        }
        
        return answer;
    }
}