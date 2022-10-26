/**
 * 근묵자흑
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_02 {
    static int N, K;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 먼저 K만큼 뺀다.
        N -= K;
        cnt += 1;

        // 남은 N을 K-1로 나눈 몫을 더한다.
        // 나머지가 없다면 그대로 몫만 더해주고 나머지가 있다면 1을 추가로 더해준다.
        if(N%(K-1) == 0){
            cnt += (N/(K-1));
        }
        else{
            cnt += (N/(K-1)) + 1;
        }

        System.out.println(cnt);
    }
}
