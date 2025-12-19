import java.util.*;

public class Main{
    
    // 1 3 -1 4 1 7
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" "); 
        int[] numbers = Arrays.stream(input) 
            .mapToInt(Integer::parseInt)
            .toArray();
        
        for(int x = -999; x < 1000; x++){
            for(int y = -999; y < 1000; y++){
                if(numbers[0]*x + numbers[1]*y == numbers[2] &&
                      numbers[3]*x + numbers[4]*y == numbers[5]){
                    System.out.print(x + " " + y);
                }
            }
        }
        
        return;
    }
    
}