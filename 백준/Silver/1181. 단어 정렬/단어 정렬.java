import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Comparator<String> orderByGiven = (a,b) -> {
            int frontLen = a.length();
            int backLen = b.length();
            if (frontLen < backLen){
                return -1;
            }
            if (frontLen == backLen){
                return a.compareTo(b);
            }
            if (frontLen > backLen){
                return 1;
            }

            return 0;
        };
        
        Set<String> wordBook = new TreeSet<>(orderByGiven);
        for(int i=0; i<N; i++){
            String line = br.readLine();
            wordBook.add(line);
        }
        
        for (String ordered: wordBook) {
            System.out.println(ordered);
        }
    }
}
