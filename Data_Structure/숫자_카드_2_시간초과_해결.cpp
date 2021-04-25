#include <iostream>
#include <map>
using namespace std;

#define MAX 500000
int cnt[20000001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int M;
    int card[MAX];
    int How_much_of_card[MAX];

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> card[i];
        cnt[10000000 + card[i]]++;
    }

    cin >> M;

    for (int i = 0; i < M; i++) {
        cin >> How_much_of_card[i];
        cout << cnt[10000000 + How_much_of_card[i]] << " ";
    }
}