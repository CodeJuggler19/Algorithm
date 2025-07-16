import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, T;
    static int result;
    static List<List<Integer>> line = new ArrayList<>();
    static List<Map<Integer, Node>> transfer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            line.add(new ArrayList<>());
            transfer.add(new HashMap<>());
            if (i == 0) continue;
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= cnt; j++) {
                line.get(i).add(j);
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sLine = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            int eLine = Integer.parseInt(st.nextToken());
            int eNum = Integer.parseInt(st.nextToken());
            transfer.get(sLine).put(sNum, new Node(eLine, eNum));
            transfer.get(eLine).put(eNum, new Node(sLine, sNum));
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            result = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            int sLine = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            int eLine = Integer.parseInt(st.nextToken());
            int eNum = Integer.parseInt(st.nextToken());
            find(sLine, sNum, eLine, eNum);
            System.out.println(result);
        }

        br.close();
    }

    static void find(int sLine, int sNum, int eLine, int eNum) {
        List<List<Integer>> cnt = new ArrayList<>();
        List<List<Boolean>> vis = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            cnt.add(new ArrayList<>());
            vis.add(new ArrayList<>());
            if (i == 0) continue;
            for (int j = 0; j <= line.get(i).size(); j++) {
                cnt.get(i).add(Integer.MAX_VALUE);
                vis.get(i).add(false);
            }
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(sLine, sNum, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.line == eLine && cur.num == eNum){
                result = cur.cnt;
                break;
            }

            if(!vis.get(cur.line).get(cur.num)){
                vis.get(cur.line).set(cur.num, true);

                if(cur.num - 1 > 0){
                    if(!vis.get(cur.line).get(cur.num - 1)){
                        if(cur.cnt + 1 < cnt.get(cur.line).get(cur.num - 1)){
                            cnt.get(cur.line).set(cur.num - 1, cur.cnt + 1);
                            q.add(new Node(cur.line, cur.num - 1, cur.cnt + 1));
                        }
                    }
                }

                if(cur.num + 1 <= line.get(cur.line).size() - 1){
                    if(!vis.get(cur.line).get(cur.num + 1)){
                        if(cur.cnt + 1 < cnt.get(cur.line).get(cur.num + 1)) {
                            cnt.get(cur.line).set(cur.num + 1, cur.cnt + 1);
                            q.add(new Node(cur.line, cur.num + 1, cur.cnt + 1));
                        }
                    }
                }

                if(transfer.get(cur.line).containsKey(cur.num)){
                    Node next = transfer.get(cur.line).get(cur.num);
                    if(!vis.get(next.line).get(next.num)){
                        if(cur.cnt + T < cnt.get(next.line).get(next.num)){
                            cnt.get(next.line).set(next.num, cur.cnt + T);
                            q.add(new Node(next.line, next.num, cur.cnt + T));
                        }
                    }
                }
            }
        }


    }

    static class Node implements Comparable<Node>{
        int line;
        int num;
        int cnt;
        Node(int line, int num) {
            this.line = line;
            this.num = num;
        }
        Node(int line, int num, int cnt) {
            this.line = line;
            this.num = num;
            this.cnt = cnt;
        }

        public int compareTo(Node node){
            return this.cnt - node.cnt;
        }
    }
}

