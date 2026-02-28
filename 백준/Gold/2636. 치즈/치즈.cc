#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int X, Y; cin >> X >> Y;

    vector<vector<int>> grid(X, vector<int>(Y));

    int T = 0;
    int left = 0;

    for(int i = 0; i < X; i++){
        for(int j = 0; j < Y; j++){
            cin >> grid[i][j];
            if(grid[i][j] == 1) left ++;
        }   
    }

    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    int result = 0;
    while(left > 0){
        result = left;
        vector<vector<bool>> visited(X, vector<bool>(Y));

        queue<pair<int, int>> q;

        visited[0][0] = true;
        q.push({0, 0});

        while(!q.empty()){
            auto[x, y] = q.front(); q.pop();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < X && ny >= 0 && ny < Y && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(grid[nx][ny] == 1){
                        grid[nx][ny] = 0; left --;
                    }else{
                        q.push({nx, ny});
                    }
                }
            }
        }

        T++;
    }

    cout << T << endl;
    cout << result << endl;

    return 0;
}