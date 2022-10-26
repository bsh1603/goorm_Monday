package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01 {
    static int n;
    static int[] island;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        island = new int[n];
        for (int i = 0; i < n; i++) {
            island[i] = Integer.parseInt(st.nextToken());
            answer *= island[i];
        }

        System.out.println(answer);
    }
}
