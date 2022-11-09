package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main_02 {
    static int N;
    static String code;
    static ArrayList<Character> char_list;
    static ArrayList<Integer> num_list;
    static ArrayList<Character> decode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        code = br.readLine();

        char_list = new ArrayList<>();
        num_list = new ArrayList<>();
        decode = new ArrayList<>();

        for (int i = 0; i < code.length(); i++) {
            if(i % 2 == 0){
                char_list.add(code.charAt(i));
            }
            if(i % 2 == 1){
                num_list.add(Character.getNumericValue(code.charAt(i)));
            }
        }

        for (int i = 0; i < char_list.size(); i++) {
            char test = char_list.get(i);
            int multiply = num_list.get(i);
            int num = test - 'a';
            num = num + (multiply) * (multiply);
            num %= 26;
            char ans = (char) (num + 'a');
            decode.add(ans);
        }

        for(char c : decode){
            System.out.print(c);
        }
    }
}
