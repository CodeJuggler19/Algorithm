import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;

        int min = 0;
        int max = 0;

        for(int i = 2; i < Math.sqrt(10000); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i * i; j <= 10000; j += i){
                prime[j] = true;
            }
        }
        boolean init = false;
        for(int i = M; i <= N; i++){
            if(!prime[i]){
                max += i;
            }
            if(!init && !prime[i]){
                min = i;
                init = true;
            }
        }
        if(min == 0){
            System.out.println(-1);
        }else{
            System.out.println(max);
            System.out.println(min);
        }
        br.close();
    }
}
