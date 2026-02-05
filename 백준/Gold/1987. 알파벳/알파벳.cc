#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<vector<char>> board;
bool visited[26];
int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};
int answer = -1;
int R;
int C;

void dfs(int r, int c, int depth){
    answer = max(answer, depth);

    for(int i = 0; i < 4; i++){
        int nr = r + dr[i];
        int nc = c + dc[i];

        if(nr > 0 && nr <= R && nc > 0 && nc <= C
            && !visited[board[nr][nc] - 'A']){
                visited[board[nr][nc] - 'A'] = true;
                dfs(nr, nc, depth + 1);
                visited[board[nr][nc] - 'A'] = false;
            }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> R >> C;

    board = vector<vector<char>>(R + 1, vector<char>(C + 1));

    for(int r = 1; r <= R; r++){
        string inputs;
        cin >> inputs;
        for(int c = 1; c <= C; c++){
            board[r][c] = inputs[c - 1];
        } 
    }

    visited[board[1][1] - 'A'] = true;

    dfs(1, 1, 1);

    cout << answer << '\n';

    return 0;
}
