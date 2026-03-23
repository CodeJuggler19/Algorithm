import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] result = new String[N];

        for(int i = 0; i < N; i++){
            result[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result[0].length(); i++){
            boolean yn = false;
            char base = result[0].charAt(i);
            for(int j = 1; j < N; j++){
                if(result[j].charAt(i) != base){
                    yn = true;
                    break;
                }
            }
            if(yn){
                sb.append("?");
            }else{
                sb.append(base);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
