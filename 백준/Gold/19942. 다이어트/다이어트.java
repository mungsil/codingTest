import java.util.*;
/*
입력:
6
100 70 90 10
30 55 10 8 100
60 10 10 2 70
10 80 50 0 50
40 30 30 8 60
60 10 70 2 120
20 70 50 4 4

출력:
134
2 4 6
*/

public class Main{
    private static int ingreNum;
    private static int price=Integer.MAX_VALUE;
    private static int[] toEat = new int[4];
    private static int[][] array;
    private static Deque<Integer> buffer = new ArrayDeque<>();
    private static List<Integer> answerBuffer;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ingreNum = scan.nextInt(); // 6
        for(int i=0;i<4;i++){
            toEat[i] = scan.nextInt(); // 100 70 90 10
        }
        
        array = new int[ingreNum][5];
        for(int i=0; i<ingreNum; i++){
            array[i][0] = scan.nextInt();
            array[i][1] = scan.nextInt();
            array[i][2] = scan.nextInt();
            array[i][3] = scan.nextInt();
            array[i][4] = scan.nextInt();
        }
        
        recur(0,0,0,0,0,0);
        if(price == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        } 
        
        System.out.println(price);
        for(int i: answerBuffer){
            System.out.print(i+ " ");
        }
    }
    
    private static void recur(int step, int a, int b, int c, int d, int currentPrice){
        if(step == ingreNum){
            if(a >= toEat[0] && b >= toEat[1] && c >= toEat[2] && d >= toEat[3]){
                if (currentPrice < price) {
                    price = currentPrice;
                    answerBuffer = new ArrayList<>(buffer);
                } else if (currentPrice == price) {
                    if (isBetter(buffer)) {
                        answerBuffer = new ArrayList<>(buffer);
                    }
                }
             }
            return;
        }
        buffer.offerLast(step+1);
        recur(step + 1, a+array[step][0], b+array[step][1], c+array[step][2], d+array[step][3], currentPrice + array[step][4]);
        buffer.pollLast();
        recur(step + 1, a, b, c, d, currentPrice);
        
    }
    
    private static boolean isBetter(Deque<Integer> buffer) {
    List<Integer> current = new ArrayList<>(buffer);
    int minSize = Math.min(current.size(), answerBuffer.size());
    for (int i = 0; i < minSize; i++) {
        if (!current.get(i).equals(answerBuffer.get(i))) {
            return current.get(i) < answerBuffer.get(i);
        }
    }
    return current.size() < answerBuffer.size();
    }
    
}