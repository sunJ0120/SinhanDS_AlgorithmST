package week3;

import java.io.*;

/**
 * [S1] Main11286_절댓값힙
 *
 * 우선순위 큐에서 우선순위를 정하는 방법을 알아보자.
 */

public class Main11286 {
    static int[] heap;
    static int heapSize = 1;

    /*
    삭제 연산
    1. root node의 값을 removed로 저장한다.
    2. 맨 끝에 있는걸 가져온다.
    3. 자식 노드 중에서 절댓값이 가장 작은
     - 같을 경우 값이 작은 것을 가져온다.
    4. 비교해서 맨 끝에 있는 값이 작으면 끝내고
    5. 작지 않으면 그걸 부모로 두고, 내려간다.
    6. 내 자리는 parents의 자리가 된다.
     */
    public static int deleteHeap(){
        //삭제할 것이 없다.
        if(heapSize <= 1){
            return 0;
        }
        int removed = heap[1]; //root node를 빼온다.
        int tmp = heap[heapSize-1]; //맨 끝에 있는 것이다.
        heap[1] = tmp; //root에 올린다.

        int parentInd = 1;
        int childInd = 2;

        heapSize--; //이렇게 나중에 자리 찾아서 바꿔주는 방식이 아닐 경우, 여깃 size를 줄여줘야 겹치지 않는다.
        while(childInd < heapSize){
            //오른쪽이 있을때,
            if(heap[childInd+1] != 0){
                if(Math.abs(heap[childInd+1]) < Math.abs(heap[childInd])) {
                    childInd++; //절댓값이 작거나
                }else if((Math.abs(heap[childInd+1]) == Math.abs(heap[childInd])) && (heap[childInd+1] < heap[childInd])){
                    childInd++; //같을 경우 값이 더 작을때만
                }
            }

            //제대로 자리가 맞춰진 경우.
            if((Math.abs(heap[parentInd]) < Math.abs(heap[childInd])) ||
                    ((Math.abs(heap[parentInd]) == Math.abs(heap[childInd])) && (heap[parentInd] < heap[childInd]))){
                break;
            }else{
                int child = heap[childInd];
                heap[childInd] = heap[parentInd];
                heap[parentInd] = child;

                //내려가기
                parentInd = childInd;
                childInd = parentInd * 2;
            }
        }
        return removed;
    }

    /*
    삽입 연산
    1. 끝자리에 넣는다.
    2. 부모 노드에 있는 것과
        - 더 작은지
        - 같으면 수가 작은지 비교한다.
    3. 비교해서 내가 더 작으면 올린다.
    4. 비교해서 부모가 더 작으면 끝낸다.
    5. 내 자리는 child의 자리가 된다.
     */
    public static void insertHeap(int n){
        heap[heapSize] = n; //끝자리에 넣는다.
        int parentInd = heapSize/2;
        int childInd = heapSize++;

        while(parentInd >= 1){
            if(Math.abs(heap[parentInd]) < Math.abs(heap[childInd])){
                break;
            }

            //절댓값이 같으면 진짜 수로 비교
            if(Math.abs(heap[parentInd]) == Math.abs(heap[childInd])){
                if(heap[parentInd] < heap[childInd]){
                    break;
                }
            }

            //swap
            int tmp = heap[childInd];
            heap[childInd] = heap[parentInd];
            heap[parentInd] = tmp;

            //위로 올라가기
            childInd = parentInd;
            parentInd = childInd/2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());
        heap = new int[100002];

        for(int i = 0; i<roop; i++){
            int n = Integer.parseInt(br.readLine());
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
