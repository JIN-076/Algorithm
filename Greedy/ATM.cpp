#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 1000

int main()
{
    int N;

    cin >> N;

    int withdraw[MAX];
    int time = 0;

    for (int i = 0; i < N; i++)
        cin >> withdraw[i];

    sort(withdraw, withdraw + N);

    for (int i = 0; i < N; i++)
        time += withdraw[i] * (N - i);

    cout << time;
}