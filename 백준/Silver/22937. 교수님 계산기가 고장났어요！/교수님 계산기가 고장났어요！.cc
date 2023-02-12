#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef unsigned long long ull;
string s1, s2;
int main() {
	cin.tie(0)->sync_with_stdio(0);

	cout.precision(18);

	int t;
	cin >> t;
	while (t--) {
		bool flag1 = false, flag2 = false;
		cin >> s1 >> s2;
		string s3, s4;
		if (s1[0] == '-') {
			s3 = s1.substr(1, 1) + s1.substr(3);
			flag1 = true;
		}
		else
			s3 = s1.substr(0, 1) + s1.substr(2);
		if (s2[0] == '-') {
			s4 = s2.substr(1, 1) + s2.substr(3);
			flag2 = true;
		}
		else
			s4 = s2.substr(0, 1) + s2.substr(2);
		ull n1 = stoull(s3);
		ull n2 = stoull(s4);
		ull ans = n1 * n2;
		string res = to_string(ans);
		if (flag1 ^ flag2)
			cout << "-";
		if (res.size() <= 18) {
			cout << "0";
		}
		else {
			for (int i = 0; i < res.size() - 18; i++)
				cout << res[i];
		}
		cout << ".";
		if (res.size() <= 18) {
			for (int i = 0; i < 18 - res.size(); i++)
				cout << "0";
			for (int i = 0; i < res.size(); i++)
				cout << res[i];
		}
		else {
			for (int i = res.size() - 18; i < res.size(); i++)
				cout << res[i];
		}
		cout << "\n";
	}
}