import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int hap = Integer.parseInt(br.readLine());

        int[] inputs = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        Main main = new Main();
        main.fun(n,inputs,hap);
    }

    public void fun(int n, int[] inputs, int hap) {
        int[] arr = new int[1000001];
        int answer = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (hap - inputs[i] > 1000000 | hap-inputs[i]<=0) {
                continue;
            }
            if (arr[hap-inputs[i]] == 1) {
                answer++;
            }else {
                arr[inputs[i]] = 1;
            }
        }

        System.out.println(answer);

    }

}