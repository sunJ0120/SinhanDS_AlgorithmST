package week6;

import java.util.Hashtable;

/*
level 1. 완주하지 못한 선수
- participant : 마라톤에 참여한 선수
- completion : 완주한 선수

HashTable을 이용해서 체크하는 방식으로 가야할 것 같은데,
지금 사실 HashTable의 개념을 완벽하게 익히지는 못함....
일단 기초 문제니까 풀고, 개념 정리 한 다음에 응용 문제를 풀자.
 */
public class Solution6_2 {

    public static void main(String[] args) {

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Hashtable<String, Integer> hashT = new Hashtable<>();

        //해시 테이블에 participant를 넣는다.
        //이미 존재하는 이름일 경우, 하나 늘린다.
        for(String st : participant){
            if(hashT.containsKey(st)){
                addOrRemoveHashTable(true, hashT, st);
            }else{
                hashT.put(st,1); //기본값은 하나이다.
            }
        }

        //해시 테이블에서 완주자를 지운다.
        for(String st : completion){
            if(hashT.get(st) > 1){ //하나 이상이다.
                addOrRemoveHashTable(false, hashT, st);
            }else{
                hashT.remove(st);
            }
        }

        // [참고] 하나 남았을 때는, entrySet()으로 iterator 돌려서 next로 잡아오면 된다.
        answer = hashT.entrySet().iterator().next().getKey();

        return answer;
    }

    //method를 따로 분리해서 가독성, 재사용성을 높였다.
    public static void addOrRemoveHashTable(boolean isAdd, Hashtable<String, Integer> hashT, String st){
        int cnt = hashT.get(st);
        hashT.remove(st);
        if(isAdd){ //이럴 경우, 더하기라는 의미이다.
            hashT.put(st, cnt+1); //하나 증가시켜서 넣는다.
        }else{ // remove에 해당한다.
            hashT.put(st, cnt-1); //하나 감소시킨다.
        }
    }
}
