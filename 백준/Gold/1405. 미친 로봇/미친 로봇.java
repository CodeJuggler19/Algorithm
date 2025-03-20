import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] move = new int[4];
    static boolean[][] map = new boolean[29][29];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++){
            move[i] = Integer.parseInt(st.nextToken());
        }
        map[14][14] = true;
        bt(14, 14, 0, 1);
        System.out.println(result);
        br.close();
    }
    static double result = 0;
    static void bt(int x, int y, int cnt, double probability){
        if(cnt == N){
            result += probability;
            return;
        }

        for(int i = 0; i < 4; i++){
            if(move[i] == 0) continue;
            if(i == 0){
                if(map[x][y + 1]) continue;
                map[x][y + 1] = true;
                bt(x, y + 1, cnt + 1, probability * (double)(move[i]) / 100);
                map[x][y + 1] = false;
            }else if(i == 1){
                if(map[x][y - 1]) continue;
                map[x][y - 1] = true;
                bt(x, y - 1, cnt + 1, probability * (double)(move[i]) / 100);
                map[x][y - 1] = false;
            }else if(i == 2){
                if(map[x - 1][y]) continue;
                map[x - 1][y] = true;
                bt(x - 1, y, cnt + 1, probability * (double)(move[i]) / 100);
                map[x - 1][y] = false;
            }else{
                if(map[x + 1][y]) continue;
                map[x + 1][y] = true;
                bt(x + 1, y, cnt + 1, probability * (double)(move[i]) / 100);
                map[x + 1][y] = false;
            }
        }
    }
}
