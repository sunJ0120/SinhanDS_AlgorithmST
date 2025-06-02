package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
10773. 제로
가장 나중에 부른 숫자를 0으로 지운다는 것에서 착안하여
스택을 이용해서 해결한다.
 */
public class Main10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        int cnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<cnt; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){ //0이라면 지워야 한다. 지울 수 있는게 보장되어 있으므로 empty 체크는 안해도 된다.
                stack.pop();
            }else{
                stack.add(n);
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}
