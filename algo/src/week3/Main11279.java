package week3;

import java.io.*;

/**
 * [S2] Main11279_최대힙
 *
 * 우선순위 큐의 기본 개념인 힙에 대해 알아보자~
 */
public class Main11279 {
    static int[] heap;
    static int heapSize = 1;
    /*
    삭제 연산 순서
    1. node 값 저장
    2. 맨 밑 노드(tmp) 올려서
    3. child중 가장 큰 것과 비교
    4. tmp가 더 크면 자리 찾음 -> parent에 두기
    5. child가 더 크면 parent에 올리고 밑으로 내려가기
     */
    public static int deleteHeap(){
        //삭제할게 없음
        if(heapSize == 1){
            return 0;
        }
        int removed = heap[1];
        int tmpInd = heapSize-1; //맨 마지막 노드

        int parentInd = 1;
        int childInd = 2;

        while(childInd < heapSize){
            //왼쪽 오른쪽 child를 비교 , 현재 오른쪽이 있는지부터 먼저 체크한다.
            if(childInd+1 < heapSize && heap[childInd] < heap[childInd+1]){
                childInd++;
            }

            //자리를 찾앗을 경우
            //이 비교하는 것은 perentInd가 아니라 tmp랑 비교해야 한다!! 지금 얘가 root에 올라와 있는 셈이다.
            if(heap[tmpInd] > heap[childInd]){
                break;
            }
            //childInd가 더 클 경우
            heap[parentInd] = heap[childInd];
            parentInd = childInd;
            childInd = parentInd * 2; //한칸 내려가기
        }
        heap[parentInd] = heap[tmpInd];
        heapSize--;
        return removed;
    }

    /*
    삽입 연산 순서
    1. num 값을 끝에 넣는다.
    2. 부모 값과 비교한다
    3. 부모가 더 크면 끝낸다. -> 그 child 자리가 num의 자리이다.
    4. 부모가 더 작으면 부모를 자리로 내리고, 그 parent 자리로 올라간다.
    5. 그 다음에 다음 parent랑 child로 갱신하면 된다.
     */
    public static void insertHeap(int n){
        heap[heapSize] = n;

        int parentInd = heapSize/2;
        int childInd = heapSize++; //현재 tmp의 인덱스

        while(parentInd >= 1){
            if(heap[parentInd] >= heap[childInd]){
                break;
            }

            //child가 더 크다.
            int child = heap[childInd];
            heap[childInd] = heap[parentInd];
            heap[parentInd] = child;

            childInd = parentInd;
            parentInd = childInd/2; //올라가기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());
        heap = new int[100002];

        for(int i = 0; i<roop; i++){
            int n = Integer.parseInt(br.readLine());
            //0일 경우 삭제이다.
            if(n == 0){
                bw.write(deleteHeap() + "\n");
            }else{
                insertHeap(n);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
