package week5;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [G5] 7662. 이중우선순위큐
 * 큐를 두 개 만드는게 포인트인 것 같다.
 *
 * 어차피 최소 최대를 뽑는 것이므로, 그냥 큐 두개 두고 root에서 뽑으면 된다.
 */
public class Main7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        //roop == 2
        for(int i = 0; i<roop; i++){
            //roop안에 돌아갈 num
            int num = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pqMin = new PriorityQueue<>(); //최소힙 (기본이 오름차순이다.)
            //이거 최대힙으로 내림차순 하기 위해서는 Comparator.reverseOrder() 하는 것이 중요하다.
            PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder()); //최대힙

            for(int j = 0; j<num; j++) {
                //두개씩 끊으니까 StringTokenizer st 선언~!
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    String command = st.nextToken();
                    int number = Integer.parseInt(st.nextToken());

                    if (command.equals("I")) {
                        //I일 경우, 둘 다 더한다. 그래야 최소 최대 결정이 가능하다.
                        pqMin.add(number);
                        pqMax.add(number);
                    } else { //command.equals("D") 삭제 연산
                        if(pqMin.isEmpty() || pqMax.isEmpty()){
                            bw.write("EMPTY" + "\n");
                            break;
                        }
                        if (number == -1) {
                            //최솟값을 삭제한다.
                            int min = pqMin.poll();
                            pqMax.remove(min); //같이 삭제한다 -> 시간초과 발생
                        } else {
                            //D 1 최댓값을 삭제한다.
                            int max = pqMax.poll();
                            pqMin.remove(max);
                        }
                    }
                }
            }
            //이거 좀 안깔끔한데..어케 해야 하징 고민중....
            if(!pqMin.isEmpty() || !pqMax.isEmpty()){
                //둘 다 empty가 아닌 경우, max랑 min을 둘 다 내보낸다.
                bw.write(pqMax.poll() + " " + pqMin.poll() + "\n");
            }
        }
        bw.flush(); //쌓인걸 내보낸다.
        bw.close();
        br.close();
    }
}
