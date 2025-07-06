import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read size of array A and B
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        // read array A
        st = new StringTokenizer(br.readLine());
        int[] arrayA = new int[sizeA];
        for (int i = 0; i < sizeA; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        // read array B
        st = new StringTokenizer(br.readLine());
        int[] arrayB = new int[sizeB];
        for (int i = 0; i < sizeB; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        // merge
        List<Integer> sortedList = new ArrayList<>();
        int ap = 0, bp = 0;
        while (ap < sizeA && bp < sizeB) {
            if (arrayA[ap] < arrayB[bp]) {
                sortedList.add(arrayA[ap++]);
            } else {
                sortedList.add(arrayB[bp++]);
            }
        }

        // add remaining elements
        while (ap < sizeA) {
            sortedList.add(arrayA[ap++]);
        }
        while (bp < sizeB) {
            sortedList.add(arrayB[bp++]);
        }

        StringBuilder sb = new StringBuilder();
        // print result
        for (int num : sortedList) {
            sb.append(num);
            sb.append(" ");
        }
        System.out.print(sb);
    }
}
