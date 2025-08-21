package week9;

import java.util.HashSet;
import java.util.Set;

/*
소수 찾기 & 완전 탐색 섞인 버전

1. 우선, 완전탐색을 통해 만들 수 있는 모든 수를 찾는다.
2. set에 저장해서 중복을 없애고, 루트 n까지 해서 소수인지를 확인한다.
3. 소수인 것의 개수를 출력한다.

- 1트 : 58.3으로 틀림...디버깅 해서 찾아보기
- 2트 : n % i == 0 && n != i 이 조건을 추가해야 i가 2일때를 놓치지 않고 계산이 가능하다!!!
 */
public class Solution9_3 {
    public static Set<Integer> demical;
    public static int maxVal;

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    //완전 탐색을 위한 이 DFS 구조를 명확하게 익히는 것이 좋다!!!!!
    public static void dfs(char[] chars, boolean[] used, StringBuilder stb){
        //뭐라도 숫자가 하나 있다면 더해야 한다.
        if(stb.length() > 0){
            int added = Integer.parseInt(stb.toString());
            if(added > 1){ //0과 1을 제거하기 위함이다.
                demical.add(added);
                maxVal = Math.max(maxVal, added);
            }
        }

        //1번부터 시작한다.
        for(int i = 0; i<chars.length; i++){
            if(used[i]){ //이미 사용한 것은 넘어간다.
                continue;
            }
            stb.append(chars[i]);
            used[i] = true;
            dfs(chars,used,stb); //다음 깊이로 들어간다.
            stb.deleteCharAt(stb.length()-1); //백트래킹을 위해 마지막을 삭제 (같은 깊이에서 다른 선택..)
            used[i] = false;
        }
    }

    public static int solution(String numbers) {
        int answer = 0;
        maxVal = 0;

        demical = new HashSet<>();
        StringBuilder stb = new StringBuilder();
        char[] chars = numbers.toCharArray();
        boolean[] used = new boolean[chars.length];

        dfs(chars, used, stb); //여기서, 가능한 모든 경우의 수를 저장 가능

        //플래그를 꼭 둬야 하나..??? 일단 이렇게 풀어보고, 나중에 고쳐야겠음.
        boolean isDemical = true;

        for(int n : demical){ //구한 모든 수 대비, 비교한다.
            for(int i = 2; i<Math.sqrt(n)+1; i++){
                if(n % i == 0 && n != i){
                    isDemical = false;
                    break;
                }
            }
            if(isDemical){ //소수 일 때
                answer++;
            }
            isDemical = true;
        }
        return answer;
    }
}
