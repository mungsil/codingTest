import java.util.*;

public class Main{
    private static int workableDay;
    private static int[][] days;
    private static int[] dp;
    private static int maxPrice =Integer.MIN_VALUE;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        workableDay = scan.nextInt();
        
        dp = new int[workableDay+1];
        days = new int[20][2];
        for(int i = 0; i<workableDay; i++){
            days[i][0] = scan.nextInt();
            days[i][1] = scan.nextInt();
        }
        
    for (int i = workableDay - 1; i >= 0; i--) {
        // recur(step == workableDay)일 때 return 0과 같은 역할
        // 반복문은 자동으로 i == workableDay일 때 종료되므로 별도 처리 없이 자연스럽게 해결됨

        if (i + days[i][0] > workableDay) {
            // 현재 날짜에 상담을 시작하면 퇴사일(workableDay)을 초과 → 상담 불가
            dp[i] = dp[i + 1]; // 상담을 하지 않음 → 다음 날부터 얻을 수 있는 최대 수익을 그대로 가져옴
        } else {
            // 상담을 하는 경우 vs 안 하는 경우 중 최대 수익 선택
            dp[i] = Math.max(dp[i + days[i][0]] + days[i][1], dp[i + 1]);
        }
    }

        
        System.out.print(dp[0]);
    }
    
}