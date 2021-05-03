#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 100000

bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

int main()
{
    int N;
    int start[MAX];
    int end[MAX];
    int cnt = 0;
    vector<pair<int, int>> meeting_room;

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> start[i] >> end[i];
        meeting_room.emplace_back(start[i], end[i]);
    }

    sort(meeting_room.begin(), meeting_room.end(), cmp);

    int fast = 0;

    for (auto & i : meeting_room)
    {

        if (fast <= i.first)
        {
            fast = i.second;
            cnt++;
        }
    }
    cout << cnt;

    return 0;
}
