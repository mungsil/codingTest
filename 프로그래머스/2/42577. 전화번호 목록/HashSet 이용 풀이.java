import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {  
        Set<String> set = new HashSet<>(List.of(phone_book)); // prefix 확인용
        
        for (String phoneNum : phone_book) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < phoneNum.length() - 1; i++) {
                sb.append(phoneNum.charAt(i));
                if (set.contains(sb.toString())) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
