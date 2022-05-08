#include <iostream>
#include <math.h>
using namespace std;

#define MAX 15

int cnt = 0;

bool IsValid(int Queen[], int Row, int Col)
{
    for (int i = 1; i < Row; i++)
        if (Col == Queen[i] || abs(Row - i) == abs(Col - Queen[i]))
            return false;
    return true;
}

void Put(int Queen[], int Row, int N)
{
    if (Row > N)
        cnt++;
    else
    {
        for (int i = 1; i <= N; i++)
        {
            if (IsValid(Queen, Row, i) == 1)
            {
                Queen[Row] = i;
                Put(Queen, Row + 1, N);
                Queen[Row] = 0;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int Queen[MAX] = { 0, };

    cin >> N;
    Put(Queen, 1, N);

    cout << cnt;
}