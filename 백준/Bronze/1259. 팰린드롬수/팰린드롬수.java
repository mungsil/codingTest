import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String word = br.readLine(); // 121
            
            if(word.equals("0")){
                return;
            }
            
            int len = word.length(); //3
        
            int leftP = 0;
            int rightP = len-1;//2
            
            boolean noFlag = false;
            while(leftP<=rightP){
                if(word.charAt(leftP) != word.charAt(rightP)){
                    System.out.println("no");
                    noFlag = true;
                    break;
                }
                leftP++;
                rightP--;
            }
            if(!noFlag){
                System.out.println("yes");
            }           
        }        
    }
}
