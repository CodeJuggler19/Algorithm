import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[7];

        for(int i = 0; i < 3; i++){
            int cnt = Integer.parseInt(st.nextToken());
            num[cnt]++;
        }

        func(num);

        System.out.println(result);
        br.close();
    }
    private static void func(int[] num){

        for(int i = 3; i >= 1; i--){
            for(int j = 6; j >= 1; j--){
                if(i == num[j]){
                    if(i == 3){
                        result = 10000 + j * 1000;
                        return;
                    }else if(i == 2){
                        result = 1000 + j * 100;
                        return;
                    }else{ // i == 1
                        result = j * 100;
                        return;
                    }
                }
            }

        }
    }
}
