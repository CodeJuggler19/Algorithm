import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int s, e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Node node){
            if(this.e == node.e){
                return this.s - node.s;
            }else{
                return this.e - node.e;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int cnt = 0;
        int before = 0;
        for (int i = 0; i < N; i++) {
            Node cur = list.get(i);
            if(cur.s >= before){
                before = cur.e;
                cnt ++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
