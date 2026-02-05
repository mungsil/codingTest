import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int[] whitePiece = {1,1,2,2,2,8};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++){
            int input = Integer.parseInt(st.nextToken());
            int dx = whitePiece[i]-input; 
            sb.append(dx).append(" ");
        }
        System.out.print(sb);
    }
}
