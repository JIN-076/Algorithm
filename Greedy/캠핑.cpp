#include <iostream>
using namespace std;

int main()
{
    int L;
    int P;
    int V;

    int test_case = 1;

    while (true)
    {
        cin >> L >> P >> V;

        int Camping = 0;
        int mod = 0;

        if (L == 0 && P == 0 && V == 0)
            break;

        mod = V % P;

        if (mod <= L)
            Camping += (V / P) * L + mod;
        else
        {
            Camping += (V / P) * L + L;
        }

        cout << "Case " << test_case++ << ": " << Camping << endl;
    }
}