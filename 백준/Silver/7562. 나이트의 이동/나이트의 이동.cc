#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;
int N;
int dx[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dy[8] = {-2, -1, 1, 2, 2, 1, -1, -2};


int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T; cin >> T;

    while(T -- > 0){
        int N; cin >> N;
        vector<vector<bool>> visited(N, vector<bool>(N, false));
        int s[2];
        int e[2];
        cin >> s[0] >> s[1];
        cin >> e[0] >> e[1];
        
        queue<tuple<int, int, int>> q;
        q.push({s[0], s[1], 0});
        
        while(!q.empty()){
            auto[x, y, cost] = q.front(); q.pop();

            if(!visited[x][y]){
                visited[x][y] = true;
                if(e[0] == x && e[1] == y){
                    cout << cost << endl;
                    break;
                }
                for(int i = 0; i < 8; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                        q.push({nx, ny, cost + 1});
                    }
                }
            }
        }
    }
    return 0;
}