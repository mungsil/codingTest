import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Map<Character, List<Integer>> map = new HashMap<>();
            int len = word.length();
            
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                map.computeIfAbsent(c, k -> new ArrayList<>()).add(j);
            }

            boolean isGroupWord = true;
            for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                for (int k = 1; k < list.size(); k++) {
                    if (list.get(k) != (list.get(k - 1) + 1)) {
                        isGroupWord = false;
                        break;
                    }
                }
                if (!isGroupWord) break;
            }

            if (isGroupWord) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}