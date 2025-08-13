import java.util.*;

public class Main{
    
    private static int[] minHeap;
    private static int num;
    private static int size = 0;
    private static int root = 1;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        minHeap = new int[num+1];
        for(int i=0; i<num; i++){
            int value = sc.nextInt();
            if(value == 0){
                int minV = minHeap[root];
                sb.append(minV).append("\n");                
                if(size > 0){
                    removeRoot();
                }
            } else{
                add(value);
            }
        }          
        System.out.print(sb);
    }
    
    private static void add(int value){
        size++;
        minHeap[size] = value;
        int parent = size / 2;
        int child = size;
        while(minHeap[child] < minHeap[parent] && parent != 0){ 
            swapValue(parent, child);
            child = parent;
            parent = child / 2; 
        }
    }
    
    private static void removeRoot(){
        swapValue(root, size);
        minHeap[size] = 0;
        size--;
        
        int parent = root;
        while(true){
            int left = parent*2;
            int right = parent*2 + 1;
            int smallest = parent;
            if(left <= size && minHeap[left] < minHeap[smallest]){
                smallest = left;
            }
            if(right <= size && minHeap[right] < minHeap[smallest]){
                smallest = right;
            }
        
            if(smallest != parent){
                swapValue(smallest, parent);
                parent = smallest;
            } else{
                break;
            }
        }

    }
    
    private static void swapValue(int idxA, int idxB){ 
        int tempValue = minHeap[idxA];
        minHeap[idxA] = minHeap[idxB];
        minHeap[idxB] = tempValue;
    }
    
}
