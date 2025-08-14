package week8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
[3차] 파일명 정렬

- 숫자 제외하고 다 잘라낸 다음, 숫자로 비교하면 될 것 같다.
- 사전순 비교의 경우 o1.compareToIgnoreCase(o2)를 이용한다. (도움 받음)
- . 뒤에 있는 모든 문자를 삭제하기 위해서는 "\\..*"를 하면 된다. (.이 아무 문자나 하나라는 의미이므로,)
- 문자열 다루는게 좀 미숙해서, 정규표현식 관련 도움을 받았으므로, 복습이 필요하다.

- 숫자 다음에 문자열 + 숫자 조합이면 그것도 tail에 해당하므로, 숫자만 남겨두고 replaceAll을 쓰는 방법은 쓸 수 없음.
 */
public class Solution8_4 {
    public static void main(String[] args) {
        String[] files = {"foo010bar020.zip","foo020bar020.zip", "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));

//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
//        System.out.println(Arrays.toString(solution(files)));
    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        //정렬 : 처음엔 사전순, 나중에 숫자순
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Str = o1.replaceAll("\\d+.*","");
                String o2Str = o2.replaceAll("\\d+.*","");

                //동률일 경우,
                if(o1Str.compareToIgnoreCase(o2Str) == 0){
                    String[] o1Num = o1.split("\\D+"); //숫자 이외로 split
                    String[] o2Num = o2.split("\\D+"); //숫자 이외로 split

                    return Integer.parseInt(o1Num[1]) - Integer.parseInt(o2Num[1]); //빈칸 무시
                }
                return o1Str.compareToIgnoreCase(o2Str); //사전순 정렬
            }
        });
        answer = files; //참조 복사
        return answer;
    }
}
