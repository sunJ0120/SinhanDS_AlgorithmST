package week6;

import java.util.HashMap;
import java.util.Map;

/*
level 2. 의상
- String[][] clothes : 옷 배열

- 어떤 느낌으로 구하는건지는 알겠는데...조합을 직접 구현해야 하나
- hash.getOrDefault를 통해 없으면 0으로 -> NullPointException 방지가 가능하다.
- hash도 value 쓰면 for-each 가능하다.
 */
public class Solution6_5 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();

        for(String[] clothe : clothes){
            hash.put(clothe[1], hash.getOrDefault(clothe[1],0)+1);
        }

        //갯수당 하나 or 0개 고르면 되므로,
        for(int cnt : hash.values()){
            answer *= (cnt + 1);
        }

        return answer-1; //다 고르지 않을 경우인 1개를 뺀다.
    }
}
