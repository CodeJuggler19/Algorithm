import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = modularExponentiation(A, B, C);  // 모듈러 지수법 함수 호출
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    // 모듈러 지수법 (Modular Exponentiation)
    public static long modularExponentiation(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;  // A % C를 먼저 계산

        while (exp > 0) {
            // 지수(exp)가 홀수일 때는 결과에 base를 곱해줌
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            // 지수를 반으로 나누고 base는 제곱
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
