package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [G5] 11000. 강의실 배정
 *
 * Q. 시작으로 정렬하는건 알겠는데, 끝 부분을 어떻게 PQ로 풀어내는지 모르겠어서 아이디어 도움을 받았다...
 * A. 아!!! PQ의 경우, 가장 끝나는 시간이 빠른 것이 ROOT인게 보장되어 있기 때문에 (최소힙) 그냥 PQ 이용하면 된다.
 */

public class Main11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] li = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            li[i][0] = Integer.parseInt(st.nextToken());
            li[i][1] = Integer.parseInt(st.nextToken());
        }

        //1. 시작 기준 오름차순 정렬
        Arrays.sort(li, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; //앞자릿수 기준으로 오름차순 정렬한다.
            }
        });

        //2. PriorityQueue로 정렬
        for(int i = 0; i<n; i++){
            if(!pq.isEmpty() && pq.peek() <= li[i][0]){
                pq.poll();
            }
            pq.add(li[i][1]);
        }

        //3. size가 현재 진행중인 방 갯수를 말한다.
        System.out.println(pq.size());
    }
}
