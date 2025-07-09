package week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_4 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        //오름차순 정렬
        Arrays.sort(scoville);
        //큐에 넣기
        for(int n : scoville){
            deq.add(n);
        }

        while(!deq.isEmpty()){
            if(deq.peekFirst() >= K){
                break; //아...그러면 결국 첫번째 원소가 크기만 하면 다 큰거잖아!!!!
            }else{
                //두개를 꺼낼 수 없는 상황, 즉 모든 음식을 K 이상 스코빌로 만들 수 없음.
                if(deq.size() == 1){
                    answer = -1;
                    break;
                }
                int num = deq.pollFirst() + (deq.pollFirst()) * 2;
                answer++; //계산 추가
                deq.addFirst(num);
            }
        }

        return answer;
    }
}
