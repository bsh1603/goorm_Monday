package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_08 {
    static int N, c;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;

        for (int i = 0; i < N-1; i++) {
            if(input[i+1] - input[i] > c){
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}