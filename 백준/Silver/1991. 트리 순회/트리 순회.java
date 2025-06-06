import java.util.*;
import java.io.*;
/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
*/
public class Main{
    
    private static Map<Character, char[]> graph = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        
        for(int i=0; i<nodeNum; i++){
            String[] input = br.readLine().split(" ");
            graph.put(input[0].charAt(0), new char[]{input[1].charAt(0), input[2].charAt(0)});
        }
        
        recur1('A');
        System.out.println();
        recur2('A');
        System.out.println();
        recur3('A');
    }
    
    private static void recur1(Character node){
        if(node == '.'){
            return;
        }
        
        char[] child = graph.get(node);
        System.out.print(node);
        recur1(child[0]);
        recur1(child[1]);
    }
    
     private static void recur2(Character node){
        if(node == '.'){
            return;
        }
        
        char[] child = graph.get(node);
        
        recur2(child[0]);
        System.out.print(node);
        recur2(child[1]);
    }
    
     private static void recur3(Character node){
        if(node == '.'){
            return;
        }
        
        char[] child = graph.get(node);
        
        recur3(child[0]);
        recur3(child[1]);
        System.out.print(node);
    }
    
}