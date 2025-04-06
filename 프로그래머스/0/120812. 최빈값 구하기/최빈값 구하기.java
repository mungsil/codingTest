class Solution {
    public int solution(int[] array) {
        int[] records = new int[1000];
        
        for(int a : array){
            records[a] += 1;
        }
    
        
        int answer = Integer.MIN_VALUE;  // 1
        int maxNum = Integer.MIN_VALUE;  // 2
        int dupliacated = 0;
    
        // i=0 ~ 99
        for(int i =0;i< records.length; i++){
            if(records[i] > maxNum){ // t
                maxNum = records[i];
                answer = i; 
                dupliacated = 0;
                continue;
            }
            if(records[i] == maxNum){
                dupliacated += 1;
            }
        }
        
        // System.out.println(answer);
        // System.out.println(dupliacated);
        
        if(dupliacated > 0){
            return -1;
        }
        
        // System.out.print(answer);
        
        return answer;
    }
}