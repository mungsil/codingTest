import java.util.*;
/*
4 => n
2 => k
1
2
12
1
*/
public class Main {
    
    static int N;
    static int K;
    static String[] cards;
    static int[] selectedIndex;
    static Deque<String> selected = new ArrayDeque<>();
    static Set<String> answer = new HashSet();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cards = new String[N];
        selectedIndex = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = String.valueOf(sc.nextInt());
        }
        select(0);
        System.out.print(answer.size());
    }
    
    private static void select(int count){
        if (count == K) {
            StringBuilder sb = new StringBuilder();
            for (String s : selected) {
                sb.append(s);
            }
            answer.add(sb.toString());
            return;
        }
        
        for(int i=0; i<N; i++){
            if(selectedIndex[i] == 1){
                continue;
            }

            selected.addLast(cards[i]);
            selectedIndex[i] = 1;
            select(count + 1);
            selected.removeLast();
            selectedIndex[i] = 0;
        }
    }
    
}