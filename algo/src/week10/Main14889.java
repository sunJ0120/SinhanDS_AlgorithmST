package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14889 {
    static int ans;
    static List<Integer> set;
    // contain을 안 쓰기 위해서 다음과 같이 boolean list를 하나 생성한다.
    static boolean[] picked;
    //이걸 사용하면 이 안에 이미 사용된 인덱스를 넣어둘 수 있다.

    // 리스트의 합
    public static int pairSum(List<Integer> set, int[][] team){
        int ans = 0;
        for(int i = 0; i<set.size(); i++){
            for(int j = i+1; j<set.size(); j++){
                ans += (team[set.get(i)][set.get(j)] + team[set.get(j)][set.get(i)]);
            }
        }
        return ans;
    }

    // 여집합 뽑아내는 method
    public static List<Integer> another(int size){
        List<Integer> anot = new ArrayList<>();
        for(int i = 0; i<size; i++){
            if(!picked[i]){ //false일 경우 진행한다.
                anot.add(i);
            }
        }
        return anot;
    }

    // n/2개씩 조합을 구한다.
    // size는 n으로 둔다.
    public static void n2(int start, int size, int[][] team){
        if(set.size() == size/2){
            List<Integer> anot = another(size);
            //합을 구한다.
            //여집합의 경우, 모든 조합이 정해진 다음에 구하는 방식으로 가야 중복이 없음.
            int ans1 = pairSum(set, team);
            int ans2 = pairSum(anot, team);

            ans = Math.min(ans, Math.abs(ans2-ans1));
            return;
        }
        for(int i = start; i<size; i++){
            set.add(i);
            picked[i] = true; //사용된 인덱스 라는 것을 표시해준다.
            n2(i+1, size, team);

            set.remove(set.size()-1);
            picked[i] = false; //picked를 초기화 해야 하므로, 이걸 false로 바꿔주면 된다.
        }
    }

    public static void init(int num){
        ans = Integer.MAX_VALUE;
        set = new ArrayList<>();
        picked = new boolean[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        init(num); //static method들 초기화

        //팀 넣기
        int[][] team = new int[num][num];

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<num; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // n/2 개씩 나오는 조합을 구한다.
        n2(0, num, team);

        //답
        System.out.println(ans);
    }
}
