#include <iostream>
using namespace std;

int main()
{
    int N;
    cin >> N;

    int bag = 0;

    if (N >= 3 && N <= 5000)
    {
        if (N % 5 == 0)
            cout << N / 5;
        else
        {
            bag = N / 5;
            do {
                if ((N - (5 * bag)) % 3 == 0)
                {
                    cout << bag + (N - 5 * bag) / 3;
                    break;
                }
                bag--;
            } while (bag >= 0);

            if (bag == -1)
                cout << -1;
        }
    }
    return 0;
}