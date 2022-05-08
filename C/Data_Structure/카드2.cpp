#include <iostream>
#include <queue>
using namespace std;

int main()
{
    int N;

    cin >> N;

    queue<int> Card;

    for (int i = 0; i < N; i++)
        Card.push(i + 1);

    while (Card.size() != 1)
    {
        Card.pop();
        int top = Card.front();
        Card.pop();
        Card.push(top);
    }
    cout << Card.front() << endl;
}
