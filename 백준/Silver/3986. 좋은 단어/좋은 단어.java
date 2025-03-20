import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < N; i++){
            char[] input = br.readLine().toCharArray();
            Stack<Character> s = new Stack<>();
            for(char ch : input){
                if(s.isEmpty()){
                    s.push(ch);
                }else{
                    if(s.peek() == ch){
                        s.pop();
                    }else{
                        s.push(ch);
                    }
                }
            }
            if(s.isEmpty()){
                result ++;
            }
        }

        System.out.println(result);

        br.close();
    }
}
