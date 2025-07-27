package week5;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * [P5] 최솟값 찾기
 * 느낌이 TreeMap을 이용하는 문제인가..싶은데
 * 문제는 TreeMap의 value에 해당하는 값을 꺼내올때, 얼마나 시간이 걸릴지 감이 안잡힌다는 것이다.
 * 일단 풀어본다는거에 의의를 두고 도전만 해보자.
 */
public class Main11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //갯수에 해당한다.
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        int[] list = new int[n];
        for(int i = 0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0-l+1;
        int end = 0;

        //초기값 셋팅
        for(int i = start; i<=end; i++){
            if(i < 0){
                tree.put(Integer.MAX_VALUE, i);
            }else{
                tree.put(list[i], i);
            }
        }
        bw.write(tree.firstKey() + " "); //초기 최솟값을 담는다.

        //근데 이렇게 하면 굳이 index를 value에 넣을 필요가 잇나?
        while(start < n){
            //사실 최솟값을 구하는게 목적이라, 0보다 작은 경우는 고려하지 않아도 된다.
            if(start >= 0){
                tree.remove(list[start]); //start에 해당하는 것을 없앤다.
            }
            start++;
            end++;
            if(end > n){ //넘칠 경우, 무효처리를 위해 수를 max로 넣는다.
                tree.put(Integer.MAX_VALUE, end);
            }else{
                tree.put(list[end], end);
            }
            bw.write(tree.firstKey() + " "); //최솟값을 담는다.
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
