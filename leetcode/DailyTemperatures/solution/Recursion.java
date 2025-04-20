// 재귀 + 스택 활용
// 시간 초과

class Recursion {
    public class Point{
        int index;
        int value;

        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int x_axis_value = temperatures[0];

        Queue<Point> temperature_graph = new ArrayDeque<>();
        for(int i=0; i<temperatures.length; i++){
            int diff_value = temperatures[i] - x_axis_value;
            temperature_graph.add(new Point(i, diff_value));
        }

        Deque<Integer> outputStack = findWarmerDay(temperature_graph);

        List<Integer> answer = new ArrayList<>();
        for(int warmerDayIndex: outputStack){
            answer.add(warmerDayIndex);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public Deque<Integer> findWarmerDay(Queue<Point> temperature_graph){
        Deque<Integer> output = new ArrayDeque<Integer>();
        pushWarmerDayIndex(temperature_graph, output);

        return output;
    }

    public void pushWarmerDayIndex(Queue<Point> temperature_graph, Deque<Integer> output){
        if(temperature_graph.isEmpty()){
            return;
        }

        Point current = temperature_graph.poll(); 
        pushWarmerDayIndex(new ArrayDeque<>(temperature_graph), output);

        int day = 0;
        for(Point right: temperature_graph){
            if(current.value < right.value){
                day = right.index - current.index;
                break;
            }
        }

        output.push(day);
    }


}
