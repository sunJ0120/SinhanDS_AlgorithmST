package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        Integer.parseInt(br.readLine());

        List<Integer> li = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            li.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(li); //오름차순 정렬
        for(int i = 0; i<li.size(); i++){
            ans += (li.get(i) * (li.size() - i));
        }

        System.out.println(ans);
    }
}
