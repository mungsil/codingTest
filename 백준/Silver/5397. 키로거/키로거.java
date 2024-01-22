import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String[] st = new String[num];
       
        for (int i = 0; i < num; i++) {
            st[i] = br.readLine();
        }

        String[] temp=new String[num];
        while (num-- > 0) {

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> li = list.listIterator();


            for (int i = 0; i < st[num].length(); i++) {
                char c = st[num].charAt(i);

                if (c == '<') {
                    if (li.hasPrevious()) { 
                         li.previous();
                    }
                } else if (c == '>') {
                    if (li.hasNext()) {
                        li.next();
                    }
                } else if (c == '-') {
                    if (li.hasPrevious()) {
                        li.previous();                   
                        li.remove();
                    }
                } else {
                     li.add(c);
                    }
                 }
            StringBuilder result = new StringBuilder();
            for (Character ch : list) {
                result.append(ch);
            }
            temp[num] = String.valueOf(result);
        }

        for (String s : temp) {
            bw.write(s + "\n");
        }


        bw.flush();
        bw.close();
    }
}