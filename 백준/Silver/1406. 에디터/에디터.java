import java.io.*;
import java.util.*;

//길이가 L인 문자열: 0~L까지 총 L+1 경우 커서가 위치 가능함

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> linkedList = new LinkedList<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            linkedList.add(s.charAt(i));
        }

        ListIterator<Character> li = linkedList.listIterator();

        while (li.hasNext()) {
            li.next(); 
        }


        int count = Integer.parseInt(br.readLine());

        while (count > 0) {
            char[] chars = br.readLine().toCharArray();
            if(chars[0]=='P'){
                li.add(chars[2]);
            } else if (chars[0] == 'L') {
                if (li.hasPrevious()) {
                    li.previous();
                }
            } else if (chars[0]=='D') {
                if (li.hasNext()) {
                    li.next();
                }
            }else if (chars[0]=='B') { 
                if (li.hasPrevious()) {
                    li.previous();
                    li.remove();
                }
            }
            count--;
        }
        for (Character c : linkedList) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }

}