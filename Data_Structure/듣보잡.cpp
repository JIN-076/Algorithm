#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    int M;
    vector<string> not_hear;
    vector<string> not_hear_see;
    string not_see;

    cin >> N >> M;

    not_hear.resize(N);
    for (int i = 0; i < N; i++)
        cin >> not_hear[i];

    sort(not_hear.begin(), not_hear.end());

    for (int i = 0; i < M; i++) {
        cin >> not_see;

        if (binary_search(not_hear.begin(), not_hear.end(), not_see))
            not_hear_see.push_back(not_see);
    }

    sort(not_hear_see.begin(), not_hear_see.end());

    cout << not_hear_see.size() << endl;

    for (auto & i : not_hear_see) {
        cout << i.c_str() << endl;
    }
    return 0;
}