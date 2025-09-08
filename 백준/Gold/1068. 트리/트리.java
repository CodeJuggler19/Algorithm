import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int delete;
    static List<List<Integer>> link;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[N];
        link = new ArrayList<>();
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
            link.add(new ArrayList<>());
        }

        int root = 0;
        for(int i = 0; i < N; i++){
            if(inputs[i] == -1){
                root = i;
                continue;
            }
            link.get(inputs[i]).add(i);
        }

        delete = Integer.parseInt(br.readLine());

        if(delete == root){
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(result);
        }

        br.close();
    }

    static void dfs(int cur){
        boolean isLeaf = true;
        for(Integer next : link.get(cur)){
            if(next == delete) continue;
            isLeaf = false;
            dfs(next);
        }
        if(isLeaf) result++;
    }


}
