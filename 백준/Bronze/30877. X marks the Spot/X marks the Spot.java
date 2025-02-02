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
            int idx = 0;
            for (int j = 0; j < S.length(); j ++){
                int cur = (int)S.charAt(j);
                if(cur == 88 || cur == 120){
                    idx = j;
                    break;
                }
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
