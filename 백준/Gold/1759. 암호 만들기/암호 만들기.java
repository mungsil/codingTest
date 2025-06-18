import java.util.*;
import java.io.*;

public class Main {
    
    private static Set<Character> moeums = 
        new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')); 

    private static int[] visited;
    private static char[] letters;
    private static int keyLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        keyLength = Integer.parseInt(st.nextToken());
        int keyCandidateLength = Integer.parseInt(st.nextToken());
        visited = new int[keyCandidateLength];

        String[] input = br.readLine().split(" ");
        letters = new char[keyCandidateLength];
        for (int i = 0; i < keyCandidateLength; i++) {
            letters[i] = input[i].charAt(0);
        }

        Arrays.sort(letters);
        for (int i = 0; i <= letters.length - keyLength; i++) { 
            List<Character> keyLogs = new ArrayList<>();
            keyLogs.add(letters[i]);
            visit(i+1, keyLogs);
        }
    }
    
    private static void visit(int startIndex, List<Character> keyLogs){
        if(keyLogs.size() == keyLength){
            int moeumCount = 0;
            int jaeumCount = 0;
            
            for(char k: keyLogs){
                if(moeums.contains(k)){
                    moeumCount++;
                }else{
                    jaeumCount++;
                }
            }
            
            if (moeumCount >= 1 && jaeumCount >= 2) {
                StringBuilder sb = new StringBuilder();
                for (char k : keyLogs) sb.append(k);
                sb.append("\n");
                System.out.print(sb);
            }
            
            return;
        }
        
        for(int i=startIndex; i<letters.length; i++){
            List<Character> logs = new ArrayList<>(keyLogs);
            logs.add(letters[i]);
            visit(i+1, logs);
        }
    }
}
