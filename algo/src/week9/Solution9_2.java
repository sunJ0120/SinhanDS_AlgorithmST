package week9;

import java.util.Arrays;

public class Solution9_2 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //yellow 조합 찾기
        for(int i = 1; i<= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                int a = i;
                int b = yellow/a;

                if(a*2 + b*2 + 4 == brown){
                    answer[0] = b+2; //가로
                    answer[1] = a+2; //세로
                }
            }
        }
        return answer;
    }
}
