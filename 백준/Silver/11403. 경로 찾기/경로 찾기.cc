#include<iostream>
#include<vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;

    vector<vector<int>> grid(N + 1, vector<int>(N+ 1));

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> grid[i][j];
        }
    }

    for(int k = 1; k <= N; k++){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(grid[i][k] == 1 && grid[k][j] == 1){
                    grid[i][j] = 1;
                }
            }
        }
    }

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cout << grid[i][j] << " ";
        }
        cout << endl;
    } 
    return 0;
}