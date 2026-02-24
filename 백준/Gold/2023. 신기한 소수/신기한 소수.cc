#include<iostream>
#include<cmath>

using namespace std;

int N;
int prime[5] = {1, 3, 5, 7, 9};

bool isPrime(int num){
    for(int i = 2; i <= (int)sqrt(num); i++){
        if(num % i == 0){
            return false;
        }
    }
    return true;
}
void dfs(int num, int digit){
    if(digit == N){
        cout << num << endl;
        return;
    }

    for(int i = 0 ; i < 5; i++){
        int t = num * 10 + prime[i];
        if(isPrime(t)){
            dfs(t, digit + 1);
        }
    }

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    
    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);
    return 0;
}