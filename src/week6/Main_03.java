/**
 * fail
 */

package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_03 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            String oper_key = br.readLine();
            char oper = oper_key.charAt(0);
            String key = oper_key.substring(2, oper_key.length());
            int len_key = key.length();
            ArrayList<Character> code = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                if ((65 <= input.charAt(i) && input.charAt(i) <= 90) || (97 <= input.charAt(i) && input.charAt(i) <= 122)) {
                    if(oper == 'E'){
                        code.add(encode(input.charAt(i), key.charAt(i % len_key)));
                    }
                    if(oper == 'D'){
                        code.add(decode(input.charAt(i), key.charAt(i % len_key)));
                    }
                } else {
                    code.add(input.charAt(i));
                }
            }
            for(char c : code){
                System.out.print(c);
            }
            System.out.println("");
        }

    }

    static char encode(char c, char k){
        char enc = ' ';

        int key_num = k; // 75
        key_num %= 26; // 23
        int code_num = c; // 72

        // 대문자
        if(65 <= code_num && code_num <= 90){
            int index = code_num + key_num;
            if(index <= 90){
                enc = (char) (index);
            }
            else{
                enc = (char) (index - 26);
            }
        }

        // 소문자
        if(97<= code_num && code_num <= 122){
            int index = code_num + key_num ;
            if(index <= 122){
                enc = (char) (index);
            }
            else{
                enc = (char) (index - 26);
            }
        }

        return enc;
    }

    static char decode(char c, char k){
        char enc = ' ';

        int key_num = k; // 75
        key_num %= 26; // 23
        int code_num = c; // 72

        // 대문자
        if(65 <= code_num && code_num <= 90){
            int index = code_num - key_num;
            if(index >= 60){
                enc = (char) (index);
            }
            else{
                enc = (char) (index + 26);
            }
        }

        // 소문자
        if(97<= code_num && code_num <= 122){
            int index = code_num - key_num;
            if(index >= 97){
                enc = (char) (index);
            }
            else{
                enc = (char) (index + 26);
            }
        }

        return enc;
    }
}
