import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            // 0-8
            inputList.add(Integer.parseInt(scan.nextLine()));
        }
        
        int maxIndex = 0;
        int maxValue = 0;
        for(int i = 0; i < 9; i++){
            if(maxValue < inputList.get(i)){
                maxValue = inputList.get(i);
                maxIndex = i;
            }
        }
        
        System.out.println(maxValue);
        System.out.println(maxIndex+1);
    }
    
}