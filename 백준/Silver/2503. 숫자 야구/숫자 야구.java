import java.io.*;
import java.util.*;

public class Main {

    private static int chances;
    private static int answer = 0;
    private static List<List<Integer>> gameResults = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chances = Integer.parseInt(br.readLine());

        for (int i = 0; i < chances; i++) {
            String[] inputs = br.readLine().split(" ");
            gameResults.add(List.of(
                    Integer.parseInt(inputs[0]),
                    Integer.parseInt(inputs[1]),
                    Integer.parseInt(inputs[2])
            ));
        }

        // 3자리 숫자만 탐색: 123 ~ 987 (0은 제외)
        for (int num = 123; num <= 987; num++) {
            String strNum = String.valueOf(num);
            if (hasZeroOrDuplicate(strNum)) continue; // 0 포함 또는 중복 숫자 제외
            if (isValid(num)) answer++;
        }

        System.out.println(answer);
    }

    // 0이 포함되거나 중복 숫자가 있는지 체크
    private static boolean hasZeroOrDuplicate(String s) {
        if (s.contains("0")) return true;
        return s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2);
    }

    // 현재 숫자가 모든 게임 결과와 일치하는지 체크
    private static boolean isValid(int expect) {
        String expectStr = String.valueOf(expect);

        for (List<Integer> result : gameResults) {
            int queryNum = result.get(0);
            int strike = result.get(1);
            int ball = result.get(2);

            String queryNumStr = String.format("%03d", queryNum);

            int s = 0, b = 0;
            boolean[] usedExpect = new boolean[3];
            boolean[] usedQuery = new boolean[3];

            // 스트라이크 체크
            for (int i = 0; i < 3; i++) {
                if (expectStr.charAt(i) == queryNumStr.charAt(i)) {
                    s++;
                    usedExpect[i] = true;
                    usedQuery[i] = true;
                }
            }

            // 볼 체크
            for (int i = 0; i < 3; i++) {
                if (usedExpect[i]) continue;
                for (int j = 0; j < 3; j++) {
                    if (usedQuery[j]) continue;
                    if (expectStr.charAt(i) == queryNumStr.charAt(j)) {
                        b++;
                        usedExpect[i] = true;
                        usedQuery[j] = true;
                        break;
                    }
                }
            }

            if (s != strike || b != ball) return false;
        }

        return true;
    }
}
