import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];
        int[] completionTime = new int[n + 1];  // 각 작업의 완료 시간을 추적할 배열
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int parent = Integer.parseInt(st.nextToken());
                graph.get(parent).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
                completionTime[i] = time[i];  // 초기 작업 완료 시간 설정
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (Integer next : graph.get(current)) {
                degree[next]--;
                completionTime[next] = Math.max(completionTime[next], completionTime[current] + time[next]);
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, completionTime[i]);
        }

        System.out.println(answer);
    }
}
