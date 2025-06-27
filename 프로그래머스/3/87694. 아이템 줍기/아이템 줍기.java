import java.util.*;

class Solution {
    
    private static int[][] upDownLeftRight = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        
    public int solution(
        int[][] rectangle,
        int characterX,
        int characterY,
        int itemX,
        int itemY
    ) {
        int[][] map = new int[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1; 
                }
            }
        }

        
        for (int[] rect : rectangle) {
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        Deque<Dot> queue = new ArrayDeque<>();
        int[][] visited = new int[102][102];
        int distance = 0;
        
        queue.offer(new Dot(characterX*2, characterY*2,0));
        visited[characterX*2][characterY*2] = 1;
        
        itemX = itemX*2;
        itemY = itemY*2;
        int answer = 0;
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            
            int visitX = dot.getX();
            int visitY = dot.getY();
            int currDistance = dot.getDistance();
            if(visitX == itemX && visitY == itemY){
                answer = currDistance;
                
                break;
            }
            visited[visitX][visitY] = 1;
            
            for(int[] next : upDownLeftRight){
                int nextX = visitX + next[0];
                int nextY = visitY + next[1];
                if(nextX >= 2 && nextX <= 102 
                   && nextY >= 2 && nextY <= 102){
                    if(map[nextX][nextY] == 1){
                        if(visited[nextX][nextY] == 0){
                            queue.offer(new Dot(nextX, nextY, currDistance+1));
                            visited[nextX][nextY] = 1;
                        }
                    }
                }
            }
        }
        
        
        return answer / 2;
    }
    
    private class Dot{
        int x;
        int y;
        int distance;
        Dot(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getDistance(){
            return distance;
        }
    }
    
}