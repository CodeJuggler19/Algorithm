import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] inputs = br.readLine().toCharArray();


        int len = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == 'a') {
                len++;
            }
        }

        int start = 0;
        int end = len - 1;

        int bCnt = 0;

        int min = Integer.MAX_VALUE;


        for (int i = 0; i <= end; i++) {
            if (inputs[i] == 'b') {
                bCnt++;
            }
        }
        min = Math.min(min, bCnt);

        while (start < (inputs.length - 1)) {
            if (inputs[start++] == 'b') {
                bCnt--;
            }
            if(end == inputs.length - 1){
                end = 0;
                if(inputs[end] == 'b'){
                    bCnt++;
                }
            }else{
                if (inputs[++end] == 'b') {
                    bCnt++;
                }
            }
            min = Math.min(min, bCnt);
        }
        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
