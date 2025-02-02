import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken();
            int idx;
            if(S.contains("X")){
                idx = S.indexOf('X');
            }else{
                idx = S.indexOf('x');
            }

            int value = (int)T.charAt(idx);
            if(value >= 97){
                value -= 32;
            }
            sb.append((char)value);
        }
        System.out.println(sb);
        br.close();
    }
}
