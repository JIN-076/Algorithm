#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 100000

int main()
{
    int N;
    int W[MAX];


    cin >> N;

    for (int i = 0; i < N; i++)
        cin >> W[i];

    sort(W, W + N);

    int loop = 0;
    int max_weight = 0;
    int answer = 0;

    for (int i = 0; i < N; i++)
    {
        if (loop < W[i])
        {
            loop = W[i];
            max_weight = W[i] * (N - i);
            answer = answer > max_weight ? answer : max_weight;
        }
    }
    cout << answer;
}