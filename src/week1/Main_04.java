package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_04 {
    static int n;
    static boolean[] prime = new boolean[100001];
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        prime[0] = prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if(prime[i] == false){
                for (int j = 2; i*j < prime.length; j++) {
                    prime[i*j] = true;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            if(prime[i] == false){
                sum += nums[i-1];
            }
        }

        System.out.println(sum);
    }
}
