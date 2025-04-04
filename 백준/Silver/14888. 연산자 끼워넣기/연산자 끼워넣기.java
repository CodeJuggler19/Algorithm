import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] list;
    static int[] num;
    static int[] operator = new int[4];
    // +, -, *, /
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];

        list = new int[N - 1];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        select(0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }


    static void select(int idx){

        if(idx == N - 1){
            cal();
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                list[idx] = i;
                operator[i] --;
                select(idx + 1);
                operator[i] ++;
            }
        }
    }

    static void cal(){
        int[] temp = new int[N];

        for(int i = 0; i < N; i++){
            temp[i] = num[i];
        }

        for(int i = 0; i < N - 1; i++){
            if(list[i] == 0){ // +
                temp[i + 1] = temp[i] + temp[i + 1];
            }else if(list[i] == 1){ // -
                temp[i + 1] = temp[i] - temp[i + 1];
            }else if(list[i] == 2){// *
                temp[i + 1] = temp[i] * temp[i + 1];
            }else{ // /
                boolean check = false;
                if(temp[i] < 0){
                    temp[i] *= (-1);
                    check = true;
                }

                temp[i + 1] = temp[i] / temp[i + 1];
                if(check){
                    temp[i + 1] *= (-1);
                }
            }
        }

        min = Math.min(min, temp[N - 1]);
        max = Math.max(max, temp[N - 1]);
    }
}
