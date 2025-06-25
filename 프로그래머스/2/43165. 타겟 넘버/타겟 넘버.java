class Solution {
    private static int answer; 
    private static int N;
    private static int[] input;
    private static int targetNum;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        input = numbers;
        targetNum = target;
        
        visit(0, 0);
        return answer;
    }
    
    private void visit(int i, int sum){
        if(i == N){
            if(sum == targetNum){
                answer++;
            }
            return;
        }
        
        visit(i+1, sum + input[i]);
        visit(i+1, sum - input[i]);
    }
}