import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String quizeResults = br.readLine();
            int len = quizeResults.length();
            int[] dp = new int[len+1];
            
            for(int j=0; j<len; j++){
                // check the result is o or x
                char result = quizeResults.charAt(j);
                if(result == 'O'){
                    dp[j+1] = dp[j] + 1; 
                }
            }
            
            int hap = 0;
            for(int k=1; k<len+1; k++){
                hap+= dp[k];
            }
            
            System.out.println(hap);
        }
    }
}
