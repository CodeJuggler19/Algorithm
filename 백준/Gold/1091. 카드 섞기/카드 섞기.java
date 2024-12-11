import java.io.*;
import java.util.*;

public class Main {
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st_2;
        st = new StringTokenizer(br.readLine());
        st_2 = new StringTokenizer(br.readLine());

        int[] P = new int[N];
        S = new int[N];

        List<Set<Integer>> pCard = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pCard.add(new HashSet<>());
        }

        int[] card = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            pCard.get(P[i]).add(i);
            S[i] = Integer.parseInt(st_2.nextToken());
            card[i] = i;
        }
        int cnt = 0;

        Set<String> seen = new HashSet<>();

        while (true) {
            boolean check = true;
            for (int i = 0; i < 3; i++) {
                Set<Integer> temp = pCard.get(i);
                for (int j = 0; i + j * 3 < N; j++) {
                    if (!temp.contains(card[i + j * 3])) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                break;
            } else {
                String cardState = Arrays.toString(card);
                if (seen.contains(cardState)) {
                    bw.write(-1 + "\n");
                    bw.flush();
                    return;
                }
                seen.add(cardState);

                card = swap(card);
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] swap(int[] card) {
        int[] result = new int[card.length];
        for (int i = 0; i < card.length; i++) {
            result[S[i]] = card[i];
        }
        return result;
    }
}
