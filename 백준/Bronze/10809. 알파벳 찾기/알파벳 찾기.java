import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine(); 
        
        // 2: 배열
        // for i in word length
        int len = word.length();
        int num = 'z'-'a'+1;
        int[] arr = new int[num];
        for(int i=0; i<num; i++){ // 초기화
            arr[i] = -1;
        }
        
        for(int i=0; i<len; i++){//i=위치
            int idx = word.charAt(i)-'a'; // 알파벳 -> 숫자 변환
            if(arr[idx] == -1){
                arr[idx] = i; // arr[알파벳] = 위치;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}
