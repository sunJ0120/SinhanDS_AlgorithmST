package week1;

import java.util.Stack;

public class Solution_1 {
    public static void main(String[] args) {
        //이거 모든 입력을 한번에 체크하려면...
        String[] stList = {"()()","(())()",")()(","(()(","(()))"};
        for(String st : stList){
            System.out.println(solution(st));
        }
    }
    public static boolean solution(String s) {
        boolean answer = true;

        char[] par = s.toCharArray();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(char c : par){
            left.push(c);
        }

        while(!left.isEmpty()){
            if(left.peek() == ')'){ //right의 괄호가 들어가 있음
                right.push(left.pop());
            }else{ //(일 경우
                if(left.peek() == '(' && !right.isEmpty() && right.peek() == ')'){ //짝이 맞음
                    left.pop();
                    right.pop();
                }else{ //짝이 안맞음
                    answer = false;
                    break;
                }
            }
        }

        //오른쪽이 남을 경우, 이것도 false로 써야한다.
        if(!right.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
