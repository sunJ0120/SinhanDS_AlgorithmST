package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine()); //총 루프 수
        List<Integer> list = new ArrayList<>(); //나와야 하는 비교수를 본다.

        for(int i = 0; i < cnt; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> st = new Stack<>(); //stack 제작

        int ind = 0; //index 설정
        int n = 0; //stack에 넣는 용도이다.

        //이렇게 잡아두고, no가 뜨거나 끝날 경우에 끝내면 된다.
        while(ind < cnt){
            int num = list.get(ind++);

            //NO 종료조건, stack에 있는게 더 클 경우,
            if(!st.isEmpty() && num < st.peek()){
                stb.setLength(0); // ⭐ 길이를 0으로 지정하면 리셋할 수 있다.
                stb.append("NO" + "\n");
                break;
            }else{
                while(n < num){
                    st.add(++n);
                    stb.append("+" + "\n");
                }
                if(st.peek() == num){
                    st.pop();
                    stb.append("-" + "\n");
                }
            }
        }
        System.out.println(stb); //stb 저장해 둔 것을 print 한다.
    }
}
