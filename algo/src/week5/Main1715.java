package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * [G4] 1715. 카드 정렬하기
 *
 * PriorityQueue를 이용해서 해결한다
 * 최소힙을 사용한다.
 * root의 두 개를 더해서 ans에 누적하고, 다시 큐에 올린다.
 * PriorityQueue의 크기가 하나일때까지 계속한다.
 */
public class Main1715 {
    public static int swapCard(PriorityQueue<Integer> pq){
        int ans = 0; //전체 섞은 카드 뭉치
        while(pq.size() > 1){
            int swappedCard = pq.poll() + pq.poll(); //두 카드뭉치를 섞은 것
            ans += swappedCard;
            pq.add(swappedCard);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roop = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<roop; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(swapCard(pq));
    }
}
