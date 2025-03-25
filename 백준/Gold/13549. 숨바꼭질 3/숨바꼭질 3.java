import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num, depth;

        Node(int num, int depth){
            this.num = num;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node node){
            return this.depth - node.depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] vis = new boolean[100001];

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            vis[cur.num] = true;
            if(cur.num == K){
                System.out.println(cur.depth);
                break;
            }
            if(cur.num - 1 >= 0 && !vis[cur.num - 1]){
                q.add(new Node(cur.num - 1, cur.depth + 1));
            }

            if(cur.num + 1 <= 100000 && !vis[cur.num + 1]){
                q.add(new Node(cur.num + 1, cur.depth + 1));
            }

            if(cur.num * 2 <= 100000 && !vis[cur.num * 2]){
                q.add(new Node(cur.num * 2, cur.depth));
            }
        }

        br.close();
    }
}
