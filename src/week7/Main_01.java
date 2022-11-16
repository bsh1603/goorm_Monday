package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_01 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] event = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                 event[Integer.parseInt(st.nextToken())]++;
            }
        }

        int max = Integer.MIN_VALUE;
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < event.length; i++) {
            max = Math.max(max, event[i]);
        }

        for (int i = 0; i < event.length; i++) {
            if(max == event[i]){
                answers.add(i);
            }
        }

        Collections.sort(answers, Collections.reverseOrder());

        for(int val : answers){
            System.out.printf(val + " ");
        }
    }
}
