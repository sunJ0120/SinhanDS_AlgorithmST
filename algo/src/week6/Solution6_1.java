package week6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Level3_디스크 컨트롤러
 */
public class Solution6_1 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;

        //1차는 첫번째 시작 시간만 오름차순으로 정렬한다.
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //queue 안에는 배열을 담고, 정렬 기준은 오른쪽 수로 잡는다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 0; //배열의 length와 비교하기 위함이다.
        int idx = 0; //jobs 배열을 이동하기 위함
        int curr = 0; //현재 시각 (누적 시각)

        while(count < jobs.length){
            //1. 현재 시간 보다 시작 시간이 작거나 같은 것들을 전부 대기열에 올린다.
            while(idx < jobs.length && jobs[idx][0] <= curr){
                pq.add(jobs[idx++]);
            }
            //2. 큐 안에 처리할 수 있는 작업이 있다.
            if(!pq.isEmpty()){
                int[] num = pq.poll();
                curr += num[1]; //현재 시각 계산
                answer += curr - num[0]; //누적에서 시작 시간을 뺀다.
                count++; //하나 뺐으므로 count++
            }else{
                //3. 큐 안에 처리할 수 있는 작업이 없는 경우, 다음 작업으로
                curr = jobs[idx][0];
            }
        }
        return answer/n;
    }
}
