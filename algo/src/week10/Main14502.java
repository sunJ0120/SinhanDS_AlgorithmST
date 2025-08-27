package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
14502. 연구소

1. 벽을 세우는 것을 완전탐색 & 백트래킹을 이용한다.
2. 바이러스를 퍼트리는 것은 BFS (Deque)를 이용한다.
3. 필요한 메서드
    - 배열 copy (초기화)를 위한 method
    - 벽 세우는 method
    - 바이러스 퍼트리는 method (deque 이용하면 굳이 재귀 없이도 해결 가능)
    - zero의 갯수를 세는 method
      - 결국 zero의 갯수가 가장 많은 것이 답이 된다.
 */
public class Main14502 {
    static List<int[]> empties; //빈자리를 넣어놓는 배열이다.
    static List<int[]> chooses; //선택된 x,y 값을 넣는 배열이다.
    static List<int[]> viruses; //초기 바이러스 위치 저장 배열
    static int[] yInd = {-1,1,0,0}; //상하좌우
    static int[] xInd = {0,0,-1,1}; //상하좌우
    static int ans;
    static int[][] copy;

    //virus[0] = i, virus[1] = j
    public static boolean isTrueInd(int i, int j, int n, int m, int num){
        if(yInd[num] + i < n && yInd[num] + i >= 0 && xInd[num] + j < m && xInd[num] + j >= 0){
            return true;
        }
        return false;
    }

    public static int countZero(int[][] lab, int n, int m){
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(lab[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int spread(int[][] lab, int n, int m){
        //bfs 진행을 위한 Deque 선언
        Queue<int[]> que = new ArrayDeque<>();

        //초기 바이러스 넣기
        for(int[] virus : viruses){
            que.add(virus);
        }

        while(!que.isEmpty()){
            int[] virus = que.poll();
            for(int i = 0; i<4; i++){ //방향 탐색
                if(isTrueInd(virus[0], virus[1], n, m, i)){
                    int x = virus[1] + xInd[i];
                    int y = virus[0] + yInd[i];
                    if(lab[y][x] == 0){
                        lab[y][x] = 2; //새로운 2 위치 넣어서 바이러스 퍼트리기
                        que.add(new int[]{y, x});
                    }
                }
            }
        }

        return countZero(lab, n, m);
    }
    public static void threeWell(int idx, int start, int[][] lab, int n, int m){
        //3개를 고른 상태라면,
        if(idx == 3){
            //copy 리스트 값을 지정해둔다. 항상 copy본을 이용하도록 한다.
            copy = copy(lab, n, m);
            //벽세우기
            for(int i = 0; i<chooses.size(); i++){
                copy[chooses.get(i)[0]][chooses.get(i)[1]] = 1;
            }
            //퍼트리기
            int cntZero = spread(copy, n, m);

            //zero 답 갱신하기
            ans = Math.max(cntZero, ans);

            return; //return으로 다음 조합으로 넘어가기
        }

        //조합으로 3개를 뽑는다.
        for(int i = start; i< empties.size(); i++){
            chooses.add(empties.get(i));
            threeWell(idx+1, i+1, lab, n, m);
            chooses.remove(chooses.size()-1); //마지막 지우고 다시 조합 찾기
        }
    }

    public static int[][] copy(int[][] list, int n, int m){
        int[][] returnList = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                returnList[i][j] = list[i][j];
            }
        }
        return returnList;
    }

    public static void init(int n, int m){
        //모든 static들 초기화
        ans = 0;
        empties = new ArrayList<>();
        chooses = new ArrayList<>();
        viruses = new ArrayList<>();
        copy = new int[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //모든 static 초기화
        init(n, m);

        //랩실 설정
        int[][] lab = new int[n][m];

        for(int i = 0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st2.nextToken());
                lab[i][j] = num;
                if(num == 0){ //빈 곳 따로 저장
                    empties.add(new int[]{i,j});
                }else if(num == 2){ //바이러스 따로 저장
                    viruses.add(new int[]{i,j});
                }
            }
        }
        //벽 놓기
        threeWell(0, 0, lab, n, m);
        System.out.println(ans);
    }
}
