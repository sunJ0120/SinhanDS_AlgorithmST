package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] li = new int[num];

        for(int i = 0; i<li.length; i++){
            li[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬....
        Arrays.sort(li);

        System.out.println(li[k-1]);
    }
}
