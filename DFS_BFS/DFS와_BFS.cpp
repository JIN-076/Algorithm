#include <iostream>
#include <queue>
using namespace std;

#define MAX 1001

void DFS(int start, int Mat[], int Visit[])
{
    Visit[start] = true;
    for (int i = 0; i <= N; i++)
    {
        if (Visit[i] == true || Mat[start][i] == false)
            continue;
        DFS(i, Mat, Visit);
    }
}

void BFS(int start, int Mat[], int Visit[])
{
    queue<int> q;
    q.push(start);
    Visit[start] = false;

    while (!q.empty())
    {
        start = q.front();
        q.pop();
        for (int i = 1; i <= N; i++)
        {
            if (Visit[i] == false || Mat[start][i] == false)
                continue;
            q.push(i);
            Visit[i] = false;
        }
    }
}

int main()
{
    int N;
    int M;
    int V;
    int Mat[MAX][MAX];
    int Visit[MAX];
    cin >> N >> M >> V;

    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        Mat[a][b] = Mat[b][a] = 1;
    }

    DFS(V);
    cout << endl;
    BFS(V);

    return (0);
}//
// Created by 홍지인 on 2021/06/30.
//

