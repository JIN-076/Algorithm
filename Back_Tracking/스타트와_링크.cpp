#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

#define INF 987654321;
#define MAX 20

int Min = INF;

void Pick(vector<vector<int>>& S, bool Matching[], int Idx, int Cnt, int N) {
    vector<int> Start;
    vector<int> Link;
    int Start_score = 0;
    int Link_score = 0;
    if (Cnt == N / 2)
    {
        for (int i = 0; i < N; i++) {
            if (Matching[i])
                Start.push_back(i);
            else
                Link.push_back(i);
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                Start_score += S[Start[i]][Start[j]];
                Link_score += S[Link[i]][Link[j]];
            }
        }
        Min = abs(Start_score - Link_score) < Min ? abs(Start_score - Link_score) : Min;
        return;
    }
    for (int i = Idx; i < N; i++)
    {
        if (Matching[i])
            continue;
        else
        {
            Matching[i] = true;
            Pick(S, Matching, i, Cnt + 1, N);
            Matching[i] = false;
        }
    }

}

int main()
{
    int N;
    bool Matching[MAX] = { 0, };

    cin >> N;

    vector<vector<int>> S(N, vector<int> (N, false));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> S[i][j];
        }
    }

    Pick(S, Matching, 0, 0, N);
    cout << Min;
}