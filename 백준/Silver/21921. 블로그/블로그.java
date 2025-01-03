import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;

    static int period = 0;
    static int N, X;

    static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        count = new int[N + 1];
        int temp = 0;
        for(int i = 1; i <= N; i++){
            count[i] = Integer.parseInt(st.nextToken());
            if(i <= X){
                temp += count[i];
            }
        }
        max = Math.max(max, temp);
        period = 1;

        for(int i = 2; (i + X - 1) <= N; i++){
            temp -= count[i - 1];
            temp += count[i + X - 1];

            if(temp > max){
                max = temp;
                period = 1;
            }else if(temp == max){
                period++;
            }
        }
        if(max == 0){
            bw.write("SAD");
        }else{
            bw.write(max + "\n");
            bw.write(period + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
