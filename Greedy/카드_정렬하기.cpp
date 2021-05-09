#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

#define MAX 100000

int main()
{
    int N;
    long long card_size[MAX];
    long long sum[MAX];
    long long answer = 0;

    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> card_size[i];
        pq.push(card_size[i]);
    }

    for (int i = 0; i < N - 1; i++)
    {
        int a = pq.top();
        pq.pop();
        int b = pq.top();
        pq.pop();
        sum[i] = a + b;
        pq.push(sum[i]);
    }

    for (int i = 0; i < N - 1; i++)
        answer += sum[i];

    cout << answer << endl;
}