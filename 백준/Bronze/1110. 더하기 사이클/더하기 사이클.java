import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==0){
            System.out.print(1);
            return;
        }
        String target = String.valueOf(n);
        if (target.length() == 1) {
            target = "0" + target;
        }

        String given = target;
        int answer = 0;
        while(true) {
            answer++;
            if (given.length() == 1) {
                given = "0" + given;
            }
            char[] chars = given.toCharArray(); // [2,6]

            int sum = 0;
            for(char c : chars){
                int i= c-'0';
                sum += i; // 2+6=8
            }

            int rightOfNew= sum%10;
            char rightOfInput= chars[1];

            String newStr = rightOfInput+""+rightOfNew;
            if(newStr.equals(target)){
                break;
            }else{
                given = newStr;
            }
        }

        System.out.print(answer);
    }

}