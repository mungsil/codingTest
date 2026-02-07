import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            String input = br.readLine();
            char first = input.charAt(0);
            char last = input.charAt(input.length()-1);
            sb.append(first).append(last).append("\n");
        }
        System.out.println(sb);
    }
}
