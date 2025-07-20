package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [G5] Main11000_강의실 배정하기
 *
 * 시작 순서대로 정렬한 다음에, 마치 Priority Queue를 대기열처럼 사용한다는게 포인트인 문제이다.
 *
 * comments
 * - 솔직히 우선순위큐를 어디에 써야할지 도무지 감이 안잡혀서
 * - 정렬부터 우선순위큐 기준까지 싹 도움을 받았다.
 * - 이건 내가 푼게 아니기 때문에..우선순위큐의 활용 방식에 대한 도움을 받았으니 반드시 복습이 필요하다.
 */
public class Main11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());

        int[][] list = new int[roop][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st;
        for(int i = 0; i<roop; i++){
            st = new StringTokenizer(br.readLine());
            int[] li = new int[2];
            for(int j = 0; j<2; j++){
                li[j] = Integer.parseInt(st.nextToken());
            }
            list[i] = li;
        }

        //첫번째 기준으로 정렬
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //첫번째 원소를 기준으로 오름차순 정렬한다.
                //오름차순 정렬을 위해서는 정방향이 맞다. 그래야 작은게 앞에 온다.
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i<roop; i++){
            if(pq.isEmpty()){
                pq.add(list[i][1]);
            }else{
                //현재 대기큐에 올라가 있는 것의 종료 시간보다 시작 시간이 더 늦거나 같게 있어야 한다.
                if(pq.peek() <= list[i][0]){
                    pq.poll(); //빼고
                    pq.add(list[i][1]); //올린다.
                }else{
                    pq.add(list[i][1]); //그냥 올린다.
                }
            }
        }

        //현재 que에 들어가 있는 것이 정답이다.
        System.out.println(pq.size());
    }
}
