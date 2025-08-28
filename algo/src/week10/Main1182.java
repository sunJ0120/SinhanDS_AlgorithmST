package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {
    static long ans;
    static long num;

    public static void comb(int[] li, int s, int start){
        for(int i = start; i<li.length; i++){
            num += li[i];

            //"더한" 수열 이므로, 공집합을 제거해야 한다. 그래서 이걸 이미 num에 수를 더한 다음으로 자리를 옮긴다.
            if(s == num){
                ans++;
                // 결국, 여기서 return을 빼는 것이 포인트이다.
            }

            comb(li, s, i+1);
            num -= li[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ans = 0;
        num = 0;

        int[] li = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            li[i] = Integer.parseInt(st.nextToken());
        }

        comb(li, s, 0);
        System.out.println(ans);
    }
}
