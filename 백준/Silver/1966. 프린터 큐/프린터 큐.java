import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // TestCase Num
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0){
            // first line of the TC
            int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int totalDocsNum = condition[0];
            int targetOrder= condition[1]; // 원하는 문서의 현재 순서
            
            // second line of the TC, 전체 문서의 중요도.
            // ex. [1,1,9,1,1]
            int[] docs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
            
            
            // 문서 개수가 하나인 경우 특별 처리
            if(totalDocsNum==1){
                System.out.println("1");
                continue;
            }
            
            // 출력 후보 문서들의 순서를 담는 리스트
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<totalDocsNum; i++){
                list.add(i);
            }
            
            // 풀이 시작
            int printOrder=0;
            
            // 원하는 문서가 출력될 때까지 진행
            while(true){
                if(list.size() == 1){
                    System.out.println(++printOrder);
                    break;
                }
                
                int idx = list.get(0);
                int value = docs[idx];
                
                boolean iamBest = true;
                for(int i=1; i<list.size(); i++){
                    int nIdx = list.get(i);
                    int nValue = docs[nIdx];
                    if(nValue > value){
                        list.remove(0);
                        list.add(idx);
                        iamBest = false;
                        break;
                    }
                }
                if(iamBest){ // print
                    list.remove(0);
                    printOrder+=1;
                    if(idx==targetOrder){
                        System.out.println(printOrder);
                        break;
                    }
                }              
            }
        }
    }
}
