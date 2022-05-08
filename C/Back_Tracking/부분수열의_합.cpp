#include <iostream>
#include <vector>
using namespace std;

#define MAX 20

int Cnt = 0;
int S;
int N;
int Sum;

void pick(vector<int>& picked, int Number[], int N, int toPick)
{
    Sum = 0;
    if (toPick == 0)
    {
        for (int i = 0; i < picked.size(); i++)
            Sum += Number[picked[i]];
        if (Sum == S)
            Cnt++;
        return;
    }
    int Smallest = picked.empty() ? 0 : picked.back() + 1;
    for (int next = Smallest; next < N; next++)
    {
        picked.push_back(next);
        pick(picked, Number, N, toPick - 1);
        picked.pop_back();
    }
}

void Sequential_size(vector<int>& picked, int Number[], int N)
{
    for (int i = 1; i <= N; i++)
        pick(picked, Number, N, i);
}

int main()
{
    int Number[MAX];
    cin >> N >> S;
    for (int i = 0; i < N; i++)
        cin >> Number[i];

    vector<int> picked;

    Sequential_size(picked, Number, N);

    cout << Cnt;
}