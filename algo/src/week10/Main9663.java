package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N-Queen

1. 모든 경우의 수를 탐구하기 위해 방향(r+c, r-c+n-1, n) 배열을 만들어서 체크한다.
2. dfs를 이용해서 모든 깊이를 탐색하면서 완전 탐색을 진행한다.
3. 대각선, 가로(보장된다.), 세로 안에 퀸이 있을 경우, 백트래킹으로 경우의 수를 제외하고 "옆" 요소로 넘어가도록 구성한다.
4. 종료조건은 모든 깊이를 다 탐색했을때이고, 모든 경우의 수 탐색을 위해 1차 깊이 탐색이 끝나면 true 값을 다시 false로 바꾸고 탐색을 계속한다.
 */
public class Main9663 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        boolean[] col = new boolean[num]; //열
        boolean[] diag1 = new boolean[2*num-1]; //대각선 1 역방향 r+c
        boolean[] diag2 = new boolean[2*num-1]; //대각선 2 순방향 r-c+n-1

        cnt = 0;
        dsf(num, 0, col,diag1,diag2);
        System.out.println(cnt);
    }

    public static void dsf(int num, int dept, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(dept == num){ //모든 깊이를 돈 경우
            cnt++;
            return;
        }
        //dsf 깊이 탐색
        for(int i = 0; i<num; i++){ //옆부분..
            //dept 들어가기 전에 가지치기, 백트래킹
            if(col[i] || diag1[dept+i] || diag2[dept-i+num-1]){
                continue; //다음 열로 넘어가기
            }

            col[i] = diag1[dept+i] = diag2[dept-i+num-1] = true; //이용할 수 없다고 표시
            dsf(num, dept+1, col, diag1, diag2);
            col[i] = diag1[dept+i] = diag2[dept-i+num-1] = false; //모든 요소 탐색을 위해 false 처리
        }
    }
}
