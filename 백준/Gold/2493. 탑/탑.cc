#include<iostream>
#include<stack>
#include<vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;

    vector<int> input(N);

    for(int i = 0; i < N; i++){
        cin >> input[i];
    }

    stack<int> s;
    vector<int> result(N, 0);

    s.push(0);
    for(int i = 1; i < N; i++){
        while(true){
            if(s.empty()){
                s.push(i);
                break;
            }
            if(input[s.top()] > input[i]){
                result[i] = s.top() + 1;
                s.push(i);
                break;
            }else if(input[s.top()] < input[i]){
                s.pop();
            }
        }
    }

    for(int i = 0; i < N; i++){
        cout << result[i] << " ";
        if(i == N - 1){
            cout << endl;
        }
    }
    
    return 0;
}