package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_02 {
    static int N, M;
    static int[] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 친구 수
        M = Integer.parseInt(br.readLine()); // 관계 수

        friend = new int[N+1];
        for (int i = 1; i <= N; i++) {
            friend[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(find(1) == find(i)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int find(int n){
        if(n == friend[n]){
            return n;
        }
        else{
            return friend[n] = find(friend[n]);
        }
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb){
            friend[fa] = fb;
        }
    }
}
