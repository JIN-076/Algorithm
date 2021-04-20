#include <iostream>
#include <stack>
using namespace std;

#define MAX 100000

int main()
{
    int K;
    int Integer[MAX];
    int Sum = 0;

    cin >> K;

    stack<int> Zero;

    for (int i = 0; i < K; i++)
    {
        cin >> Integer[i];
        if (!Zero.empty() && Integer[i] == 0)
            Zero.pop();
        else
            Zero.push(Integer[i]);
    }

    while (!Zero.empty())
    {
        Sum += Zero.top();
        Zero.pop();
    }

    cout << Sum << endl;
}