import java.util.*;
import java.io.*;

/*
4 11
cAda
AbrAcadAbRa 
*/
public class Main{
    
    private static int[] frequencyMarker = new int[60];
    private static Map<Integer, Integer> wordMap = new HashMap<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gNum = Integer.parseInt(st.nextToken());
        int textLength = Integer.parseInt(st.nextToken());
        char[] word = br.readLine().toCharArray();
        char[] text = br.readLine().toCharArray();
        
        // 출현해야하는 문자(g) 빈도 계산
        for(char g: word){
            int index = g-'A';
            wordMap.merge(index, 1, (oldV, newV) -> oldV + newV);
        }
        
        // gNum 길이만큼 문자 빈도 카운팅
        for(int i=0; i<gNum; i++){
            frequencyMarker[text[i]-'A'] += 1;
        }
        
        int answer = 0;
        // 요구 빈도 수를 만족시키는지 확인
        if(isSameFrequency()){
            answer++;
        }

        // for문을 이용해서 슬라이딩 윈도우
        for(int i=0; i<textLength-gNum; i++){
            frequencyMarker[text[i]-'A'] -= 1;
            frequencyMarker[text[i+gNum]-'A'] += 1;
            if(isSameFrequency()){
                answer++;
            }
        }
        System.out.print(answer);
    }
    
    private static boolean isSameFrequency(){
        for (Map.Entry<Integer, Integer> ent : wordMap.entrySet()) {
            if(frequencyMarker[ent.getKey()] != ent.getValue()){
                return false;
            }
        }
        return true;
    }
   

    
}