import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        char[] array = br.readLine().toCharArray();

        int result = 0;
        char before = array[0];
        stack.push(1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(1);
                before = '(';
            } else {
                if (before == '(') {
                    stack.pop();
                    if(!stack.isEmpty()){
                        result += stack.size();
                    }
                } else {
                    stack.pop();
                    result += 1;
                }
                before = ')';
            }
        }

        System.out.println(result);
        br.close();
    }
}
