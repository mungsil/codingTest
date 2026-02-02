import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 개수 N (홀수)
        int N = Integer.parseInt(br.readLine());        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());   
            list.add(num);
            sum += num; // for 산술 평균
            map.merge(num, 1, (o1, o2) -> o1+1); // for 최빈값
            max = Math.max(max, map.get(num)); // for 최빈값 
        }
        // 산술 평균
        long answer1 = 0;
        
        if(sum < 0){
            sum = Math.abs(sum);
            answer1 = -Math.round(sum / N);
        } else{
            answer1 = Math.round(sum / N);
        }
        
        // 중앙값
        Collections.sort(list);
        int middleIdx = list.size() / 2;
        int answer2 = list.get(middleIdx);
        // 범위
        int smallest = list.get(0);
        int largest = list.get(N-1);
        int answer4 = largest-smallest;
        
        // 최빈값
        // == 등장 횟수가 가장 큰 값
        // 가지고 있는 것: 숫자 key - 등장횟수 value
        // 1. for -> find max 등장 횟수
        // 2. for -> get num which have max 등장횟수 value
        List<Integer> maxNums = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                maxNums.add(entry.getKey());
            }
        }
        int answer3 = 0;
        if(maxNums.size() == 1){
            answer3 = maxNums.get(0);
        } else{
            Collections.sort(maxNums);
            answer3 = maxNums.get(1);
        }
        
        // 출력
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
}
}
