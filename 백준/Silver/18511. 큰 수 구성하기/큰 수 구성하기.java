import java.util.*;

/*
657 3
1 5 7
*/

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k_num = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<k_num; i++){
            int temp = sc.nextInt();
            set.add(temp);
        }
        
        // n = 657, set = {1,5,7}
        int max = 0;
        for(int i=N; i>0; i--){
            char[] chars= String.valueOf(i).toCharArray();
            boolean isFind = true;
            for(char c : chars){
                if(!set.contains(c-'0')){
                    isFind = false;
                    break;
                }
            }
            if(isFind){
                max = i;
                break;                
            }

        }
        System.out.print(max);
        
    }
    
}