#include <iostream>
#include <stdio.h>
using namespace std;

#define MAX 100000

typedef struct _heap
{
    int array[MAX];
    int size;
} Heap;

void init(Heap *hp)
{
    hp->size = 0;
}

void swap(int *a, int *b)
{
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

void insert(Heap *hp, int data)
{
    int node_idx = ++hp->size;

    while (node_idx != 1 && (data > hp->array[node_idx / 2]))
    {
        hp->array[node_idx] = hp->array[node_idx / 2];
        node_idx /= 2;
    }
    hp->array[node_idx] = data;
}

int delete_data(Heap *hp)
{
    if (hp->size == 0)
        return 0;
    int max = hp->array[1];
    hp->array[1] = hp->array[hp->size--];
    int parent = 1;
    int child;

    while (1)
    {
        child = parent * 2;
        if (child + 1 <= hp->size && hp->array[child] < hp->array[child + 1])
            child++;
        if (child > hp->size || hp->array[child] < hp->array[parent])
            break;
        swap(&hp->array[parent], &hp->array[child]);
        parent = child;
    }
    return max;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int x;

    cin >> N;

    Heap hp;
    init(&hp);

    for (int i = 0; i < N; i++)
    {
        cin >> x;
        if (x > 0)
            insert(&hp, x);
        else if (x == 0)
            cout << delete_data(&hp) << "\n";
    }
}