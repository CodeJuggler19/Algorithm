import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] map = new int[r2 - r1 + 1][c2 - c1 + 1];

        int maxNumber = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i - r1][j - c1] = spinalNumber(i, j);
                maxNumber = Math.max(maxNumber, map[i - r1][j - c1]);
            }
        }
        int maxLength = String.valueOf(maxNumber).length() - 1;

        int len;
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                len = maxLength - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int spinalNumber(int x, int y) {
        int depth = Math.max(Math.abs(x), Math.abs(y));

        int startNumber = (2 * depth - 1) * (2 * depth - 1);

        if (x == depth) {
            return startNumber + depth * 7 + y;   //아래
        } else if (y == -depth) {
            return startNumber + depth * 5 + x;   //왼쪽
        } else if (x == -depth) {
            return startNumber + depth * 3 - y;   //위쪽
        }
        return startNumber + depth - x;    //오른쪽
    }
}