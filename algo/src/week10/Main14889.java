package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14889 {
    static int ans;
    static List<Integer> set;

    public static List<Integer> another(int size){
        List<Integer> anot = new ArrayList<>();
        for(int i = 0; i<size; i++){
            if(!set.contains(i)){
                anot.add(i);
            }
        }
        return anot;
    }

    // n/2개씩 조합을 구한다.
    // size는 n으로 둔다.
    public static void n2(int start, int size, int idx, int[][] team){
        if(set.size() == size/2){
            List<Integer> anot = another(size);
            //합을 구한다.
            //여집합의 경우, 모든 조합이 정해진 다음에 구하는 방식으로 가야 중복이 없음.
            int ans1 = 0;
            for(int i = 0; i<set.size(); i++){
                for(int j = i+1; j<set.size(); j++){
                    ans1 += (team[set.get(i)][set.get(j)] + team[set.get(j)][set.get(i)]);
                }
            }

            int ans2 = 0;
            for(int i = 0; i<anot.size(); i++){
                for(int j = i+1; j<anot.size(); j++){
                    ans2 += (team[anot.get(i)][anot.get(j)] + team[anot.get(j)][anot.get(i)]);

                }
            }

            ans = Math.min(ans, Math.abs(ans2-ans1));
            return;
        }
        for(int i = start; i<size; i++){
            set.add(i);
            n2(i+1, size, idx+1, team);

            set.remove(set.size()-1);
        }
    }

    public static void init(){
        ans = Integer.MAX_VALUE;
        set = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        init(); //static method들 초기화

        //팀 넣기
        int[][] team = new int[num][num];

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<num; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // n/2 개씩 나오는 조합을 구한다.
        n2(0, num, 0, team);

        //답
        System.out.println(ans);
    }
}
