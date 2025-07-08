import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int selectableNum = nums.length/2;
        
        Set<Integer> ponketmoneSortSet = new HashSet<>();
        for(int n: nums){
            ponketmoneSortSet.add(n);
        }
        
        int maxSort = ponketmoneSortSet.size();
        if(maxSort >= selectableNum){
            return selectableNum;
        } else{
            return maxSort;
        }
    }
}