class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();
        int lp = 0; // 중복되지 않은 문자열의 시작
        int rp = 0; // 중복되지 않은 문자열의 끝
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); // i = 방문할 문자
            if(map.containsKey(c) && map.get(c) >= lp){
                lp = map.get(c)+1;
            } else{
                answer = Math.max(answer, rp-lp+1);
            }

            rp++;
            map.put(c, i);
        }

        return answer;
    }
}
