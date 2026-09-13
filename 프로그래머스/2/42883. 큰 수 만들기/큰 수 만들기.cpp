#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int n = number.length();
    int cnt = k;
    
    vector<bool> deleted(n, false);
    
    for(int i = 0; i < n; i++){
        if (deleted[i]) continue;
        if (cnt == 0) break;
        
        int cur = number[i] - '0';
        for(int j = i + 1; j <= i + cnt && j < n; j++){
            int nxt = number[j] - '0';
            
            if(cur < nxt){
                for(int d = i; d < j; d++){
                    deleted[d] = true;
                }
                
                cnt -= (j - i);
                break;
            }
        }
        
    }
    
    for(int i = 0; i < n; i++){
        if(!deleted[i]) answer += number[i];
    }
    answer.erase(answer.length() - cnt);
    
    return answer;
}