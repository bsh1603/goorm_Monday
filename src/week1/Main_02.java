package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_02 {
    static int n;
    static String my_name;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        my_name = st.nextToken();

        for (int i = 0; i < n; i++) {
            String names = br.readLine();
            if(names.contains(my_name)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
