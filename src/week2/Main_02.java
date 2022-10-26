package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_02 {
    static int N;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        int cnt = 1;

        for (int i = 0; i < N-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                continue;
            }
            else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
