package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Level 2. 하노이탑

- 하노이탑의 기본 개념을 완벽하게 이해하고 있으면 된다.
- 하노이탑은, 기본적으로 재귀로 이뤄지는데
    -  1->2, 3 (n-1)
    -  1->3 (1)
    -  2->3, 1 (n-1)
을 해주면 된다.
- 이 문제에서는, 몇번 원판을 몇변으로 옮기는지를 list에 담아서 출력하면 된다.
 */
public class Solution7_1 {
    static List<int[]> res;

    public static void main(String[] args) {
        int[][] answer = solution(3);
        for (int[] as : answer) {
            System.out.println(Arrays.toString(as));
        }
    }

    public static int[][] solution(int n) {
        int[][] answer = {};

        res = new ArrayList<>();
        hanoi(1, 3, 2, n);

        //List -> int[][] 주의!!
        answer = res.stream().toArray(int[][]::new);

        return answer;
    }

    public static void hanoi(int start, int end, int mid, int cnt){
        //0일때 멈춰야 하나를 옮긴 결과를 볼 수 있다.
        if(cnt == 0){
            return;
        }

        hanoi(start, mid, end, cnt-1);
        int[] go = {start,end};
        res.add(go); //하나씩 이동하는 것을 추가한다.
        hanoi(mid, end, start, cnt-1);
    }
}
