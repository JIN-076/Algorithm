#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 50

int main()
{
    string math;
    string number;
    int sum = 0;
    int num = 0;
    bool minus = false;

    cin >> math;

    vector<int> string_to_int;

    for (int i = 0; i <= math.size(); i++)
    {
        if (math[i] >= '0' && math[i] <= '9')
            number += math[i];
        else if (math[i] == '-' || math[i] == '+' || math[i] == '\0')
        {
            if (!number.empty())
            {
                num = (stoi(number));
                number.clear();
            }
            if (minus)
                sum -= num;
            else
                sum += num;
            if (math[i] == '-')
                minus = true;
        }
    }
    cout << sum;
}
