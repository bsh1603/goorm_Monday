package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main_03_re {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            String total_key = br.readLine();
            char type = total_key.charAt(0);
            String key = total_key.substring(2);

            if(type == 'E'){
                String res = "";
                int index = 0;
                for (int i = 0; i < input.length(); i++) {
                    if(index == key.length()){
                        index = 0;
                    }

                    if('a'<=input.charAt(i) && input.charAt(i)<='z'){
                        res += (char)((input.charAt(i) + key.charAt(index) - 'a')%26 + 'a');
                        index++;
                    }
                    else if('A'<=input.charAt(i) && input.charAt(i) <= 'Z'){
                        res += (char)((input.charAt(i) + key.charAt(index) - 'A')%26 + 'A');
                        index++;
                    }
                    else{
                        res += input.charAt(i);
                        index++;
                    }

                }
                System.out.println(res);
            }

            else{
                String res = "";
                int index = 0;
                for (int i = 0; i < input.length(); i++) {
                    if(index == key.length()){
                        index = 0;
                    }

                    if('a'<=input.charAt(i) && input.charAt(i)<='z'){
                        res += (char)((input.charAt(i) + (26-key.charAt(index)%26) - 'a')%26 + 'a');
                        index++;
                    }
                    else if('A'<=input.charAt(i) && input.charAt(i) <= 'Z'){
                        res += (char)((input.charAt(i) + (26-key.charAt(index)%26) - 'A')%26 + 'A');
                        index++;
                    }
                    else{
                        res += input.charAt(i);
                        index++;
                    }

                }
                System.out.println(res);
            }

        }
    }
}
