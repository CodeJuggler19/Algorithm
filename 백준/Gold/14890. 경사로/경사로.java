import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;

    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
//            System.out.println("==================");
//            System.out.println("row : " + (i + 1));
            check(i, true);
        }

        for(int i = 0; i < N; i++){
//            System.out.println("==================");
//            System.out.println("col : " + (i + 1));
            check(i, false);
        }

        System.out.println(result);
        br.close();
    }

    static void check(int idx, boolean row){
        boolean[] slope = new boolean[N];
        int[] line = new int[N];
        if(row){
            for(int i = 0; i < N; i++){
                line[i] = map[idx][i];
            }
        }else{
            for(int i = 0; i < N; i++){
                line[i] = map[i][idx];
            }
        }
//        System.out.println(Arrays.toString(line));
        int i = 0;
        while(i < N - 1){
            if(line[i] == line[i + 1] + 1){
                if(i + L > N - 1) return;
                for(int j = i + 2; j <= i + L; j ++){
                    if(line[i + 1] != line[j]){
                        return;
                    }
                }
                for(int j = i + 1; j <= i + L; j++){
                    slope[j] = true;
                }
                i = i + L;
                continue;
            }else if(line[i] - line[i + 1] > 1){
                return;
            }
            i++;
        }
//        System.out.println(Arrays.toString(slope));
        i = N - 1;

        while(i > 0){
            if(line[i] == line[i - 1] + 1){
                if(i - L < 0) return;
                for(int j = i - 2; j >= i - L; j --){
                    if(line[i - 1] != line[j]){
                        return;
                    }
                }
                for(int j = i - 1; j >= i - L; j --){
                    if(slope[j]){
                        return;
                    }
                    slope[j] = true;
                }
                i = i - L;
                continue;
            }else if(line[i] - line[i - 1] > 1){
                return;
            }
            i--;
        }
//        System.out.println("cnt!!");
//        System.out.println(Arrays.toString(slope));

        result ++;
    }
}
