package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
B1. 적어도 대부분의 배수

- 임의의 세 수를 뽑아서, 그 세 수의 최소공배수를 구하면 된다.
- 최소 공배수 구하는 방법
    - 최대 공약수를 유클리드 호제법으로 구한다.
    - 최소 공배수 구하는 공식을 이용한다.
 */
public class Main1145 {
    public static int lcm(int a, int b){
        return (a * b) / gcd(a,b);

    }

    //최대 공약수 - 유클리드 호제법을 이용한다.
    public static int gcd(int a, int b){
        while(b != 0){
            int num = b;
            b = a % b; //방향 주의! 유클리드 호제법상 이 방향이 맞음
            a = num;
        }

        return a;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> li = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            li.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i<li.size()-2; i++){
            for(int j = i+1; j<li.size()-1; j++){
                int lcm1 = lcm(li.get(i), li.get(j));
                for(int z = j+1; z<li.size(); z++){
                    int lcm2 = lcm(li.get(j), li.get(z));
                    ans = Math.min(ans, lcm(lcm1, lcm2));
                }
            }
        }
        System.out.println(ans);
    }
}
