import java.io.*;
import java.util.*;

public class Main {
    static class Serial implements Comparable<Serial>{
        int len, sum;
        String alpha;

        public Serial(int len, int sum, String alpha) {
            this.len = len;
            this.sum = sum;
            this.alpha = alpha;
        }

        @Override
        public int compareTo(Serial serial){
            if(this.len == serial.len){
                if(this.sum == serial.sum){
                    return this.alpha.compareTo(serial.alpha);
                }else{
                    return this.sum - serial.sum;
                }
            }else{
                return this.len - serial.len;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Serial[] array = new Serial[N];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            int sum = 0;
            for(char ch : input.toCharArray()){
                if((int)ch >= 48 && (int)ch <= 57){
                    sum += Integer.parseInt(String.valueOf(ch));
                }
            }
            array[i] = new Serial(input.length(), sum, input);
        }

        Arrays.sort(array);
        for(Serial cur : array){
            System.out.println(cur.alpha);
        }
        br.close();
    }
}
