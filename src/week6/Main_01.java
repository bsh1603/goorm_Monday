package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int K = Integer.parseInt(br.readLine());
            int a_1 = K / 1000000;
            K -= ((a_1) * 1000000);
            int even_1 = K / 100000;
            K -= ((even_1) * 100000);
            int a_2 = K / 10000;
            K -= ((a_2) * 10000);
            int even_2 = K / 1000;
            K -= ((even_2) * 1000);
            int a_3 = K / 100;
            K -= ((a_3) * 100);
            int even_3 = K / 10;
            K -= ((even_3) * 10);
            int a_4 = K % 10;

            int a = a_1 + a_2 + a_3 + a_4;
            if(even_1 != 0){
                a = a * even_1;
            }
            if(even_2 != 0){
                a = a * even_2;
            }
            if(even_3 != 0){
                a = a * even_3;
            }

            System.out.println(a % 10);
        }
    }
}
