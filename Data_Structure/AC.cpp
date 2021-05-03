#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    int n;

    string ftn;
    string sequence;
    string number;

    deque<int> output;

    cin >> T;

    while (T--)
    {
        cin >> ftn;
        cin >> n;
        cin >> sequence;
        for (char i : sequence) {
            if (i == '[')
                continue;
            else if ('0' <= i && i <= '9')
                number += i;
            else if (i == ',' || i == ']') {
                if (!number.empty()) {
                    output.push_back(stoi(number));
                    number.clear();
                }
            }
        }

        bool error = false;
        bool reverse = false;

        for (char i : ftn)
        {
            if (i == 'R')
                reverse = !reverse;
            else
            {
                if (output.empty())
                {
                    error = true;
                    cout << "error\n";
                    break;
                }
                else
                if (reverse)
                    output.pop_back();
                else
                    output.pop_front();
            }
        }

        if (!error)
        {
            if (reverse)
            {
                cout << "[";
                while (!output.empty())
                {
                    cout << output.back();
                    output.pop_back();
                    if (!output.empty())
                        cout << ",";
                }
                cout << "]\n";
            }
            else
            {
                cout << "[";
                while (!output.empty())
                {
                    cout << output.front();
                    output.pop_front();
                    if (!output.empty())
                        cout << ",";
                }
                cout << "]\n";
            }
        }
    }
    return 0;
}