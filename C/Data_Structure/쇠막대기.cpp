#include <iostream>
#include <stack>
using namespace std;

#define MAX 100000

int main() {
    char str[MAX];
    int i = 0;
    int sum = 0;

    stack<int> Iron;

    cin >> str;

    while (str[i] != '\0')
    {
        if (str[i] == '(')
            Iron.push(str[i]);
        else
        {
            Iron.pop();
            if (str[i - 1] == '(')
                sum += Iron.size();
            else
                sum++;
        }
        i++;
    }
    cout << sum << endl;
}