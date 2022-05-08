#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

bool cmp(const pair<char, int> &a, const pair<char, int> &b)
{
    return a.second > b.second;
}

int main()
{
    int N;
    string word;
    map<char, int> word_math;
    map<char, int>::iterator iterator;

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> word;

        for (int j = 0; j < word.length(); j++)
        {
            if (word_math.find(word[j]) != word_math.end())
                word_math[word[j]] += pow(10, word.length() - j - 1);
            else
                word_math.insert(make_pair(word[j], pow(10, word.length() - j - 1)));
        }
    }

    vector<pair<char,int>> vec( word_math.begin(), word_math.end() );

    sort(vec.begin(), vec.end(), cmp);

    int number = 9;
    int sum = 0;

    for (auto num : vec)
    {
        sum += num.second * number;
        number--;
    }
    cout << sum << endl;
}