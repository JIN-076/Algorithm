#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 1000000

int main()
{
    int N;
    int K;

    int value[MAX];
    int cnt = 0;

    cin >> N >> K;

    for (int i = 0; i < N; i++)
        cin >> value[i];

    sort(value, value + N, greater<int>());

    for (int i = 0; i < N; i++)
    {
        while (K >= value[i])
        {
            K -= value[i];
            cnt++;
        }
    }
    cout << cnt << endl;
}