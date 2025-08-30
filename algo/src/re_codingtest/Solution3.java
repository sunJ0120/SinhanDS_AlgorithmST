package re_codingtest;

/*
문제3

문제 자체는 장황하지만 정리하자면, 그냥 세로로 쌓아서 중복 없애는 문제이다.
set 이중으로 잡아서,

1. 첫번째 set 사이즈로 가로 길이
2. 두 번째 set 안에 남은 알파벳 수의 합으로 전체 수를 구하면 된다.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        String str1 = "bananakick";
        int n1 = 2;

        System.out.println(Arrays.toString(Solution(str1, n1)));
    }

    public static int[] Solution(String str, int n){
        int[] answer = new int[2];
        Set<Set<Character>> set = new HashSet<>();

        for(int i = 0; i<n; i++){ //start점 구하기
            Set<Character> innerSet = new HashSet<>();
            for(int j = i; j<str.length(); j+=n){
                innerSet.add(str.charAt(j));
            }
            set.add(innerSet);
        }

        answer[0] = set.size();

        //내부 알파벳 수 더하기
        for(Set<Character> inner : set){
            answer[1] += inner.size();
        }

        return answer;
    }
}
