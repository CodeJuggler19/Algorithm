import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static int pSum = 0;
    static List<List<Integer>> link = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        link.add(new ArrayList<>());
        for(int i = 1; i <= N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            pSum += people[i];
            link.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                link.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 1; i <= (N / 2); i++){
            combination(1, i);
        }
        int result = (min == Integer.MAX_VALUE )? -1 : min;
        System.out.println(result);
        br.close();
    }

    static Set<Integer> candidate = new HashSet<>();
    static void combination(int start, int n){
        if(candidate.size() == n) {
            check();
            return;
        }

        for(int i = start; i <= N; i++){
            candidate.add(i);
            combination(i + 1, n);
            candidate.remove(i);
        }
    }
    static boolean[] vis;
    static Set<Integer> copy;
    static void check(){
        vis = new boolean[N + 1];

        copy = new HashSet<>();

        int sum = 0;
        for(int node : candidate){
            copy.add(node);
            vis[node] = true;
            sum += people[node];
        }

        if(!bfs(copy.size())){
            return;
        }

        for(int i = 1; i <= N; i++){
            if(copy.contains(i)){
                copy.remove(i);
            }else{
                copy.add(i);
            }
        }

        for(int node : copy){
            vis[node] = true;
        }

        if(!bfs(copy.size())){
            return;
        }
        min = Math.min(min, Math.abs(pSum - sum * 2));
    }

    static boolean bfs(int cnt){
        int cal = 0;
        Queue<Integer> q = new LinkedList<>();

        int start = 0;
        for(int node : copy){
            start = node;
            break;
        }
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(!vis[cur]) continue;
            vis[cur] = false;
            cal ++;

            for(Integer next : link.get(cur)){
                if(vis[next]){
                    q.add(next);
                }
            }
        }

        return cnt == cal;
    }
}
