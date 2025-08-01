/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
*/

import java.util.*;

public class Main {
    static int N;
    static List<List<int[]>> graph = new ArrayList<>();
    static List<List<int[]>> reversedGraph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 마을 수
        int M = scan.nextInt(); // 도로 수
        int X = scan.nextInt(); // 파티 마을

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int time = scan.nextInt();
            graph.get(from).add(new int[]{to, time});
            reversedGraph.get(to).add(new int[]{from, time}); // 역방향 추가
        }

        int[] go = dijkstra(X, reversedGraph); // 각 마을 → X
        int[] back = dijkstra(X, graph);       // X → 각 마을

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, go[i] + back[i]);
        }

        System.out.println(maxTime);
    }

    private static int[] dijkstra(int start, List<List<int[]>> g) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currTime = current[0];
            int currNode = current[1];

            if (currTime > times[currNode]) continue;

            for (int[] next : g.get(currNode)) {
                int nextNode = next[0];
                int nextTime = next[1];

                if (currTime + nextTime < times[nextNode]) {
                    times[nextNode] = currTime + nextTime;
                    pq.add(new int[]{times[nextNode], nextNode});
                }
            }
        }

        return times;
    }
}
