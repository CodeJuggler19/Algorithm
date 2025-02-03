import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] vis;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(e).add(s);  
        }

        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            vis = new boolean[N + 1];
            depth = 0;
            dfs(i);

            if (max < depth) {
                max = depth;
                result.clear();  
                result.add(i);
            } else if (max == depth) {
                result.add(i);
            }
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }

        br.close();
    }

    static void dfs(int n) {
        vis[n] = true;
        depth++;  

        for (int c : list.get(n)) {
            if (!vis[c]) {
                dfs(c);
            }
        }
    }
}
