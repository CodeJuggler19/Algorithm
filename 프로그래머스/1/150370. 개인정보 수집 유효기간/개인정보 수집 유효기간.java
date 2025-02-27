import java.util.*;

class Solution {
    // 날짜를 일수로 변환하는 메서드
    public int dateToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.valueOf(parts[0]);
        int month = Integer.valueOf(parts[1]);
        int day = Integer.valueOf(parts[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관 종류별 유효기간 저장
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termsMap.put(parts[0], Integer.valueOf(parts[1]));
        }
        
        int todayDays = dateToDays(today);
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String type = parts[1];
            
            int startDateDays = dateToDays(date);
            int termMonths = termsMap.get(type);
            int expireDateDays = startDateDays + termMonths * 28 - 1;
            
            if (todayDays > expireDateDays) {
                result.add(i + 1);
            }
        }
        
      int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
