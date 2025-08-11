package week7;

import java.io.*;
import java.util.*;

public class Main1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] nums = br.readLine().toCharArray();
        List<Integer> li = new ArrayList<>();

        for(char num : nums){
            li.add(num - '0'); //숫자로 변환
        }

        Collections.sort(li, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //내림차순
            }
        });

        for(int num : li){
            bw.write(num+"");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
