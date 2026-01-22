import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boundaris = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = boundaris[0]; // 1 <= i <= j <= n
        int m = boundaris[1]; 
        int[] arr = new int[n+1];
        for(int z=0; z<m; z++){
            int[] ijk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int i = ijk[0];
            int j = ijk[1];
            int k = ijk[2];
            for(int p = i; p < j+1; p++){
                arr[p] = k;
            }
        }
        
        for(int z=1; z<n+1; z++){
            System.out.print(arr[z]+" ");
        }
    }
}
