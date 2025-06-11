package week2;

import java.util.Arrays;
import java.util.Stack;

public class Solution_1 {
    public static void main(String[] args) {

        int[] ansList = {9,1,5,3,6,2};

        System.out.println(Arrays.toString(solution(ansList)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; //같은 length로 만들어줘야 인덱스에 값을 넣을 수 있다.
        Stack<Integer> st = new Stack<>(); //인덱스 번호를 올리는 스택이다.

        for(int i = 0; i<numbers.length; i++){
            if(st.isEmpty()){
                st.push(i); //비어 있을 경우 바로 올린다.
            }else{
                //오른쪽에 큰 수가 있는 것이다.
                while(!st.isEmpty() && numbers[st.peek()] < numbers[i]){ //st.peek()은 인덱스이므로... numbers[st.peek()]로 넣어줘야 함을 유의하자.
                    answer[st.pop()] = numbers[i];
                }
                //작을 경우, 마지막에는 인덱스 push 한다.
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            answer[st.pop()] = -1;
        }
        return answer;
    }
}
