import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] S = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length - 1; i++ ){
            if(S[i] == '('){
                if(S[i + 1] == '('){
                    sb.append("(");
                }else{
                    sb.append("(1");
                }
            }else{ //memo S[i] == ')'
                if(S[i + 1] == '('){
                    sb.append(")+");
                }else{
                    sb.append(")");
                }
            }
        }
        sb.append((S[S.length - 1]));
        System.out.println(sb);
        br.close();
    }
}
