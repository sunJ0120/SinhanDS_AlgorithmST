package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
BOJ 1715. 카드 정렬하기 2차 시도)
- 있는 PriorityQueue 사용하는 방법을 익힘
- PriorityQueue 사용법 지피티 참고 했으므로 반드시 복습 필요..
 */
public class Main1715{

    public static int cardSort(PriorityQueue<Integer> pq){
        int ans = 0;
        //heapSize가 1이면 멈춰야 한다.
        while(pq.size() > 1){
            //가장 작은 두개를 더해서 insert 한다.
            int a = pq.poll();
            int b = pq.poll();
            ans += (a + b); //위에서 뺀다고 보장 되어 있는게 아니므로, 이렇게 진행
            pq.add(a + b);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<num; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(cardSort(pq));
    }
}
