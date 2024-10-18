import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt(); // r행
        int c = sc.nextInt(); // c열
        int t = sc.nextInt(); // t초

        int[][] arr = new int[r][c];
        List<int[]> airc = new ArrayList<>(); // 청정기 위치 저장

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    airc.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        while (t-- > 0) {
            int[][] check = new int[r][c];

            // 확산 상태를 미리 기록
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] != -1 && arr[i][j] != 0) {
                        check[i][j] = arr[i][j];
                    }
                }
            }

            // 확산
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != -1 && check[i][j] != 0) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < r && ny >= 0 && ny < c && arr[nx][ny] != -1) {
                                arr[nx][ny] = arr[nx][ny] + check[i][j] / 5;
                                arr[i][j] = arr[i][j] - (check[i][j] / 5);
                            }
                        }
                    }
                }
            }

            // 위쪽 공기청정기 작동 (반시계 방향)
            int aircx = airc.get(0)[0];
            for (int i = aircx - 2; i >= 0; i--) { // 아래로
                arr[i + 1][0] = arr[i][0];
            }
            for (int i = 1; i < c; i++) { // 왼쪽으로
                arr[0][i - 1] = arr[0][i];
            }
            for (int i = 1; i <= aircx; i++) { // 위로
                arr[i - 1][c - 1] = arr[i][c - 1];
            }
            for (int i = c - 2; i >= 1; i--) { // 오른쪽으로
                arr[aircx][i + 1] = arr[aircx][i];
            }
            arr[aircx][1] = 0;

            // 아래쪽 공기청정기 작동 (시계 방향)
            int aircx2 = airc.get(1)[0];
            for (int i = aircx2 + 2; i < r; i++) { // 위로
                arr[i - 1][0] = arr[i][0];
            }
            for (int i = 1; i < c; i++) { // 왼쪽으로
                arr[r - 1][i - 1] = arr[r - 1][i];
            }
            for (int i = r - 2; i >= aircx2; i--) { // 아래로
                arr[i + 1][c - 1] = arr[i][c - 1];
            }
            for (int i = c - 2; i >= 1; i--) { // 오른쪽으로
                arr[aircx2][i + 1] = arr[aircx2][i];
            }
            arr[aircx2][1] = 0;
        }

        // 남은 먼지 합 계산
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != -1) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
