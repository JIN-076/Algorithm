#include <iostream>
using namespace std;

int main()
{
    int T;

    int Time[3] = {300, 60, 10};
    int button[3] = {0, 0, 0};

    cin >> T;

    for (int i = 0; i < 3; i++)
    {
        while (T >= Time[i])
        {
            T -= Time[i];
            button[i]++;
        }
    }
    if (T != 0)
        cout << -1 << endl;
    else
    {
        for (int i = 0; i < 3; i++)
        {
            cout << button[i] << " ";
        }
    }
    return 0;
}