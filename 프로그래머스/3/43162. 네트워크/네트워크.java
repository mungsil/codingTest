class Solution {
    public int solution(int n, int[][] computers) {
        // 변수 선언
        int network = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visit(i, computers, visited);
                network++;
            }
        }
        
        return network;
    }
    
    private void visit(int n, int[][] computers, boolean[] visited){
        visited[n] = true;
        for(int x=0; x<computers.length; x++){
            if(computers[n][x] == 1 && !visited[x]){
                visit(x, computers, visited);
            }            
        }
    }
}