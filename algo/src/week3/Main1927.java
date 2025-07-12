package week3;

import java.io.*;

/**
 * Main1927_최소힙
 *
 * 우선순위 큐의 기본 개념인 힙에 대해 알아보자~
 */

public class Main1927 {
    public static int[] heap;
    public static int heapSize = 1;

    /*
    삭제 연산 순서
    1. node 값 저장
    2. 맨 밑 노드(tmp) 올려서
    3. child중 가장 작은 것과 비교
    4. tmp가 작으면 자리 찾음
    5. child가 더 작으면 parent에 올리고 밑으로 내려가기
     */
    public static int deleteHeap(){
        //삭제할 노드가 없다.
        if(heapSize == 1){
            return 0;
        }
        int parentInd = 1;
        int childInd = 2;

        int removed = heap[parentInd];
        int tmpInd = heapSize-1;

        while(childInd < heapSize){
            //1. 가장 작은 child 구하기, 오른쪽이 존재하고, 오른쪽이 더 작을 경우
            if(childInd + 1 < heapSize && heap[childInd] > heap[childInd+1]){
                childInd++;
            }

            //tmp가 더 작은지 보기, 더 작으면 자리 찾은 것이다.
            if(heap[childInd] > heap[tmpInd]){
                break;
            }

            //child가 더 작다. 아래로 이동한다.
            heap[parentInd] = heap[childInd];
            parentInd = childInd;
            childInd = parentInd * 2;
        }

        //tmp 자리 잡기
        heap[parentInd] = heap[tmpInd];
        heapSize--;
        return removed;
    }

    /*
    삽입 연산 순서
    1. num 값을 끝에 넣는다.
    2. 부모 값과 비교한다
    3. 부모가 더 작으면 끝낸다. -> 그 child 자리가 num의 자리이다.
    4. 부모가 더 크면 부모를 자리로 내리고, 그 parent 자리로 올라간다.
    5. 그 다음에 다음 parent랑 child로 갱신하면 된다.
     */
    public static void insertHeap(int num){
        heap[heapSize] = num;
        int parentInd = heapSize/2;
        int childInd = heapSize;

        while(parentInd >= 1){
            if(heap[parentInd] < heap[childInd]){
                break;
            }

            //부모가 더 크다. swap
            int tmp = heap[childInd];
            heap[childInd] = heap[parentInd];
            heap[parentInd] = tmp;

            childInd = parentInd;
            parentInd = childInd/2; //거슬러 올라가기
        }
        heap[childInd] = num; //위치에 저장
        heapSize++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        heap = new int[100002]; //최대로 잡아두기

        heap[0] = 0; //0은 안쓰는 값이기 때문에, 초기값을 넣는다.

        for(int i = 0; i< roop; i++){
            int num = Integer.parseInt(br.readLine());
            //0이면 삭제 연산
            if(num == 0){
                bw.write( deleteHeap() + "\n");
            }else{
                insertHeap(num);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
