#include <iostream>
#include <deque>
using namespace std;

int main()
{
    int N;
    int M;
    int pop_num;
    int index = 0;
    int cnt = 0;

    cin >> N >> M;

    deque<int> dq;

    for (int i = 0; i < N; i++)
        dq.push_back(i + 1);

    for (int i = 0; i < M; i++)
    {
        cin >> pop_num;
        for (int j = 0; j < dq.size(); j++) {
            if (dq[j] == pop_num) {
                index = j;
                break;
            }
        }
        if (index < dq.size() - index)
        {
            for(;;)
            {
                if (dq.front() == pop_num)
                {
                    dq.pop_front();
                    break;
                }
                ++cnt;
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else
        {
            for(;;)
            {
                if (dq.front() == pop_num)
                {
                    dq.pop_front();
                    break;
                }
                ++cnt;
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
    cout << cnt << endl;
}
