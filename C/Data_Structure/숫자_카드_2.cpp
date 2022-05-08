#include <iostream>
#include <map>
using namespace std;

#define MAX 500000

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int M;
    int card[MAX];
    int How_much_of_card[MAX];
    int cnt = 1;

    map<int, int> Number_Card;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> card[i];
        if (Number_Card.find(card[i])->second)
            Number_Card[card[i]]++;
        else
            Number_Card.insert(make_pair(card[i], cnt));
    }
    cin >> M;

    for (int i = 0; i < M; i++) {
        cin >> How_much_of_card[i];

        if (Number_Card[How_much_of_card[i]]){
            cout << Number_Card[How_much_of_card[i]] << " ";
        }
        else
            cout << "0 ";
    }
}