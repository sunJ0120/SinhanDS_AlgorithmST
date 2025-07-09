package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1927 {
    public static int[] heap;

    //start 값 같은 경우는 부모 node라 이동하는 값이고, end값은 이동 안한다. 비교만 한다.
    public static void heapSort(int start, int end){
        int leftChd = heap[start * 2];
    }

    //heap 삭제를 위한 연산
    public static int delete(){
        // start
        int startIdx = 1; //1부터 시작한다. 처음에는 root값이다.
        int endIdx = heap.length - 1;
        int ans = 0;

        if(endIdx == 0){
            return ans;
        }

        //root 값을 뽑아서 최솟값을 뽑는다
        ans = heap[startIdx];
        //heap[1]은 뽑았으므로 -1로 만든다.
        heap[startIdx] = -1;
        //heap[1]에 마지막 값을 넣는다.
        heap[startIdx] = heap[endIdx];
        //end값은 뺐으므로 -1로 둔다.
        heap[endIdx--] = -1;

        //이제 정렬을 한다.
        heapSort(startIdx, endIdx);

        //여기서 재귀적으로 돌면서 정렬을 해야 한다.
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //roop

        heap = new int[num]; //힙을 정의할 리스트이다.

        //roop만큼 돈다.
        for(int i = 0; i<num; i++){
            int n = Integer.parseInt(br.readLine());

            //삭제 연산 정의
            if(n == 0){

            }
        }
    }
}
