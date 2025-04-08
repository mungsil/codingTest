// 아 코딩하고 싶다
import java.util.*;

class Solution {
    class StockState{
        int price;
        int decreaseTiming;
        
        StockState(int price){
            this.price = price;
            this.decreaseTiming = 0;
        }
        
        public void delayDecreaseTiming(){
            decreaseTiming++;
        }
    } 
    
    public int[] solution(int[] prices) {
        
        Deque<StockState> beforeStack = new ArrayDeque<>();
        Deque<StockState> afterStack = new ArrayDeque<>();
        
        for(int price:prices){
            beforeStack.push(new StockState(price));
        }
        
        while(!beforeStack.isEmpty()){
            StockState current = beforeStack.pop(); 
            
            for(StockState future: afterStack){       
                if(future.price >= current.price){
                    current.delayDecreaseTiming();
                } else{
                    current.delayDecreaseTiming();
                    break;
                }
            }
            afterStack.push(current);
        }
        
        int[] answer = new int[prices.length];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = afterStack.pop().decreaseTiming;
        }
        return answer;
    }
    
}