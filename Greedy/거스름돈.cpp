#include <iostream>
using namespace std;

int main()
{
    int N;

    cin >> N;

    int coin[6] = {500, 100, 50, 10, 5, 1};

    int change = 1000 - N;
    int cnt = 0;

    for (int i : coin)
    {
        while (change >= i)
        {
            change -= i;
            cnt++;
        }
    }
    cout << cnt;

    return 0;
}