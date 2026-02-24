#include<iostream>
#include<vector>
#include<stack>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;

    vector<int> v(N);
    vector<int> result(N, -1);
    stack<int> s;

    
    for(int i = 0; i < N; i++){
        cin >> v[i];
    }

    for(int i = 0; i < N; i++){

        while(!s.empty() && v[s.top()] < v[i]){
            result[s.top()] = v[i];
            s.pop();
        }

        s.push(i);
    }

    for(int i = 0; i < N; i++){
        cout << result[i] << " ";
    }
    cout << endl;
    return 0;
}