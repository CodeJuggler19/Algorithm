import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visited = new boolean[N + 1];
            cnt = -1;

            for(int i = 0; i <= N; i++){
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                list.get(s).add(e);
                list.get(e).add(s);
            }

            dfs(1);
            System.out.println(cnt);
        }
        br.close();
    }

    public static void dfs(int cur){
        cnt++;
        visited[cur] = true;
        for(int next : list.get(cur)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

}
