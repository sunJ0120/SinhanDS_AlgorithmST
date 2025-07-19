package week4;

import java.io.*;

/**
 * [S1] Main11286_절댓값 힙
 *
 * 우선순위의 기준이 절댓값이 작은 값 or 같을 경우 원래 값이 작은 값의 힙을 구현하는 문제이다.
 */
public class Main11286 {
    static int heapSize = 1;
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

    public static int deleteHeap(){
        if(heapSize <= 1){
            return 0; //삭제할 것이 없는 경우
        }

        int removed = heap[1];
        int parentInd = 1;
        int childInd = 2;
        int num = heap[heapSize-1]; //새로 root로 올라온 끝 수

        while(parentInd < heapSize-1){
            //child중에 가장 우선순위 높은 것을 구하기 위함이다.
            if(heap[childInd+1] != 0 && !isCompareStop(heap[childInd], heap[childInd+1])){
                childInd += 1; //오른쪽 자식으로 한다.
            }

            if(!isCompareStop(num, heap[childInd])){
                heap[parentInd] = heap[childInd];
                parentInd = childInd; //해당 child의 ind를 parent로 두고 내려간다.
                childInd = parentInd*2;
            }else{ //바꿀 필요 없으면 자리를 찾은 것이다
                break;
            }
        }
        heap[parentInd] = num; //내 자리 찾아서 이동한다.

        heapSize--;
        return removed; //가장 크던거 출력한다.
    }

    public static void insertHeap(int num){
        //끝단에 추가한다.
        heap[heapSize] = num;
        int childInd = heapSize++;

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
