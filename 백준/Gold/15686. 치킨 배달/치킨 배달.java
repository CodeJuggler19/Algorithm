import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Node> houses = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) houses.add(new Node(r, c));
                if (map[r][c] == 2) chickens.add(new Node(r, c));
            }
        }
        select(new ArrayList<>(), 0);
        System.out.println(result);

        br.close();
    }

    static void select(List<Node> list, int s) {
        if (list.size() == M) {
            cal(list);
            return;
        }

        for (int i = s; i < chickens.size(); i++) {
            list.add(chickens.get(i));
            select(list, i + 1);
            list.remove(chickens.get(i));
        }

    }

    static void cal(List<Node> selected) {
        int sum = 0;

        for (Node house : houses) {
            int min = Integer.MAX_VALUE;
            for (Node cur : selected) {
                min = Math.min(min, (Math.abs(house.r - cur.r) + Math.abs(house.c - cur.c)));
            }
            sum += min;
        }
        result = Math.min(result, sum);
    }
}
