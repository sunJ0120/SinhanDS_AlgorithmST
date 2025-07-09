package week2;

import java.util.ArrayDeque;
import java.util.Queue;

/*
큐) 다리를 지나는 트럭
포인트는, 올라갈 수 없을 때는 큐에 0을 채우는 것이다.

진짜 예쁘게 풀었네...정말 맘에 든다.
 */
public class Solution_3 {
    public static void main(String[] args) {
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> que = new ArrayDeque<>();

        int cnt = 0; //큐에 올라간 누적 합
        cnt += truck_weights[0];
        que.add(truck_weights[0]);

        int ind = 1;
        while(cnt > 0){
            if(que.size() == bridge_length){
                cnt -= que.poll();
            }

            if (ind < truck_weights.length && truck_weights[ind] + cnt <= weight){
                //최대 하중보다 작거나 같으므로 올릴 수 있다.
                que.add(truck_weights[ind]);
                cnt += truck_weights[ind++];
            }else{
                //못올릴 경우 0을 올린다.
                que.add(0);
            }
            answer++;
        }
        return answer;
    }
}
