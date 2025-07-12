import java.util.*;
/*
장르별로 가장 많이 재생된 노래를 각각 두 개씩 모두 만드는 베스트 앨범
모든 노래 재생 횟수 장르(내림차순) -> 재생횟수 in 노래(내림차순) -> 고유번호 in 노래(오름차순) 
classic 1450[[0, 500], [2, 150], [3,800]]
pop 3100[[1, 600], [4, 2500]]

장르별 합
0번째 장르 -> +500, 1번째 장르 -> +600 ... 장르별 총합 내림차순 정렬
foreach 장르 in 장르들:

*/

class Solution {
    class PlayList{ // 장르별 속한 노래 리스트
        int sum =0;

        Queue<int[]> uniqueAndPlaysPairQueue;
            
        
        PlayList(){
            uniqueAndPlaysPairQueue = new PriorityQueue<>((a,b) -> {
                    if(b[1]!=a[1]) return b[1] - a[1];
                    return a[0]-b[0];
                });
        }
        
        public void add(int id, int plays){
            uniqueAndPlaysPairQueue.add(new int[]{id, plays});
            sum += plays;
        }
        
        public int getSum(){
            return sum;
        }
        
        public void showTopTwo(List<Integer> logs){
            int[] pair1 = uniqueAndPlaysPairQueue.poll();
            logs.add(pair1[0]);
            
            if(uniqueAndPlaysPairQueue.isEmpty()){
                return;
            }
            
            int[] pair2 = uniqueAndPlaysPairQueue.poll();
            logs.add(pair2[0]);  
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 플레이리스트를 하나씩만 유지하기 위해 사용
        Map<String, PlayList> playListPerGenre = new HashMap<>();
        
        int nums = genres.length;
        for(int i=0; i<nums; i++){
            // 새로운 장르 -> playsPerGenre에 추가 필요     
            playListPerGenre.computeIfAbsent(genres[i], k -> new PlayList())
                .add(i, plays[i]);
        }
        
        // 장르별 재생 횟수가 높은 순대로 정렬하기 위해 사용
        Queue<PlayList> playListSortedBySum = 
            new PriorityQueue<>((a,b) -> b.getSum()-a.getSum());
        
        for(PlayList p: playListPerGenre.values()){
            playListSortedBySum.add(p);
        }
        
        List<Integer> answers = new ArrayList<>();
        while(!playListSortedBySum.isEmpty()){
            PlayList p = playListSortedBySum.poll();
            p.showTopTwo(answers);
        }
        
        return answers.stream().mapToInt(i -> i).toArray();
    }
}

