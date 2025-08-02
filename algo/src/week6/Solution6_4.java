package week6;

import java.util.Arrays;

/*
level 2. 전화번호 목록
- phone_book : 전화번호 목록

- 뭐 이런...결국 해시 안쓰는게 빠르잖아.
- 사전순 정렬하면 반드시 뒤에 포함되는 것이 뜬다는것 & startWith을 이용한다.
 */
public class Solution6_4 {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //사전순 정렬
        Arrays.sort(phone_book);

        //결국 접두어 이므로 앞에 하나만 비교하면 된다!!!!!
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
