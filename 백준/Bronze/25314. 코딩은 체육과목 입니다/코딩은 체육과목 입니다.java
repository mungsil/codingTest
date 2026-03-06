import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // long int = 4byte
        // long long int = 8byte
        // (long) X n + int = (4) X n + 0
        int bSize =scan.nextInt();
        int n = bSize/4;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.print(sb);
    }
}
