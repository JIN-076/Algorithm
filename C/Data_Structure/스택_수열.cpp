#include <iostream>
#include <stack>
using namespace std;

#define MAX 100000

int main()
{
    int N;
    int _stack[MAX];
    int push_idx = 1;
    string answer;

    cin >> N;

    stack<int> sequence;

    sequence.push(1);
    answer += "+\n";

    for (int i = 0; i < N; i++)
    {
        cin >> _stack[i];
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < _stack[i]; j++)
        {
            if (sequence.empty() || sequence.top() < _stack[i])
            {
                answer += "+\n";
                sequence.push(++push_idx);
            }
            else if (sequence.top() == _stack[i])
            {
                answer += "-\n";
                sequence.pop();
                break;
            }
            else if (sequence.top() > _stack[i])
            {
                cout << "NO";
                return 0;
            }
        }
    }
    cout << answer;
}