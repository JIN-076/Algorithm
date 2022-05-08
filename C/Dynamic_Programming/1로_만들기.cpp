#include <stdio.h>
#include <iostream>
using namespace std;

int min(int a, int b)
{
    return (a > b ? b : a);
}

int solution(int X, int array[])
{
    array[1] = 0;
    for (int i = 2; i <= X; i++)
    {
        array[i] = array[i - 1] + 1;
        if (i % 2 == 0)
            array[i] = min(array[i], array[i / 2] + 1);
        if (i % 3 == 0)
            array[i] = min(array[i], array[i / 3] + 1);
    }
    return (array[X]);
}

int main()
{
    int array[1000000] = {0, };
    int N;

    cin >> N;

    cout << solution(N, array);

    return (0);
}