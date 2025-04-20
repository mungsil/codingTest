## 직관적 풀이 - 실패
```
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<temperatures.length-1; i++){ // i< 7(8-1), max i=6
            int current = temperatures[i];
            for(int j = i+1; j<temperatures.length; j++){// max j = 7, j<8
                if(current<temperatures[j]){
                    answer.add(j-i);
                    break;
                }
            }
        }

        // add for last element
        answer.add(0); 

        return answer.stream().mapToInt(i->i).toArray();
    }
```
### 이유
[73,74,75,71,69,72,76,73] 에서의 76처럼 warmer day를 찾지 못하는 경우 answer.add()를 생략
  

## 1차 해결
정답 도출을 위해 array를 써야겠다고 생각함. (not list)
1. 기본값 0으로 초기화
2. warmer day가 있으면 값을 써주기

☑️ answer.add()를 생략해도 정답 도출 가능

```
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for(int i=0; i<temperatures.length-1; i++){ // i< 7(8-1), max i=6
            int current = temperatures[i];
            for(int j = i+1; j<temperatures.length; j++){// max j = 7, j<8
                if(current<temperatures[j]){
                    answer[i] = j-i;
                    break;
                }
            }
        }

        return answer;
    }
}
```

### 1차 해결 실패
시간 복잡도 때문에 실패했다! 더 효율적인 풀이를 찾아보자.

## 최종 해결
```
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                answer[stack.peek()] = i-stack.pop();
            }
            
            stack.push(i);
        }

        return answer;
    }
}
```




