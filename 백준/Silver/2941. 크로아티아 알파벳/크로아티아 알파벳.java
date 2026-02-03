import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int answer = 0;
        int idx = 0;
        
        //System.out.println("word: " + word);
        while(true){
            if(idx >= word.length()){
                break;
            }
            char c = word.charAt(idx);
            //System.out.println("주어진 단어의 문자 c 검사, c = " + c);
            List<String> croaCandidates = getCroaByFirshChar(c);
            if(croaCandidates == null){
                //System.out.println("크로아 알파벳 후보 없음: " + c);
                idx++;
                answer++;
                //System.out.println("다음 인덱스: " + idx);
                continue;
            }
            // then 
            // -> get the croa alpha
            // -> compare both word is matching
            
            boolean found = false;
            for(String croa : croaCandidates){
                // croa 문자와 일치하는 알파벳이 있는지 확인
                boolean isSame = true;
                for(int i=1; i<croa.length(); i++){
                    if(word.length() <= i+idx){ 
                        isSame = false;
                        break; 
                    }
                    if(word.charAt(i+idx) != croa.charAt(i)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    answer++;
                    idx += croa.length();
                    found = true;
                    break;
                }
            }
            if(!found){
                answer++;
                idx++;
            }
        }
        System.out.print(answer);
    }
    private static List<String> getCroaByFirshChar(char first){
        if(first == 'c'){
            return List.of("c=", "c-");
        }
        if(first == 'd'){
            return List.of("dz=", "d-");
        }
        if(first == 'l'){
            return List.of("lj");
        }
        if(first == 'n'){
            return List.of("nj");
        }
        if(first == 's'){
            return List.of("s=");
        }
        if(first == 'z'){
            return List.of("z=");
        }
        
        return null;
    }
}
