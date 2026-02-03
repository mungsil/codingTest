import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int answer = 0;
        int idx = 0;

        while(true){
            if(idx >= word.length()){
                break;
            }
            char c = word.charAt(idx);
            List<String> croaCandidates = getCroaByFirshChar(c);
            if(croaCandidates == null){
                idx++;
                answer++;
                continue;
            }
            
            boolean found = false;
            for(String croa : croaCandidates){
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
