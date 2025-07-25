package week5;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
            //TreeMap을 선언
            TreeMap<Integer, Integer> treeQueue = new TreeMap<>();
            StringTokenizer st;

            for(int j = 0; j<num; j++){
                st = new StringTokenizer(br.readLine());
                String comm = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                //I일 경우, 더한다.
                if(comm.equals("I")){
                    //treeQueue.containsKey일 경우에 하나 올린다.
                    //없을 경우 초기값 1을 배정
                    treeQueue.put(n, treeQueue.containsKey(n) ? treeQueue.get(n)+1 : 1);
                }else{ //comm.equals("D")일 경우, 삭제한다.

                    //근데 아무리 그래도 삭제인데 empty이면 이렇게 남겨두는게 맞지 않나...
                    if(treeQueue.isEmpty()){
                        continue;
                    }

                    int key;
                    //비지 않고 삭제할 것이 있는 경우,
                    if(n == -1){ //최솟값을 하나 줄인다.
                        key = treeQueue.firstKey(); //최솟값을 하나 꺼낸다.
                    }else{ //n == 1 일 경우 최댓값을 하나 줄인다.
                        key = treeQueue.lastKey(); //최댓값을 하나 꺼낸다.
                    }

                    int cnt = treeQueue.get(key);
                    treeQueue.remove(key);
                    //cnt가 1개 이상일 경우, 갯수를 하나 줄이고 다시 넣어야 한다.
                    if(cnt > 1){
                        treeQueue.put(key, cnt-1);
                    }
                }
            }

            if(treeQueue.isEmpty()){
                bw.write("EMPTY" + "\n");
            }else{ //EMPTY가 아닐 경우에만 bw.write로 내보낸다.
                bw.write( treeQueue.lastKey() + " " + treeQueue.firstKey()+ "\n");
            }
        }
        bw.flush(); //쌓인걸 내보낸다.
        bw.close();
        br.close();
    }
}
