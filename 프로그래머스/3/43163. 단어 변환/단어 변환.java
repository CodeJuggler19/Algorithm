import java.util.*;

public class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Set<String> visited = new HashSet<>();
        int answer = 0;

        int wordSize = words[0].length();

        // 큐에 시작 단어와 변환 횟수를 담음
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(begin, 0));
        visited.add(begin);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int count = current.count;

            // 목표 단어에 도달한 경우
            if (word.equals(target)) {
                return count;
            }

            // 단어의 각 문자를 하나씩 바꿔가며 탐색
            for (int i = 0; i < wordSize; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] tempArr = word.toCharArray();
                    tempArr[i] = j;
                    String temp = new String(tempArr);

                    // 바꾼 단어가 words 목록에 있고, 아직 방문하지 않은 경우
                    if (wordSet.contains(temp) && !visited.contains(temp)) {
                        queue.offer(new Pair(temp, count + 1));
                        visited.add(temp);
                    }
                }
            }
        }

        return answer; // target에 도달하지 못한 경우
    }

    // 단어와 변환 횟수를 저장할 클래스
    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}