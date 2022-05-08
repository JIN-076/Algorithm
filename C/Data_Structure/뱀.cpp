#include <iostream>
#include <queue>
using namespace std;

#define MAX 100

int Board[MAX][MAX];
int Time;

int dx[] = { 0, 0, -1, 1 };
int dy[] = { 1, -1, 0, 0 };

struct Current_Direction
{
    int CurX;
    int CurY;
};

Current_Direction current[MAX];

queue<pair<int, char>> Info;

int solution(int N, int K, int L)
{
    queue<pair<pair<int, int>, int>> Snake;

    Snake.push({ { 0, 0 }, 1 });

    Board[0][0] = true;
    Time = 0;

    current->CurX = 0;
    current->CurY = 0;

    for(;;)
    {
        if (Time == Info.front().first)
        {
            if (Info.front().second == 'L')
            {
                if (current->CurX == 0 && current->CurY == 0)
                {
                    current->CurX = 2;
                    current->CurY = 2;
                }
                else if (current->CurX == 1 && current->CurY == 1)
                {
                    current->CurX = 3;
                    current->CurY = 3;
                }
                else if (current->CurX == 2 && current->CurY == 2)
                {
                    current->CurX = 1;
                    current->CurY = 1;
                }
                else if (current->CurX == 3 && current->CurY == 3)
                {
                    current->CurX = 0;
                    current->CurY = 0;
                }
            }
            else if (Info.front().second == 'D')
            {
                if (current->CurX == 0 && current->CurY == 0)
                {
                    current->CurX = 3;
                    current->CurY = 3;
                }
                else if (current->CurX == 1 && current->CurY == 1)
                {
                    current->CurX = 2;
                    current->CurY = 2;
                }
                else if (current->CurX == 2 && current->CurY == 2)
                {
                    current->CurX = 0;
                    current->CurY = 0;
                }
                else if (current->CurX == 3 && current->CurY == 3)
                {
                    current->CurX = 1;
                    current->CurY = 1;
                }
            }
            Info.pop();
        }
        Time++;

        int nx = Snake.back().first.first + dx[current->CurX];
        int ny = Snake.back().first.second + dy[current->CurY];

        if (Board[nx][ny] == true)
            return Time;
        if (nx < 0 || nx >= N || ny < 0 || ny >= N)
            return Time;
        if (Board[nx][ny] != 100)
        {
            Board[Snake.front().first.first][Snake.front().first.second] = false;
            Snake.pop();
        }
        Board[nx][ny] = true;
        Snake.push({ { nx, ny }, Snake.front().second++ } );
    }
}

int main()
{
    int N;
    int K;
    int Apple_col;
    int Apple_row;
    int L;
    int X;
    char C;

    cin >> N;
    cin >> K;

    for (int i = 0; i < K; i++) {
        cin >> Apple_row >> Apple_col;
        Board[Apple_row - 1][Apple_col - 1] = 100;
    }

    cin >> L;

    for (int i = 0; i < L; i++) {
        cin >> X >> C;
        Info.push({ X, C });
    }

    cout << solution(N, K, L);

    return 0;
}