#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int T = 0;
    string str;

    cin >> T;

    for (int i = 0; i < T; i++)
    {
        stack<int> left_side;
        stack<int> right_side;

        cin >> str;

        for (int i = 0; i < str.size(); i++)
        {
            if (str[i] == '(')
                left_side.push(str[i]);
            else {
                right_side.push(str[i]);
                if (left_side.empty())
                    break;
                left_side.pop();
                right_side.pop();
            }
        }
        if (left_side.empty() && right_side.empty())
            cout << "YES\n";
        else if (!left_side.empty() || !right_side.empty())
            cout << "NO\n";
    }
}

