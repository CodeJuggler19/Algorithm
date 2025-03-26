import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] ability;

    static boolean[] list;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list = new boolean[N + 1];
        list[1] = true;
        combination(2, 1);

        System.out.println(min);
        br.close();
    }

    static void combination(int start, int cnt) {
        if (cnt == (N / 2)) {
            cal();
            return;
        }

        for (int i = start; i <= N; i++) {
            list[i] = true;
            combination(i + 1, cnt + 1);
            list[i] = false;
        }
    }

    static void cal() {
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (list[i]) {
                start.add(i);
            } else {
                link.add(i);
            }
        }

        int startSum = 0;
//        System.out.println("start");
        for (int i : start) {
            for (int j : start) {
//                System.out.println(i + " " + j + " : " + ability[i][j]);
                startSum += ability[i][j];
            }
        }
        int linkSum = 0;
//        System.out.println("link");
        for (int i : link) {
            for (int j : link) {
//                System.out.println(i + " " + j + " : " + ability[i][j]);
                linkSum += ability[i][j];
            }
        }
//        System.out.println(start);
//        System.out.println(link);
//        System.out.println(startSum);
//        System.out.println(linkSum);
        min = Math.min(min, Math.abs(linkSum - startSum));


    }
}
