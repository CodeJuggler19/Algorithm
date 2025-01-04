import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> rope = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            rope.add(tmp);
        }
        Collections.sort(rope);
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < rope.size(); i++){
            result = Math.max(result, ((N - i) * rope.get(i)));
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
