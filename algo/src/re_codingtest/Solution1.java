package re_codingtest;

import java.util.*;

/*
문제1

1) Map을 이용해서 list1과 인덱스를 매핑한 다음 정렬한다.
2) 정렬 기준 두 가지를 기준으로 정렬한다.
3) 각 상위 n개의 인덱스를 추려서 list에 저장한다.
4) list2에서 실 값을 비교해서 list를 만든다.
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] list1 = {{3,650},{4,2000},{5,150},{2,200},{1,300}};
        int[] list2 = {300,1500,300,400,250};
        int n = 3;

        System.out.println(Arrays.toString(Solution(list1, list2, n)));
    }
    public static int[] Solution(int[][] list1, int[] list2, int n){
        int[] answer = new int[2];
        int[][] copyList = new int[list1.length][3]; //인덱스를 하나 추가하기 위함이다.
        List<Integer> grade = new ArrayList<>(); //순위 상위 n까지의 인덱스 저장용
        List<Integer> money = new ArrayList<>(); //수입 상위 n까지의 인덱스 저장용

        //list copy 및 인덱스 끝에 추가
        for(int i = 0; i<list1.length; i++){
            for(int j = 0; j<2; j++){
                copyList[i][j] = list1[i][j];
            }
            copyList[i][2] = i;
        }

        //순위별 재정의
        Arrays.sort(copyList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //순위별 재정의 상위 n까지의 값의 합
        int ans1 = 0;
        for(int[] list : copyList){
            ans1 += list[1];
            grade.add(list[2]);
        }

        //수입별 재정의
        Arrays.sort(copyList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        //수입별 재정의 상위 n까지의 값의 합
        int ans2 = 0;
        for(int[] list : copyList){
            ans2 += list[1];
            money.add(list[2]);
        }

        //------실 값으로 구하기

        for(int grad : grade){
            ans1 -= list2[grad];
        }

        for(int mon : money){
            ans2 -= list2[mon];
        }

        answer[0] = Math.abs(ans1);
        answer[1] = Math.abs(ans2);

        return answer;
    }
}
