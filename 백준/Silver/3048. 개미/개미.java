import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        char[] list = new char[300];
        Arrays.fill(list, ' ');
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int idx = A.length - 1;
        int aL = A.length + (A.length - 1);
        for (int i = 0; i < aL; i += 2) {
            list[i] = A[idx--];
        }
        idx = 0;
        int bL = B.length + (B.length - 1);
        for (int i = aL; i < aL + bL; i += 2) {
            list[i] = B[idx++];
        }

        int T = Integer.parseInt(br.readLine());
        idx = aL - 1;
        while(T -- > 0){
            for(int i = idx; i >= (idx + 1) - aL; i -= 2) {
                list[i + 2] = list[i];
                if (i == ((idx + 1) - aL)) {
                    list[i] = ' ';
                }
            }
            idx += 2;
        }
//        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 300; i++ ){
            if(list[i] != ' '){
                sb.append(list[i]);
            }
        }
        System.out.println(sb);
        br.close();
    }

}
