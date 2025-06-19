import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    
    private static char[][] map;
    private static int[][] upDownLeftRight = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private static int[][] visited;
    private static int maxMoveCount = 0;
    private static int rowNum;
    private static int colNum;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        rowNum = scan.nextInt();
        colNum = scan.nextInt();
       
        map = new char[rowNum][colNum];
        for(int i = 0; i < rowNum; i++){
            String s = scan.next();
            for(int j = 0; j < colNum; j++){
                map[i][j] = s.charAt(j);
            }
        }
        
        visited = new int[rowNum][colNum];
       
        // 출발 ~! ^v^
        Set<Character> paths = new HashSet<>();
        visit(0, 0, paths);
        System.out.print(maxMoveCount);   
    }
    
    private static void visit(int y, int x, Set<Character> paths){
        visited[y][x] = 1;
        paths.add(map[y][x]);
        maxMoveCount = Math.max(maxMoveCount, paths.size());
        
        for(int[] next : upDownLeftRight){
            int ny = y + next[0];
            int nx = x + next[1];
            if(ny >= 0 && ny < rowNum && nx >= 0 && nx < colNum){
                if(visited[ny][nx] == 0 && !paths.contains(map[ny][nx])){
                    visit(ny, nx, paths);
                }
            }
        }
        
        visited[y][x] = 0; 
        paths.remove(map[y][x]); 
    }
}
