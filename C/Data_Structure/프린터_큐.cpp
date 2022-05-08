#include <iostream>
#include <queue>
using namespace std;

#define MAX 101

int main()
{
    int T;
    int N;
    int M;
    int Important[MAX];
    int cnt;

    cin >> T;

    queue<pair<int, int>> q;
    priority_queue<int> pq;

    for (int i = 0; i < T; i++)
    {
        cin >> N >> M;
        for (int j = 0; j < N; j++)
        {
            cin >> Important[j];
            q.push( { j, Important[j] } );
            pq.push(Important[j]);
        }

        cnt = 0;

        while (!q.empty())
        {
            int index = q.front().first;
            int value = q.front().second;
            q.pop();
            if (pq.top() == value)
            {
                pq.pop();
                ++cnt;
                if (index == M)
                {
                    cout << cnt << endl;
                    break;
                }
            }
            else
                q.push( { index, value });
        }

        while (!q.empty())
            q.pop();
        while (!pq.empty())
            pq.pop();
    }
}