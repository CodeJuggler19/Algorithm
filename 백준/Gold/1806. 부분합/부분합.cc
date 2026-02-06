#include <iostream>
#include <vector>
#include <deque>
#include <limits>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, S;
    
    cin >> N >> S;

    vector<int> arr(N);
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    
    deque<int> q;

    int sum = 0; 
    int len = numeric_limits<int>::max();

    for(int i = 0; i < N; i++){
        sum += arr[i];
        q.push_back(arr[i]);

        while(sum >= S){
            if(len > q.size()){
                len = q.size();
            }

            if(sum - q.front() < S) break;

            sum -= q.front();
            q.pop_front();
        }
    }
    if(len == numeric_limits<int>::max()) {
        cout << 0 << '\n';
    }else {
        cout << len << '\n';
    }

    
    return 0;
}