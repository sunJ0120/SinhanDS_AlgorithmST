package week6;

import java.util.HashMap;

/*
level 1. 폰켓몬
- nums : 폰켓몬의 수와 종류

HashMap을 사용해서, size를 구해서 n/2와 비교하면 된다.
사전과 비슷한 느낌이므로 hash를 사용하면 해결이 가능하다.
 */
public class Solution6_3 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> ponketmons = new HashMap<>();

        for(int num : nums){
            //가지고 있으면 수량을 하나 늘린다.
            if(ponketmons.containsKey(num)){
                ponketmons.replace(num, ponketmons.get(num), ponketmons.get(num)+1);
            }else{
                ponketmons.put(num,1);
            }
        }
        // n/2개를 최대 고를 수 있으므로,
        if(ponketmons.size() >= nums.length/2){
            answer = nums.length/2;
        }else{
            answer = ponketmons.size();
        }

        return answer;
    }
}
