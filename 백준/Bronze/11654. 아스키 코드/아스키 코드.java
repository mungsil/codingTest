import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String given = scan.next(); // 알파벳 소문자, 대문자, 숫자 0-9 중 하나
        System.out.print((int) given.charAt(0));
    }
}
