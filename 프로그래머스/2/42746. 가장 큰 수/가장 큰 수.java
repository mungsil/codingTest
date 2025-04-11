import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // convert int array to String array
        // why using array, not list? => doubling of ArrayList
        String[] components = Arrays.stream(numbers) // make a int stream from the int[]. How about Collections? List.stream(), Set.stream() 
                            .mapToObj(num -> String.valueOf(num)) // primitive type => reference type ! remember a 'ToObj'
                            .toArray(size->new String[size]);
        
        // custom compare
        Arrays.sort(components, (c1, c2) -> (c2+c1).compareTo(c1+c2));
        
        // edge case - all inputs are 0
        if(components[0].equals("0")){return "0";}
        
        return String.join("", components);    
    }
}