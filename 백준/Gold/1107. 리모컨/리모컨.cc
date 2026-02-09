#include<iostream>
#include<string>
#include <cmath>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int curCh = 100;
    int N, M;
    cin >> N >> M;

    bool check[10] = {};

    for(int i = 0; i < M; i++){
        int x; cin >> x;
        check[x] = true;
    }

    int min_val = abs(100 - N);

    for(int i = 0; i < 1000000; i++){
        string numStr = to_string(i);
        bool yn = true;
        for(char num : numStr){
            if(check[num - '0']) {
                yn = false;
                break;
            }
        }

        if(yn){
            int len = numStr.length();
            int diff = abs(N - i);
            min_val = min(min_val, len + diff);
        }
    }
    cout << min_val;
    return 0;
}