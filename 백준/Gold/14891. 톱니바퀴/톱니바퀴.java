import java.io.*;
import java.util.*;

public class Main {
    static int[][] wheel = new int[5][9];

    static boolean[][] change = new boolean[5][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 1; j <= 8; j++) {
                wheel[i][j] = Integer.parseInt(String.valueOf(inputs[j - 1]));
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
//        System.out.println();
//        System.out.println();
//        for(int i = 1; i <= 4; i++){
//            for(int j = 1; j <= 8; j++){
//                if(j == 3 || j == 7) System.out.print("'");
//                System.out.print(wheel[i][j] + " ");
//            }
//            System.out.print(" | ");
//        }
//        System.out.println();
        while (K-- > 0) {

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            change[1][1] = (wheel[1][3] != wheel[2][7]);

            change[2][0] = change[1][1];
            change[2][1] = (wheel[2][3] != wheel[3][7]);

            change[3][0] = change[2][1];
            change[3][1] = (wheel[3][3] != wheel[4][7]);

            change[4][0] = change[3][1];
//            System.out.println(num + " " + direction);
//            System.out.println(change[1][1] + " " + change[2][1] + " " + change[3][1]);
            cal(num, direction);
            rotation(num - 1, 1, direction);
            rotation(num + 1, 0, direction);

//            for(int i = 1; i <= 4; i++){
//                for(int j = 1; j <= 8; j++){
//                    if(j == 3 || j == 7) System.out.print("'");
//                    System.out.print(wheel[i][j] + " ");
//                }
//                System.out.print(" | ");
//            }
//            System.out.println();
        }
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if (wheel[i][1] == 1) {
                sum += (int) Math.pow(2, i - 1);
            }
        }
        System.out.println(sum);
        br.close();
    }
    static void rotation(int num, int check, int direction) {
        if(num > 4 || num < 1){
            return;
        }
        if (change[num][check]) {
            if (direction == 1) {
                direction = -1;
            } else {
                direction = 1;
            }
            cal(num, direction);
            if (check == 1) {
                rotation(num - 1, check, direction);
            } else {
                rotation(num + 1, check, direction);
            }
        }
    }

    static void cal(int num, int rotation) {
        int init = 0;
        if (rotation == 1) {
            for (int i = 8; i >= 2; i--) {
                if (i == 8) {
                    init = wheel[num][i];
                }
                wheel[num][i] = wheel[num][i - 1];
            }
            wheel[num][1] = init;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (i == 1) {
                    init = wheel[num][i];
                }
                wheel[num][i] = wheel[num][i + 1];
            }
            wheel[num][8] = init;
        }

    }
}
