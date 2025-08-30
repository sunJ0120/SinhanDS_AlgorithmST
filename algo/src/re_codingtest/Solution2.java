package re_codingtest;

import java.util.Arrays;

/*
문제2

1. 빈 수가 나오면 그게 답이다. 바로 answer에 저장해서 break 한다.
2. 끝까지 갈 경우, (max 에서 멈추기) answer -1
3. 두개인 수가 나올 경우, answer 그 수의 + 1

ind, exist, num 값을 따로 두고 비교하는데
ind안에 있는 값이 num 보다 작을 경우 num이 답이 되는 식이다.
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] list1 = {5,4,2,1};
        System.out.println(Solution(list1)); //3

        int[] list2 = {1,3,4,5};
        System.out.println(Solution(list2)); //2

        int[] list3 = {1,2,3,3,4,7};
        System.out.println(Solution(list3)); //4

        int[] list4 = {1,2,3,4,5,6,6};
        System.out.println(Solution(list4)); //-1

        int[] list5 = {1,2};
        System.out.println(Solution(list5)); //-1
    }

    public static int Solution(int[] list1){
        int answer = -1;

        //정렬
        Arrays.sort(list1);

        int ind = 0;
        int num = 1;
        int exist = 0;

        while(ind < list1.length-1){
            //1. 이미 있는 수인데 또 나온
            if(list1[ind] == exist){
                answer = exist+1;
                break;
            }

            //2. 수가 더 작을 경우 (빈 수)
            if(list1[ind] > num){
                answer = num;
                break;
            }

            exist = num; //존재하는 수로 잡아주기
            ind++; //이동
            num++; //num 증가
        }

        return answer;
    }
}
