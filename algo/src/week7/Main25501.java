package week7;

import java.io.*;

/*
[B2] 25501 재귀의 귀재
- 그냥 팰린드롬 재귀로 구현해서, 결과랑 호출 횟수 return 하면 되는 문제이다.
- 쉬움...재귀의 개념을 이해하기엔 좋은 문제인듯
 */
public class Main25501 {
    public static int cnt;
    public static int recursion(char[] pal, int startInd, int endInd){
        cnt++;
        //더 커지거나 같으면 끝나야 한다.
        if(startInd >= endInd){
            return 1;
        }

        if(pal[startInd] != pal[endInd]){
            return 0;
        }else{
            return recursion(pal, startInd+1, endInd-1);
        }
    }
    public static int isPalindrome(char[] pal, int startInd, int endInd){
        return recursion(pal, startInd, endInd);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            char[] pal = br.readLine().toCharArray();
            cnt = 0;
            bw.write(isPalindrome(pal, 0, pal.length-1) + " ");
            bw.write(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
