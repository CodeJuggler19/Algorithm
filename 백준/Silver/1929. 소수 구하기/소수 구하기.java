import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[1000001];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(1000001); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i * i; j < prime.length; j = j + i){
                prime[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = M; i<=N; i++){
            if(!prime[i]){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
