import java.util.*;
import java.io.*;
/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
출력: 단지 개수, 각 단지에 속한 집의 개수
*/

public class Main{
    
    private static int N;
    private static int[][] map;
    private static int[][] visited;
    private static int[][] upDownLeftRight ={{1,0}, {-1,0}, {0,-1}, {0,1}};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        List<Integer> complex = new ArrayList<>();
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(map[y][x] == 1 && visited[y][x] == 0){
                    complex.add(visit(y,x));                   
                }
            }
        }
        
        Collections.sort(complex);
        System.out.println(complex.size());
        for(int houseNum : complex){
            System.out.println(houseNum);
        }
    }
    
    private static int visit(int y, int x){
        visited[y][x] = 1;
        int houseNum = 1;
        
        for(int[] next: upDownLeftRight){
            int dy = next[0];
            int dx = next[1];
            int ny = y+dy;
            int nx = x+dx;
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(map[ny][nx] == 1 && visited[ny][nx] == 0){
                    houseNum += visit(ny, nx);
                }
            }
        }
        
        return houseNum;
    }
    
}