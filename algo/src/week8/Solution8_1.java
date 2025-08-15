package week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution8_1 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array,commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> li = new ArrayList<>();

        for(int num : array){
            li.add(num);
        }

        for(int i = 0; i<answer.length; i++){
            List<Integer> sub = new ArrayList<>(li.subList(commands[i][0]-1,commands[i][1]));
            Collections.sort(sub);
            answer[i] = sub.get(commands[i][2]-1);
        }
        return answer;
    }
}
