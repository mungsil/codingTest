import java.io.*;

public class Main {

    static int A, B, C, M;
    static int work = 0; // 하루 동안 일한 총량
    static int fatigue = 0; // 현재 피로도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");

        A = Integer.parseInt(parts[0]); // 일하면 증가하는 피로도
        B = Integer.parseInt(parts[1]); // 일하면 얻는 일량
        C = Integer.parseInt(parts[2]); // 쉬면 감소하는 피로도
        M = Integer.parseInt(parts[3]); // 번아웃 기준 피로도

        for (int hour = 0; hour < 24; hour++) {
            if (fatigue + A > M) {
                rest();
            } else {
                work();
            }
        }

        System.out.println(work);
    }

    static void rest() {
        fatigue -= C;
        if (fatigue < 0) fatigue = 0;
    }

    static void work() {
        fatigue += A;
        work += B;
    }
}