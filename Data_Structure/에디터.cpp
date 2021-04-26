#include <iostream>
#include <stack>
using namespace std;

int main()
{
    string str;
    char str_;
    int M;
    char command;

    stack<char> left;
    stack<char> right;

    cin >> str;

    for (int i = 0; i < str.length(); i++)
        left.push(str[i]);

    cin >> M;

    while (M--)
    {
        cin >> command;

        if (command == 'L')
        {
            if (!left.empty())
            {
                right.push(left.top());
                left.pop();
            }
        }
        else if (command == 'D')
        {
            if (!right.empty())
            {
                left.push(right.top());
                right.pop();
            }
        }
        else if (command == 'B')
        {
            if (!left.empty())
                left.pop();
        }
        else if (command == 'P')
        {
            cin >> str_;
            left.push(str_);
        }
    }
    while (!left.empty()) {
        right.push(left.top());
        left.pop();
    }

    while (!right.empty()){
        cout << right.top();
        right.pop();
    }
    return 0;
}