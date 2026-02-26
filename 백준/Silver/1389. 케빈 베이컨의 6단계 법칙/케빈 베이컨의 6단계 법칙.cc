#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, M; cin >> N >> M;

    vector<vector<int>> dist(N + 1, vector<int>(N + 1, 1e9));

    for(int i = 1; i <= N; i++){
        dist[i][i] = 0;
    }

    for(int i = 1; i <= M; i++){
        int s, e; cin >> s >> e;

        dist[s][e] = min(dist[s][e], 1);
        dist[e][s] = min(dist[e][s], 1);
    }

    for(int k = 1; k <= N; k++){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }

    int min = 1e9;
    int result = 0;
    for(int i = 1; i <= N; i++){
        int sum = 0;
        for(int j = 1; j <= N; j++){
            sum += dist[i][j];
        }
        if(min > sum){
            result = i;
            min = sum;
        }
    }

    cout << result << endl;

    return 0;
}