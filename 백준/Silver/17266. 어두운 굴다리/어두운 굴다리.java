import java.io.*;
import java.util.*;

public class Main {
    static int[] x;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = new int[m];
        for(int i = 0; i < m; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        while(left < right){
            int mid = (left + right) / 2;

            if(check(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
        br.close();
    }
    static boolean check(int mid){
        int cur = 0;

        for(int i = 0; i < x.length; i++){
            if(x[i] - mid > cur){
                return false;
            }
            cur = x[i] + mid;
        }

        if(cur >= n){
            return true;
        }else{
            return false;
        }
    }
}
