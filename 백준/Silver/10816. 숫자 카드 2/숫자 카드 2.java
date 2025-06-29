import java.util.*;
import java.io.*;

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
*/
public class Main{
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine();// 크기 사용 x
        String ownChars = br.readLine();
        int[] ownNums = Arrays.stream(ownChars.split(" "))
                      .mapToInt(Integer::parseInt)
                      .toArray();
        
        br.readLine(); // 크기 사용 x
        String toFindChars = br.readLine();
        int[] toFindNums = Arrays.stream(toFindChars.split(" "))
                      .mapToInt(Integer::parseInt)
                      .toArray();
        
        // map에 담기
        Map<Integer, Integer> numberCounting = new HashMap<>();
        for(int o : ownNums){
            numberCounting.merge(o, 1, (oldValue, newValue) -> oldValue+newValue);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int t : toFindNums){
            sb.append(numberCounting.getOrDefault(t, 0));
            sb.append(" ");
        }
        System.out.print(sb);
    }
    
}