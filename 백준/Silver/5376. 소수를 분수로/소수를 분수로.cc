#include<iostream>
#include<string>
#include<cmath>

using namespace std;

long long int t, idx, g, up, down;
string s;


long long int GCD(long long int n, long long int m) {
    if (m == 0)return n;
    return GCD(m, n % m);
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> s;
        s = s.substr(2);
        idx = s.find('(');
        if (idx == -1) {
            up = stoll(s);
            down = (long long int) pow(10, s.length());
        } else {
            string a = "", b = "";
            for (int i = 0; i < idx; i++) {
                a.push_back(s[i]);
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (i == idx)
                    continue;
                b.push_back(s[i]);
            }
            (a == "") ? up = stoll(b) : up = stoll(b) - stoll(a);
            down = (long long int) pow(10, b.length()) - (long long int) pow(10, a.length());
        }
        g = GCD(up, down);
        up /= g;
        down /= g;
        cout << up << "/" << down << "\n";
    }
}