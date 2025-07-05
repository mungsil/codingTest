import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬 -> 접두어가 앞에 위치 -> 장난하나
        
        for(int i=0; i<phone_book.length-1; i++){
            String current = phone_book[i];
            String next = phone_book[i+1];
            
            if(next.startsWith(current)){
                return false;
            }
        }
        
        return true;
    }
}