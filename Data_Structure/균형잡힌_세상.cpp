#include <iostream>
#include <stack>
using namespace std;

int main()
{
    string str;

    stack<char> bracket;

    while (true)
    {
        getline(cin, str);
        bool flag = true;
        if (str.length() == 1 && str[0] == '.')
            break;
        for (char & i : str)
        {
            if (i == '(')
                bracket.push(i);
            else if (i == '[')
                bracket.push(i);
            else if (i == ')')
            {
                if (!bracket.empty() && bracket.top() == '(')
                    bracket.pop();
                else
                {
                    flag = false;
                    break;
                }
            }
            else if (i == ']')
            {
                if (!bracket.empty() && bracket.top() == '[')
                    bracket.pop();
                else
                {
                    flag = false;
                    break;
                }
            }
            else
                continue;
        }
        if (flag && bracket.empty())
            cout << "yes\n";
        else
        {
            while (!bracket.empty())
                bracket.pop();
            cout << "no\n";
        }
    }
    return 0;
}