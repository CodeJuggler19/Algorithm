import java.io.*;
import java.util.*;

public class Main {
    static char[] A;
    static char[] array;
    static int B;
    static boolean[] vis;
    static int result = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        String temp = st.nextToken();
        if(A.length <= temp.length()){
            B = Integer.parseInt(temp);

            array = new char[A.length];
            vis = new boolean[A.length];

            combination(0);


            System.out.println(result);
        }else{
            System.out.println(result);
        }

        br.close();
    }

    static void combination(int idx){

        if(idx == A.length){
            cal();
            return;
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] == '0' && idx == 0){
                continue;
            }
            if(!vis[i]){
                array[idx] = A[i];
                vis[i] = true;
                combination(idx + 1);
                vis[i] = false;
            }
        }
    }
    static void cal(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length; i++){
            sb.append(array[i]);
        }
        int value = Integer.parseInt(String.valueOf(sb));

        if(value < B){
            result = Math.max(result, value);
        }
    }
}
