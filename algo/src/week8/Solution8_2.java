package week8;

import java.util.*;

public class Solution8_2 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        //이 부분 문법 주의!!!
        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}
