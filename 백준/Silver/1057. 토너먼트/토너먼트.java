import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(true){
            if(a % 2 == 1) a += 1;
            a /= 2;
            if(b % 2 == 1) b += 1;
            b /= 2;

            if(a == b) break;

            cnt ++;
        }
        System.out.println(cnt);

        br.close();

    }
}
