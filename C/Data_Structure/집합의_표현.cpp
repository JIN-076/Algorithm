#include <iostream>
using namespace std;

int parent[1000001];

int find(int x)
{
    if (x == parent[x])
        return x;
    else
        return parent[x] = find(parent[x]);
}

void ft_union(int x, int y)
{
    x = find(x);
    y = find(y);
    parent[x] = y;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int M;
    int Operator;
    int A;
    int B;

    cin >> N >> M;

    for (int i = 0; i <= N; i++)
        parent[i] = i;

    for (int i = 0; i < M; i++)
    {
        cin >> Operator >> A >> B;

        if (!Operator)
            ft_union(A, B);
        else
        if (find(A) == find(B))
            cout << "YES\n";
        else
            cout << "NO\n";
    }
    return 0;
}
