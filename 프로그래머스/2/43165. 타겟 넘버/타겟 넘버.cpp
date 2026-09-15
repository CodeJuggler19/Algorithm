#include <string>
#include <vector>
#include <iostream>

using namespace std;


static int s_target, s_idx;
static int cnt = 0;
static vector<int> d{-1, 1};
static vector<int> s_numbers;

void dfs(int idx, int sum){
    if(idx == s_idx){
        if(sum == s_target) cnt ++;
        return;
    }
    
    for(int i = 0; i < 2; i ++){
        dfs(idx + 1, sum + (d[i] * s_numbers[idx]));
    }
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    s_target = target;
    s_idx = numbers.size();
    s_numbers = numbers;
    
    
    dfs(0, 0);
    answer = cnt;
    return answer;
}