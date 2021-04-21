#include <iostream>
#include <queue>
using namespace std;

#define MAX 101
#define T_MAX 10000

// 동, 북, 서, 남
int dx[] = { 0, -1, 0, 1 };
int dy[] = { 1, 0, -1, 0 };

struct Current_Direction
{
    int CurX;
    int CurY;
};

Current_Direction current[MAX];

queue<pair<int, char>> Info;

[[noreturn]] int solution(int N, int K, int L)
{
    queue<pair<pair<int, int>, int>> Snake;

    Snake.push({ { 0, 0 }, 1 });

    Board[0][0] = true;
    Time = 0;

    current->CurX = 0;
    current->CurY = 0;

    pair<int, char> Snake_Info = Info.front();
    Info.pop();

    for(;;)
    {
        if (Time == Snake_Info.first)
        {
            if (Snake_Info.second == 'L')
            {
                if (current->curX == 0 && current->curY == 0)
                {
                    current->curX = 2;
                    current->curY = 2;
                }
                else if (current->curX == 1 && current->curY == 1)
                {
                    current->curX = 3;
                    current->curY = 3;
                }
                else if (current->curX == 2 && current->curY == 2)
                {
                    current->curX = 1;
                    current->curY = 1;
                }
                else if (current->curX == 3 && current->curY == 3)
                {
                    current->curX = 0;
                    current->curY = 0;
                }
            }
            else if (Snake_Info.second == 'D')
            {
                if (current->curX == 0 && current->curY == 0)
                {
                    current->curX = 3;
                    current->curY = 3;
                }
                else if (current->curX == 1 && current->curY == 1)
                {
                    current->curX = 2;
                    current->curY = 2;
                }
                else if (current->curX == 2 && current->curY == 2)
                {
                    current->curX = 0;
                    current->curY = 0;
                }
                else if (current->curX == 3 && current->curY == 3)
                {
                    current->curX = 1;
                    current->curY = 1;
                }
            }
            if (!Info.empty())
            {
                Snake_Info = Info.front();
                Info.pop();
            }
        }
    }
    Time++;

    int nx = Snake.front().first.first + dx[current->CurX];
    int ny = Snake.front().first.second + dy[current->CurY];

    if (Board[nx][ny] == true)
        return Time;
    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
        return Time;
    if (Board[nx][ny] != 100)
    {
        pair<int, int> Tail = Snake.front().first;
        Board[Tail.first][Tail.second] = false;
        Snake.pop();
    }
    Board[nx][ny] = true;
    Snake.push({ { nx, ny }, Snake.front().second++ } );
}

int main()
{
    int N;
    int K;
    int Apple_col;
    int Apple_row;
    int L;
    int X[T_MAX];
    char C;

    int Board[MAX][MAX];
    int Time;

    cin >> N;
    cin >> K;

    for (int i = 0; i < K; i++) {
        cin >> Apple_col >> Apple_row;
        Board[Apple_row - 1][Apple_col - 1] = 100;
    }

    cin >> L;

    for (int i = 0; i < L; i++) {
        cin >> X >> C;
        Info.push({X, C});
    }

    cout << solution(N, K, L);

    return 0;
}