package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                sum += score[i];
            }
            double avg = (double)sum / n;

            int cnt = 0;
            for (int i = 0; i < score.length; i++) {
                if(score[i] >= avg){
                    cnt++;
                }
            }
            System.out.printf(cnt+"/"+n);
            System.out.println("");
        }
    }
}
