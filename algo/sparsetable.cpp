#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<string, string> pss;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<pii> vii;
typedef vector<ll> vl;
typedef vector<vl> vvl;

const int MM = 2*1e5+1, k = 25;
int n, q;
ll st[MM][k], arr[MM], v;
void build(){
    for(int i = 1; i<=n; i++){
        st[i][0] = arr[i];
    }
    for(int j = 1; j<=k; j++){
        for(int i = 1; i+(1<<j)<=n+1; i++){
            st[i][j] = min(st[i][j-1], st[i+(1<<(j-1))][j-1]);
        }
    }
}
ll query(int l, int r){
    int idx = log2(r-l+1);
    return min(st[l][idx], st[r-(1<<idx)+1][idx]);
}
void solve(){
    cin>>n>>q;
    for(int i = 0; i<n; i++){
        cin>>arr[i];
    }
    build();
    for(int i = 0, a, b; i<q; i++){
        cin>>a>>b;
        query(a-1, b-1);
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    solve();
    return 0;
}
