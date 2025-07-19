package week4;

import java.io.*;

/**
 * [S1] Main11286_절댓값 힙
 *
 * 우선순위의 기준이 절댓값이 작은 값 or 같을 경우 원래 값이 작은 값의 힙을 구현하는 문제이다.
 */
public class Main11286 {
    static int heapSize = 0; //heapSize를 index와 동일하다고 봐야 한다.
    static int[] heap;

    //절댓값의 경우, 크기 대소를 비교하는 과정이 너무 복잡해서 새로 method를 하나 더 빼기로 했다.
    //me가 바꾸는 대상에 해당하는 것이다.
    public static boolean isCompareStop(int parents, int child){
        if(Math.abs(parents) < Math.abs(child)){
            return true;
        }else if((Math.abs(parents) == Math.abs(child)) && (parents < child)){
            return true;
        }else{ //parents가 더 크다. 즉 바꿔야 하는 상황.
            return false;
        }
    }

    /*
    삭제 연산 과정
        1. root 값을 빼둔다.
        2. 단말 값을 저장한다.
        3. parent와 child를 각각 1 & 2로 한다.
        4. child중에서 가장 절댓값이 작은걸 찾아서, 있으면 바꾼다.
        5. child랑 단말값 비교한다. -> 단말값이 더 작아서 안 바꿔도 된다면 끝
        6. 바꿔야 한다면, child에 있는 것을 부모로 올리고 child 내린다.
        7. 부모에 해당하는 것에 단말 값 저장한다.
     */
    public static int deleteHeap(){
        if(heapSize == 0){
            return 0; //삭제할 것이 없는 경우
        }

        int removed = heap[1];
        int leaf = heap[heapSize--]; //단말값

        int parentInd = 1;
        int childInd = 2;

        // ⭐ 자식이 존재하는 동안만 진행해야 한다!!! -> parentInd = childInd; 그래야 여기서 정확하게 계산하고 멈출 수 있다.
        // 사이즈가 이미 하나 줄어든 것이므로 <= heapSize 이렇게만 진행해준다.
        while(childInd <= heapSize){
            if(childInd < heapSize && !isCompareStop(heap[childInd], heap[childInd+1])){
                childInd++; //바꿔야 한다.
            }

            //stop 조건
            if(isCompareStop(leaf, heap[childInd])){
                break;
            }

            //바꿔야한다.
            heap[parentInd] = heap[childInd];
            parentInd = childInd;
            childInd *= 2; //내려가기
        }
        heap[parentInd] = leaf; //자리 찾기

        return removed;
    }

    public static void insertHeap(int num){
        //끝단에 추가한다.
        heap[++heapSize] = num;
        int childInd = heapSize;

        //insert, delete는 방향이 반대기 때문에 isCompareStop을 반대로 체크해야 한다.
        while(childInd > 1 && !isCompareStop(heap[childInd/2], num)){
            heap[childInd] = heap[childInd/2];
            childInd /= 2; //위로 올라간다.
        }
        heap[childInd] = num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());
        heap = new int[100002]; //초기 힙 설정

        for(int i = 0; i<roop; i++){
            int num = Integer.parseInt(br.readLine());
            //0일 경우 삭제 연산이다.
            if(num == 0){
                bw.write(deleteHeap() +"\n");
            }else{
                insertHeap(num);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
