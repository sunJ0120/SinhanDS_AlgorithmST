package week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9_1 {
    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();

        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int ind1 = 0;
        int ind2 = 0;

        while(ind1 < answers.length){
            if(answers[ind1] == one[ind2 % one.length]){
                ans1++;
            }

            if(answers[ind1] == two[ind2 % two.length]){
                ans2++;
            }

            if(answers[ind1] == three[ind2 % three.length]){
                ans3++;
            }

            ind1++; ind2++;
        }

        int maxAns = Math.max(ans1, Math.max(ans2, ans3));

        if(maxAns == ans1){
            ansList.add(1);
        }
        if(maxAns == ans2){
            ansList.add(2);
        }
        if(maxAns == ans3){
            ansList.add(3);
        }

        answer = ansList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
