package week1;

import java.util.Arrays;
import java.util.Stack;

public class Solution_3 {
    public static void main(String[] args) {
        int[] ex = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(ex)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; //0인 배열로 초기화
        boolean[] booList = new boolean[prices.length];
        Arrays.fill(booList,true); //전부 true로 초기화 한다.

        Stack<Integer> indexStack = new Stack<>();
        for(int i = prices.length-1 ; i>=0; i--){
            indexStack.push(i); //인덱스를 올려서 비교한다.
        }

        while(!indexStack.isEmpty()){
            int ind = indexStack.pop(); //다음에 계산해야할 인덱스

            if(!indexStack.isEmpty()){
                if(prices[ind] <= prices[indexStack.peek()]){
                    for(int i = 0; i<=ind; i++){ //하나씩 누적한다.
                        if(booList[i]){ //true인 애들만(끊기지 않은 애들)늘려야 한다.
                            answer[i]++;
                        }
                    }
                }else{ //전에 있는게 더 크다.
                    answer[ind] = 1;
                    for(int i = ind; i>=0; i--){ //하나씩 누적한다.
                        if(prices[i] > prices[indexStack.peek()]){
                            booList[i] = false;
                        }else{ //작거나 같으면 아직 이어지는 것이므로,
                            answer[i]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
