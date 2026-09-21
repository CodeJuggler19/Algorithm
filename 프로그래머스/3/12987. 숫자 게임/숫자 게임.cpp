#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    
    sort(A.begin(), A.end()); 
    sort(B.begin(), B.end()); 
    
    int idx = A.size() - 1;
    
    for(int i = B.size() - 1; i >= 0; i--){
        while(idx >= 0 && B[i] <= A[idx]){
            idx--;
        }
        
        if(idx < 0) break;
        
        answer++;
        idx--;
        
    }
    return answer;
}