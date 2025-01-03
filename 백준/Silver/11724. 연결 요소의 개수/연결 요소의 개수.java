import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    static int N;
    static int M;

    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

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

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                result ++;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer num : list.get(cur)){
                if(!visited[num]){
                    visited[num] = true;
                    q.add(num);
                }
            }
        }

    }
}
