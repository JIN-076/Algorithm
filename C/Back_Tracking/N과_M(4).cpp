#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;

#define MAX 8

int N;
int M;
vector<int> N_M;
bool flag[MAX];
int arr[MAX];

void print()
{
    for (int i = 0; i < N_M.size(); i++)
        printf("%d ", N_M[i]);
    printf("\n");
}

void dfs(int cnt)
{
    if (cnt == M)
    {
        print();
        return;
    }

    for (int i = 0; i < N; i++)
    {
        if (!N_M.empty() && arr[i] < N_M.back())
            continue;
        flag[i] = true;
        N_M.push_back(arr[i]);
        dfs(cnt + 1);
        N_M.pop_back();
        flag[i] = false;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++)
        arr[i] = i + 1;

    for (int i = 0; i < N; i++)
        flag[i] = false;

    dfs(0);
}