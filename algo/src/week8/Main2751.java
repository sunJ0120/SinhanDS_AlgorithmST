package week8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i<roop; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums); //오름차순 정렬

        for(int i = 0; i<nums.size(); i++){
            bw.write(nums.get(i) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
