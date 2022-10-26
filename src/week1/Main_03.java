package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_03 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new int[4];

        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        System.out.println(distance(nums[3], nums[0], nums[1], nums[2]));
    }

    static int distance(int x1, int x2, int y1, int y2){
        return Math.abs(x1- x2) + Math.abs(y1-y2);
    }
}
