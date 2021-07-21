#include <string>
#include <iostream>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int> numbers, int target, int sum, int cnt)
{
    if (cnt == numbers.size())
    {
        if (sum == target)
            answer++;
        return;
    }
    dfs(numbers, target, sum + numbers[cnt], cnt + 1);
    dfs(numbers, target, sum - numbers[cnt], cnt + 1);
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
}

int main()
{
    vector<int> numbers;

    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);

    cout << solution(numbers, 3);
}