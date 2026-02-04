#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int T;
    cin >> T;

    while(T--){
        string cmd;
        int N;
        string str;

        cin >> cmd >> N >> str;

        deque<int> dq;

        str = str.substr(1, str.length() - 2);

        if(!str.empty()){
            string num = "";
            for(int i = 0; i < str.length(); i++){
                if(str[i] == ','){
                    dq.push_back(stoi(num));
                    num = "";
                }else{
                    num += str[i];
                }
            }
            dq.push_back(stoi(num));
        }
        bool reverse = false;
        bool error = false;

        for(char c: cmd){
            if(c == 'R'){
                reverse = !reverse;
            }else{
                if(dq.empty()){
                    error = true;
                    break;
                }else{
                    if(reverse){
                        dq.pop_back();
                    }else{
                        dq.pop_front();
                    }
                }
            }
        }

        if(error){
            cout<<"error\n";
        }else{
            cout<<"[";

            if(!dq.empty()){
                if(reverse){
                    cout << dq.back();
                    dq.pop_back();
                    while(!dq.empty()){
                        cout <<","<<dq.back();
                        dq.pop_back();
                    }
                }else{
                    cout<<dq.front();
                    dq.pop_front();
                    while(!dq.empty()){
                        cout<<","<<dq.front();
                        dq.pop_front();
                    }
                }
            }
            cout<<"]\n";
        }
    }
    return 0;
}