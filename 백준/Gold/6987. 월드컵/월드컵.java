import java.util.*;

public class Main {
    static int[][] games = new int[15][2]; // 15개의 경기 쌍
    static int[][] input = new int[4][6 * 3]; // 4가지 입력 결과 (6국가 * 3개 항목)
    static boolean[] answer = new boolean[4];
    static int[] temp = new int[18];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 경기 조합 생성
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                games[idx][0] = i;
                games[idx][1] = j;
                idx++;
            }
        }

        // 입력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 18; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        // 4개의 케이스 확인
        for (int t = 0; t < 4; t++) {
            int[][] board = new int[6][3];
            for (int i = 0; i < 6; i++) {
                board[i][0] = input[t][i * 3];     // 승
                board[i][1] = input[t][i * 3 + 1]; // 무
                board[i][2] = input[t][i * 3 + 2]; // 패
            }
            answer[t] = dfs(0, board);
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(answer[i] ? "1 " : "0 ");
        }
    }

    static boolean dfs(int depth, int[][] board) {
        if (depth == 15) {
            // 모든 경기를 다 체크했을 때, 모든 값이 0이어야 유효한 결과
            for (int i = 0; i < 6; i++) {
                if (board[i][0] != 0 || board[i][1] != 0 || board[i][2] != 0)
                    return false;
            }
            return true;
        }

        int a = games[depth][0];
        int b = games[depth][1];

        // a 승, b 패
        if (board[a][0] > 0 && board[b][2] > 0) {
            board[a][0]--;
            board[b][2]--;
            if (dfs(depth + 1, board)) return true;
            board[a][0]++;
            board[b][2]++;
        }

        // a 무, b 무
        if (board[a][1] > 0 && board[b][1] > 0) {
            board[a][1]--;
            board[b][1]--;
            if (dfs(depth + 1, board)) return true;
            board[a][1]++;
            board[b][1]++;
        }

        // a 패, b 승
        if (board[a][2] > 0 && board[b][0] > 0) {
            board[a][2]--;
            board[b][0]--;
            if (dfs(depth + 1, board)) return true;
            board[a][2]++;
            board[b][0]++;
        }

        return false;
    }
}
