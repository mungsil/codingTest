import java.io.*;
import java.util.*;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        char[] ch1 = first.toCharArray();
        char[] ch2 = second.toCharArray();
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        if(String.valueOf(ch1).equals(String.valueOf(ch2)))
            return true;
        return false;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
