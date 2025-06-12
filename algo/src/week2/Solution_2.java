package week2;

import java.util.*;

public class Solution_2 {
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerArray = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque();

        //que 처리
        for(int i = 0; i<progresses.length; i++){
            int num = (100 - progresses[i]) / speeds[i];
            if(((100 - progresses[i]) % speeds[i]) > 0){ //나누어 떨어지지 않는다면
                num += 1;
            }
            que.add(num);
        }

        //que가 비어있지 않을 때까지
        while (!que.isEmpty()){
            int n = que.poll();
            int cnt = 1;
            //꺼낸 수가 더 클때만 이를 반복한다.
            while(!que.isEmpty() && que.peek() <= n){
                que.poll(); //꺼내기
                cnt++;
            }
            answerArray.add(cnt); //구한 cnt를 넣어준다.
        }

        //이거 int[] -> arrays로 변경하는거 잘 알아두기
        int[] answer = answerArray.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
