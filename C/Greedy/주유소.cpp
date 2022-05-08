#include <iostream>
using namespace std;

#define MAX 100001

int main()
{
    int N;
    long long distance[MAX];
    long long Oil[MAX];
    long long min_price;
    long long sum = 0;

    cin >> N;

    for (int i = 1; i < N; i++)
        cin >> distance[i];

    for (int i = 0; i < N; i++)
        cin >> Oil[i];

    sum += distance[1] * Oil[0];

    min_price = Oil[0];

    for (int i = 1; i < N - 1; i++)
    {
        if (Oil[i] > min_price)
            sum += min_price * distance[i + 1];
        else
        {
            min_price = Oil[i];
            sum += min_price * distance[i + 1];
        }
    }
    cout << sum << endl;
}