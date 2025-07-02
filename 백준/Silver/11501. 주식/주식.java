import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] tokens = br.readLine().split(" ");
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(tokens[i]);
            }
            
            long profit = 0;
            int maxValue = 0;
            for(int i = N-1; i>=0; i--){
                if(prices[i] > maxValue){ // 미래에 가격이 떨어진다면
                    maxValue = prices[i]; 
                } else{ // 가격이 올라가거나 같아진다면
                    profit += maxValue - prices[i]; 
                }
            }
            
            System.out.println(profit);
        }
    }
}