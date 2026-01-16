import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();
        char[] words = new char[inputs.length + 2];
        for(int i = 0; i < inputs.length; i++){
            words[i] = inputs[i];
        }
        int cur = 0;
        int result = 0;
        while(cur < inputs.length){
            if(words[cur] == 'c'){
                if(words[cur + 1] == '=' || words[cur + 1] == '-'){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else if(words[cur] == 'd'){
                if(words[cur + 1] == 'z'){
                    if(words[cur + 2] == '='){
                        result ++;
                        cur += 3;
                    }else{
                        result += 2;
                        cur += 2;
                    }
                }else if(words[cur + 1] == '-'){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else if(words[cur] == 'l'){
                if(words[cur + 1] == 'j'){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else if(words[cur] == 'n'){
                if(words[cur + 1] == 'j'){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else if(words[cur] == 's'){
                if(words[cur + 1] == '='){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else if(words[cur] == 'z'){
                if(words[cur + 1] == '='){
                    result ++;
                    cur += 2;
                }else{
                    result ++;
                    cur ++;
                }
            }else{
                result ++;
                cur ++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
