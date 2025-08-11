package week7;

import java.util.Arrays;

/*
Level 2. 쿼드 압축 후 개수 세기

- mid 값을 두고 쪼개는게 포인트이다.
- 처음 잡았던 것처럼, 좌상 우상 좌하 우하로 나눠서 4번씩 호출하는 것이 맞음
- 처음 아이디어는 잡았으나, 이후 GPT 도움을 받았으므로 반드시 복습이 필요하다!!!!!
*/
public class Solution7_2 {
    static int[] answer;
    public static void main(String[] args) {
//        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr =
                {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static boolean isTrue(int startX, int endX, int startY, int endY, int[][] arr){
        int num = arr[startY][startX];

        for(int i = startY; i<endY; i++){
            for(int j = startX; j<endX; j++){
                if(num != arr[i][j]){ //하나라도 다르면 false이다.
                    return false;
                }
            }
        }
        return true;
    }

    public static void quad(int startX, int endX, int startY, int endY, int[][] arr){
        //체크하는 것 추가
        if(isTrue(startX, endX, startY, endY, arr)){
            answer[arr[startY][startX]]++;
            return;
        }

        int midX = (startX + endX) /2;
        int midY = (startY + endY) /2;

        quad(startX, midX, startY, midY, arr); //좌상
        quad(midX, endX, startY, midY, arr); //우상
        quad(startX, midX, midY, endY, arr); //좌하
        quad(midX, endX, midY, endY, arr); //우하
    }

    public static int[] solution(int[][] arr) {
        answer = new int[2];
        quad(0, arr[0].length, 0, arr.length, arr);
        return answer;
    }
}
