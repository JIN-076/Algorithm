#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 100000

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    int N;
    cin >> T;

    while(T--)
    {
        cin >> N;

        pair<int, int> Recruit[MAX];

        for (int i = 0; i < N; i++)
            cin >> Recruit[i].first >> Recruit[i].second;

        sort(Recruit, Recruit + N);

        int cnt = 1;
        int Interview = Recruit[0].second;

        for (int i = 1; i < N; i++)
        {
            if (Recruit[i].second < Interview)
            {
                cnt++;
                Interview = Recruit[i].second;
            }
        }
        cout << cnt << "\n";
    }
    return 0;
}