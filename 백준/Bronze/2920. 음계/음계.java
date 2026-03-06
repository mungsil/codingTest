import java.util.Arrays;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    int[] arr = Arrays.stream(input.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int start = arr[0];

    if (start == 1) {
        for (int i = 1; i < 8; i++) {
            if (arr[i] != i + 1) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println("ascending");

    } else if (start == 8) {
        for (int i = 1; i < 8; i++) {
            if (arr[i] != 8 - i) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println("descending");

    } else {
        System.out.println("mixed");
    }
}
}
