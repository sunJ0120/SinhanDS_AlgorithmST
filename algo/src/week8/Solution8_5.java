package week8;

import java.util.Arrays;
import java.util.Comparator;

/*
Level2. 가장 큰 수

- 완탐은 매우 비효율
- 교환논증 Exchange Argument을 이용해야 한다. (Comparator 재정의)
    - “최적이라고 가정한 배치”에서 인접한 두 원소 (x, y)가 있다고 하자.
    - 만약 yx > xy라면, ...xy...를 ...yx...로 바꾸면 전체 값이 커짐 → 원래 배치는 최적일 수 없다는 모순.
- 그러므로 기본적으로 내림차순 배치를 하되, x+y, y+x를 비교해야 한다.
- 즉, y+x, x+y를 기준으로 잡으면 된다.
 */
public class Solution8_5 {
    public static void main(String[] args) {
        int[] numbers = {0,0,0,0,0,0};
//        int[] numbers = {9,99, 999, 996, 9996, 98,987,9876, 6, 10, 2};
//        int[] numbers = {6, 10, 2};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        StringBuilder std = new StringBuilder();
        String[] st = new String[numbers.length];

        for(int i = 0; i<numbers.length; i++){
            st[i] = String.valueOf(numbers[i]);
        }

        //교환논증 적용
        Arrays.sort(st, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo((o1+o2));
            }
        });

        //모두 0인 경우는 0이어야 한다!!!! 숫자니까..
        //맨 앞이 0이면 다 0인것이다.
        if(st[0].equals("0")){
            return "0";
        }
        //메모리 효율을 위해 Builder로 추가하기
        for(String str : st){
            std.append(str);
        }

        return std.toString();
    }
}
