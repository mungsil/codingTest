import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n == -1){
                break;
            }
            
            List<Integer> list = new ArrayList<>();
            int components = 1;
            for(int i=2; i*i<=n; i++){
                if(n%i == 0){
                    components += i;
                    components += (n/i);
                    list.add(i);
                    list.add((n/i));
                }
            }
            
            StringBuilder sb = new StringBuilder();
            if(components == n){
                Collections.sort(list);
                sb.append(n).append(" = ").append("1");
                for(int o : list ){
                    sb.append(" + ").append(o);
                }
            } else{
                sb.append(n).append(" is NOT perfect.");
            }
            System.out.println(sb);
        }
    }
}
