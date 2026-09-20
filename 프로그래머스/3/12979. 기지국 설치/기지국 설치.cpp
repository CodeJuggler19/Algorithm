#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int solution(int n, vector<int> stations, int w){
    int answer = 0;
    int cover = 2 * w + 1;
    int start = 1;
    
    for(int i = 0; i < stations.size(); i++){
        int left = stations[i] - w;
        
        if(left > start){
            int gap = left - start;
            
            answer += (gap + cover - 1) / cover;
        }
        
        start = max(start, stations[i] + w + 1);        
    }
    
    if(start <= n){
        int gap = n - start + 1;
        answer += (gap + cover - 1) / cover;
    }

    
    return answer;
}