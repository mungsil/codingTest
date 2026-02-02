import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int len = word.length();
        // 왼쪽 포인터와 오른쪽 포인터가 가르키는 값이 같아야함
        // until left P <= right p
        int leftP = 0;
        int rightP = len-1;

        while(leftP<=rightP){
            if(word.charAt(leftP) != word.charAt(rightP)){
                System.out.print("0");
                return;
            }
            leftP++;
            rightP--;
        }
        System.out.print("1");
    }
}
