import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] inputs;
    static String[] result = new String[2];

    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new String[N];

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
            maxLen = Math.max(maxLen, inputs[i].length());
        }

        for (int i = 1; i <= maxLen; i++) {
            find(i);
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
        br.close();
    }

    static void find(int maxLen) {
        set = new HashSet<>();
        boolean noMoreAdd = false;

        int idx = N - 1;
        for (int i = 0; i < N; i++) {
            String part = inputs[i];
            if (inputs[i].length() > maxLen) part = inputs[i].substring(0, maxLen);

            if (!noMoreAdd) {
                if (!set.contains(part)) {
                    set.add(part);
                    continue;
                }
            }

            if (set.contains(part)) {
                noMoreAdd = true;
                for (int j = 0; j < N; j++) {
                    String check = inputs[j];
                    if (inputs[j].length() > maxLen) check = inputs[j].substring(0, maxLen);

                    if(j >= idx) break;
                    if (check.equals(part)) {
                        result[0] = inputs[j];
                        result[1] = inputs[i];
                        idx = j;
                        break;
                    }
                }
            }

        }
    }


}
