package week5;

import java.util.PriorityQueue;

public class Solution5_1 {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;

        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위 큐에 더한다. 모든 음식이므로 최소힙이다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        // 최소 두 개여야 새로운 스코빌 계산이 가능하기 때문이다.
        while(pq.size() > 1){
            if(pq.peek() >= K){
                break;
            }
            pq.add(pq.poll() + (pq.poll() * 2)); //새로 계산한 스코빌 지수
            answer++;
        }
        //하나 남았는데 여전히 K보다 작으면 answer = -1
        if(pq.peek() < K){
            answer = -1;
        }
        return answer;
    }
}
