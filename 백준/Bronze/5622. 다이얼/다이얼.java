import java.util.*;

public class Main {
    public static void main(String[] args) {
        // WA
        // 1. 문자에 해당하는 숫자 찾기
        // 2. 시간 추가
        // w(9): 10 , 1-2. a(2): 3(2+1)
        // to(time) = to-1(time)+1
        Scanner scan = new Scanner(System.in);
        
        // 풀이
        int answer = 0;
        String alphabets = scan.nextLine();
        for(int i=0; i<alphabets.length(); i++){
            char a = alphabets.charAt(i);
            int num = a-'A';
            if(num <= 2){ // 숫자 2, A~C
                answer += 3;
            } else if(num <= 5){ // 숫자 3, D~F
                answer += 4;
            } else if(num <= 8){ // 숫자 4, G~I
                answer += 5;
            } else if(num <= 11){ // 숫자 5
                answer += 6;
            } else if(num <= 14){ // 숫자 6
                answer += 7;
            } else if(num <= 18){ // 숫자 7
                answer += 8;
            } else if(num <= 21){ // 숫자 8
                answer += 9;
            } else if(num <= 25){ // 숫자 9
                answer += 10;
            } else { // 숫자 0
                answer += 11;
            }
        }
        
        System.out.print(answer);
    }
}
