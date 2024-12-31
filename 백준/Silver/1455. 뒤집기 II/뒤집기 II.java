import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] coin = new boolean[N][M];

        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(input[j] == '0'){
                    coin[i][j] = true;
                }
            }
        }
        int result = 0;
        for(int i = N - 1; i >= 0; i--){
            for(int j = M - 1; j >= 0; j--){
                if(!coin[i][j]){
                    result ++;
                    for(int k = i; k >= 0; k--){
                        for(int l = j; l >= 0; l--){
                            coin[k][l] = !coin[k][l];
                        }
                    }
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
