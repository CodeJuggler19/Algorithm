import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int maxStart = (int) Math.pow(2, N) - 1;
        cal(N, 0, maxStart, 0, maxStart, 0);

        br.close();
    }

    static void cal(int n, int minR, int maxR, int minC, int maxC, int seq) {
        int rc = (int) Math.pow(2, n);
        if (n == 1) {
            if(r == minR && c == minC){
                System.out.println(seq);
            }else if(r == minR && c == maxC){
                System.out.println(seq + 1);
            }else if(r == maxR && c == minC){
                System.out.println(seq + 2);
            }else{
                System.out.println(seq + 3);
            }
        } else {
            int seqStart = seq;
            int seqValue = (rc * rc) / 4;

            int midR = (minR + maxR) / 2;
            int midC = (minC + maxC) / 2;
            if (r <= midR && c <= midC) {
                //1
                cal(n - 1, minR, midR, minC, midC, seqStart);

            } else if (r <= midR && c <= maxC) {
                //2
                seqStart += seqValue;
                cal(n - 1, minR, midR, midC + 1, maxC, seqStart);
            } else if (r <= maxR && c <= midC) {
                //3
                seqStart += (seqValue * 2);
                cal(n - 1, midR + 1, maxR, minC, midC, seqStart);
            } else { // r <= max && c <= max
                //4
                seqStart += (seqValue * 3);
                cal(n - 1, midR + 1, maxR, midC + 1, maxC, seqStart);
            }
        }


    }
}
