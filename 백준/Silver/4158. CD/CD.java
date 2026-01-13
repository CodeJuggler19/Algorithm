import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 & M == 0) break;
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(br.readLine());
                set.add(num);
            }

            int result = 0;
            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(br.readLine());
                if(set.contains(num)){
                    result ++;
                }
            }
            System.out.println(result);
        }

        br.close();
    }
}
