#include <iostream>
#include <stdio.h>
#include <vector>
#include <string.h>
using namespace std;

#define MAX 8

void printPicked(vector<int>& picked)
{
    for (int size = 0; size < picked.size(); size++)
        printf("%d ", picked[size]);
    printf("\n");
}

void pick(int N, vector<int>& picked, int toPick)
{
    if (toPick == 0) { printPicked(picked); return; }
    int smallest = picked.empty() ? 1 : picked.back() + 1;
    for (int next = smallest; next <= N; ++next)
    {
        picked.push_back(next);
        pick(N, picked, toPick - 1);
        picked.pop_back();
    }
}

void pickforOrder(int N, vector<int>& picked, int toPick, int flag[])
{
    if (toPick == 0) { printPicked(picked); return; }
    for (int next = 1; next <= N; next++)
    {
        if (flag[next - 1])
            continue;
        picked.push_back(next);
        flag[next - 1] = true;
        pickforOrder(N, picked, toPick - 1, flag);
        picked.pop_back();
        flag[next - 1] = false;
    }
}

int main()
{
    int N;
    int M;

    cin >> N >> M;
    vector<int> picked;
    int flag[MAX] = { 0, };
    bzero(flag, MAX);
    pick(N, picked, M);
    pickforOrder(N, picked, M, flag);
}