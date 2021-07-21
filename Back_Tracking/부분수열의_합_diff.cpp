#include <iostream>
#include <vector>
using namespace std;

#define MAX 20

int N;
int S;
int Number[MAX];
int Cnt = 0;

void DFS(int Idx, int Sum)
{
    if (Idx == N)
        return;
    if (Sum + Number[Idx] == S)
        Cnt++;

    DFS(Idx + 1, Sum);
    DFS(Idx + 1, Sum + Number[Idx]);
}

int main()
{
    cin >> N >> S;
    for (int i = 0; i < N; i++)
        cin >> Number[i];

    DFS(0, 0);

    cout << Cnt;
}