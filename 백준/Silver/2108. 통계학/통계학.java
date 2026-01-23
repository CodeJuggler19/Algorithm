import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int[] positive = new int[4001]; // 0은 여기서 카운트
        int[] negative = new int[4001];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;

            if(num >= 0)positive[num]++;
            else negative[num * (-1)]++;

            list.add(num);
        }

        int max = positive[0];
        for(int i = 1; i <= 4000; i++){
            max = Math.max(positive[i], max);
            max = Math.max(negative[i], max);
        }

        List<Integer> maxList = new ArrayList<>();
        if(max == positive[0]) maxList.add(0);
        for(int i = 1; i <= 4000; i++){
            if(positive[i] == max){
                maxList.add(i);
            }
            if(negative[i] == max){
                maxList.add(i * (-1));
            }
        }

        Collections.sort(list);
        System.out.println(Math.round(sum / N));
        System.out.println(list.get((N - 1) / 2));
        Collections.sort(maxList);
        if(maxList.size() > 1){
            System.out.println(maxList.get(1));
        }else{
            System.out.println(maxList.get(0));
        }

        System.out.println(list.get(N - 1) - list.get(0));
        br.close();
    }
}
