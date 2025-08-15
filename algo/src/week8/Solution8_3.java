package week8;

import java.util.Arrays;

/*
H-index

- 맘에 안든다 내 풀이ㅠ
 */
public class Solution8_3 {
    public static void main(String[] args) {
        int[] citations = {0,0,0,0,0,1,1,1,1,1};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int ind = 0;

        Arrays.sort(citations);

        while(answer <= citations.length-ind){
            //max이면, 더 이상 늘릴 수가 없으므로 return
            if(answer == citations[citations.length-1]){
                return answer;
            }
            if(citations[ind] <= answer){
                ind++;
            }
            //같은게 있을땐 answer를 늘리면 안된다.
            if(citations[ind] > answer){
                answer++;
            }
        }
        return answer-1;
    }
}
