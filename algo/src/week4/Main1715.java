package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
BOJ 1715. 카드 정렬하기 1차 시도)
- 기본적으로 합이 작은게 우선으로 더해져야 하므로, 최소힙을 따른다.
- 사실 이 방법이 아닌거 같기도 한데... 딱히 생각나는 방법이 없어서 우선 진행한다.

1. 우선 내림차순 정렬하고 배열에 저장한다.
2. SIZE 1일때가지 진행한다.
    1) delete 두 번 진행해서 두 값 더한다.
    2) insert로 해당 값 더한다.
 */
public class Main1715{
    static List<Integer> heap;
    static int heapSize;

    //heap insert method
    public static void insertHeap(int n){
        heap.add(++heapSize, n);
        int ind = heapSize;

        //n이 더 작을 경우에 바꿔야 한다.
        //n이 더 커지면 올라가지 않고 그 자리를 유지한다.
        while(ind != 1 && n < heap.get(ind/2)){
            heap.add(ind, heap.get(ind/2)); //부모의 요소를 아래로 내린다.
            ind /= 2; //위로 올라간다.
        }
        heap.add(ind, n);
    }

    //child 값 비교를 위한 method
    //더 값이 작은 child의 ind를 내보낸다.
    public static int compareChild(int childInd1, int childInd2){
        if(heap.get(childInd1) < heap.get(childInd2)){
            return childInd1;
        }
        return childInd2;
    }

    //heap delete method
    public static int deleteHeap(){
        int removed = heap.get(1);
        int root = heap.get(heapSize--); //맨 끝에 있는 요소

        int parentInd = 1;
        int childInd = 2;

        while(childInd <= heapSize){
            //child가 존재할 경우, 더 작은 인덱스를 구해야 한다.
            if(childInd < heapSize){
                childInd = compareChild(childInd, childInd+1);
            }

            // root가 더 작으면 그자리 유지 이므로,,
            if(root < heap.get(childInd)){
                break;
            }

            heap.add(parentInd,heap.get(childInd)); //올리기, 더 작으므로
            //내려가기
            parentInd = childInd;
            childInd *= 2;
        }

        heap.add(parentInd, root);
        return removed;
    }

    //heapSize가 1이면 멈춘다.
    public static int cardSort(){
        int ans = 0;
        //heapSize가 1이면 멈춰야 한다.
        while(heapSize > 1){
            //가장 작은 두개를 더해서 insert 한다.
            int card1 = deleteHeap();
            int card2 = deleteHeap();

            insertHeap(card1 + card2);
            ans += heap.get(1); //root 더하기
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        heapSize = num; //index
        heap = new ArrayList<>();
        heap.add(0); //0에 인덱스 추가

        for(int i = 0; i<num; i++){
            heap.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(heap); //오름차순 정렬
        System.out.println(cardSort());
    }
}
