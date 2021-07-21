#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 11

int Max = -1000000000;
int Min = 1000000000;
int N;

void Calculate(int A[], int cnt, int add, int sub, int mul, int div, int sum)
{
    if (cnt == N)
    {
        Max = max(Max, sum);
        Min = min(Min, sum);
    }
    if (add > 0)
        Calculate(A, cnt + 1, add - 1, sub, mul, div, sum + A[cnt]);
    if (sub > 0)
        Calculate(A, cnt + 1, add, sub - 1, mul, div, sum - A[cnt]);
    if (mul > 0)
        Calculate(A, cnt + 1, add, sub, mul - 1, div, sum * A[cnt]);
    if (div > 0)
        Calculate(A, cnt + 1, add, sub, mul, div - 1, sum / A[cnt]);
}

int main()
{
    int A[MAX];
    int add, sub, mul, div;

    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> A[i];
    cin >> add >> sub >> mul >> div;

    Calculate(A, 1, add, sub, mul, div, A[0]);
    cout << Max;
    cout << endl;
    cout << Min;
}