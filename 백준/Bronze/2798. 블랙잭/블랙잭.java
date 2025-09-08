import java.util.Scanner;

public class Main {
    
    private static int N;
    private static int M;
    private static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 줄 입력
        N = sc.nextInt(); // 10
        M = sc.nextInt(); // 500

        // 둘째 줄 입력 (N개의 정수)
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print(recur(0,0,0));
    }
    
    private static int recur(int selectedNum, int hap, int index){
        if(selectedNum == 3){
            if(hap > M) return 0;
            return hap;
        }
        
        if(index > N-1){
            return 0;
        }
        
        return Math.max(
            recur(selectedNum+1, hap+arr[index], index+1),
            recur(selectedNum, hap, index+1)
        );
    }
}
