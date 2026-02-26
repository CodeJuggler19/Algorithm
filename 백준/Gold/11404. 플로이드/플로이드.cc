#include<iostream>
#include<queue>
#include<vector>

using namespace std; 

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N; int M;
    cin >> N; cin >> M;

    vector<vector<pair<int, int>>> list(N + 1);

    for(int i = 0; i < M; i++){
        int s, e, cost;
        cin >> s >> e >> cost;

        list[s].push_back({e, cost});
    }

    for(int i = 1; i <= N; i++){
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        vector<int> cost_list(N + 1, 1e9);
        vector<bool> visited(N + 1);

        pq.push({0, i});
        cost_list[i] = 0;

        while(!pq.empty()){
            auto[cost, node] = pq.top(); pq.pop();

            if(!visited[node]){
                visited[node] = true;

                for(auto[n_node, n_cost] : list[node]){
                    if(!visited[n_node]){
                        if(cost_list[n_node] > cost_list[node] + n_cost){
                            cost_list[n_node] = cost_list[node] + n_cost;
                        }
                        pq.push({cost_list[n_node], n_node});
                    }
                }
            }

        }

        for(int i = 1; i <= N; i++){
            cout << (cost_list[i] == 1e9 ? 0 : cost_list[i]) << " ";
            if(i == N ) cout << endl;
        }
    }

    

    return 0;
}