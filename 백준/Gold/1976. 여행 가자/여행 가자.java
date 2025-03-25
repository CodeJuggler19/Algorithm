import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[] parent;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int link = Integer.parseInt(st.nextToken());
                if(link == 1){
                    list.get(i).add(j);
                }
            }
        }
        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int link : list.get(i)){
                union(i, link);
            }
        }
        int basis = parent[travel[0]];
        for(int i = 1; i < M; i++){
            if(parent[travel[i]] != basis){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        br.close();
    }
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y){
                parent[y] = x;
            }else{
                parent[x] = y;
            }
        }
    }
}
