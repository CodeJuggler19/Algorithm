import java.util.*;

class Solution {
    static int userCnt, itemCnt;
    
    static Map<Integer, List<Integer>> buyList = new HashMap<>();
    
    static int[] userMaxCost;
    
    static int[] itemList;
    
    static int resultUser = Integer.MIN_VALUE;
    static int resultSum = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        userCnt = users.length;
        itemCnt = emoticons.length;
        
        userMaxCost = new int[userCnt];
        
        for(int i = 0; i < userCnt; i++){
            int discount = users[i][0];
            int maxCost = users[i][1];
            
            if(discount % 10 != 0){
                discount = ((discount / 10) + 1) * 10;
            }
            for(int j = discount; j <= 40; j += 10){
                if(!buyList.containsKey(j)){
                    buyList.put(j, new ArrayList<>());
                }
                buyList.get(j).add(i);
            }
            userMaxCost[i] = maxCost;
        }
        
        itemList = new int[itemCnt];
        for(int i = 0; i < itemCnt; i++){
            itemList[i] = emoticons[i];
        }
        
        bf(0, 0, new ArrayList<>()); 
        
     
        
        int[] answer = {resultUser, resultSum};
        return answer;
    }

    static void bf(int start, int items, List<Integer> discounts){
        if(items == itemCnt){
            cal(discounts);
            return;
        }
        List<Integer> newDiscounts = new ArrayList<>(discounts);
        for(int i = 10; i <= 40; i+= 10){
            newDiscounts.add(i);
            bf(start + 1, items + 1, newDiscounts);
            newDiscounts.remove(newDiscounts.size() - 1);
        }
        
        // for(int i = start; i < itemCnt; i++){
        //     for(int j = 10; j <= 40; j+= 10){
        //         newDiscounts.add(j);
        //         bf(start + 1, items + 1, newDiscounts);
        //         newDiscounts.remove(newDiscounts.size() - 1);
        //     }
        // }
    }
    
    static void cal(List<Integer> discounts){
        int[] userCost = new int[userCnt];
        
        for(int i = 0; i < discounts.size(); i++){
            int price = (itemList[i] / 10) * ((100 - discounts.get(i)) / 10);
            if(buyList.containsKey(discounts.get(i))){
                for(int buyUser : buyList.get(discounts.get(i))){
                    userCost[buyUser] += price;
                }       
            }
        }
        int uCnt = 0;
        int iSum = 0;
        for(int i = 0; i < userCost.length; i++){
            if(userCost[i] >= userMaxCost[i]){
                uCnt ++;
            }else{
                iSum += userCost[i];
            }
        }
        
       
        if(uCnt > resultUser){
            resultUser = uCnt;
            resultSum = iSum;
        }else if(uCnt == resultUser){
            resultSum = Math.max(resultSum, iSum);
        }
    }
}