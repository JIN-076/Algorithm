#include <iostream>
#include <vector>
using namespace std;

#define MAX 12

bool Matching[MAX] = { 0, };

void Pick(vector<int>& S, vector<int>& Lotto, int Idx, int Cnt, int K)
{
    if (Cnt == 6) {
        for (int j = 0; j < Lotto.size(); j++)
            cout << Lotto[j] << " ";
        cout << endl;
        return;
    }
    for (int i = Idx; i < K; i++)
    {
        if (Matching[i])
            continue;
        else
        {
            Matching[i] = true;
            Lotto.push_back(S[i]);
            Pick(S, Lotto, i, Cnt + 1, K);
            Lotto.pop_back();
            Matching[i] = false;
        }
    }
}

int main()
{
    int K;

    while(true)
    {
        cin >> K;

        if (K == 0)
            break;
        vector<int> S (K, false);
        vector<int> Lotto;

        for (int i = 0; i < K; i++)
            cin >> S[i];

        Pick(S, Lotto, 0, 0, K);
        cout << endl;
    }

}