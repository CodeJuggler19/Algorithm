#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

typedef pair<int, int> pp;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;

    vector<pp> v(N);

    for(int i = 0; i < N; i++){
        cin >> v[i].first >> v[i].second;
    }

    sort(v.begin(), v.end(), [](pp a, pp b){
        if(a.first != b.first) return a.first < b.first;
        return a.second < b.second;
    });

    for (auto [x, y] : v) {
        cout << x << " " << y << '\n';
    }

    return 0;
}

