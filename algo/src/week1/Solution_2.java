package week1;

import java.util.*;

public class Solution_2 {
    public static void main(String[] args) {
        String[] ex = {"[](){}", "}]()[{","[)(]", "}}}", "{(})", "{(}"};

        for(int i = 0; i<ex.length; i++){
            System.out.println(solution(ex[i]));
        }
    }
    public static int solution(String s) {
        int answer = 0;
        char[] chs = s.toCharArray();
        List<Character> chList = new ArrayList<>();

        for(char chh : chs){
            chList.add(chh);
        }

        //루프를 길이만큼 진행한다.
        for(int i = 0; i<chList.size(); i++){
            if(CheckPare(chList)){ //괄호에 해당할 경우
                answer++;
            }
            //왼쪽으로 회전시키기
            char first = chList.get(0);
            chList.remove(0);
            chList.add(first); //뒤로 이동
        }
        return answer;
    }

    public static boolean CheckPare(List<Character> chList){
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(Character c : chList){
            leftStack.push(c); //우선 leftStack에 다 올린다.
        }

        while(!leftStack.isEmpty()){
            if(leftStack.peek() == '}' || leftStack.peek() == ')' || leftStack.peek() == ']'){
                rightStack.push(leftStack.pop());
            }else{
                if(rightStack.isEmpty()){ //left에 괄호가 있는데 empty이므로
                    return false;
                }else{
                    if(leftStack.peek() == '{' && rightStack.peek() == '}'){
                        leftStack.pop();
                        rightStack.pop();
                    }else if(leftStack.peek() == '(' && rightStack.peek() == ')'){
                        leftStack.pop();
                        rightStack.pop();
                    }else if(leftStack.peek() == '[' && rightStack.peek() == ']'){
                        leftStack.pop();
                        rightStack.pop();
                    }else{ //짝이 안 맞는다.
                        return false;
                    }
                }
            }
        }

        if(rightStack.isEmpty()){
            return true;
        }else{ //rightStack에 남아있음
            return false;
        }
    }
}
