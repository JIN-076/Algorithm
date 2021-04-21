#include <stdio.h>
#include <string.h>
using namespace std;

#define MAX 10000

typedef struct _deque
{
    int array[MAX];
    int front;
    int rear;
    int size;
} Deque;

void init(Deque *dq)
{
    dq->front = 0;
    dq->rear = 0;
    dq->size = 0;
}

int IsEmpty(Deque *dq)
{
    if (dq->front == dq->rear)
        return 1;
    return 0;
}

int IsFull(Deque *dq)
{
    if (((dq->rear + 1) % MAX) == dq->front)
        return 1;
    return 0;
}

int getRear(Deque *dq)
{
    if (IsEmpty(dq))
        return -1;
    return dq->array[dq->rear];
}

int getFront(Deque *dq)
{
    if (IsEmpty(dq))
        return -1;
    return dq->array[(dq->front + 1) % MAX];
}

void push_front(Deque *dq, int data)
{
    if (IsFull(dq))
        return;
    dq->array[dq->front] = data;
    dq->front = (dq->front - 1 + MAX) % MAX;
    (dq->size)++;
}

void push_back(Deque *dq, int data)
{
    if (IsFull(dq))
        return;
    dq->rear = (dq->rear + 1) % MAX;
    dq->array[dq->rear] = data;
    (dq->size)++;
}

int pop_front(Deque *dq)
{
    if (IsEmpty(dq))
        return -1;
    int _data = getFront(dq);
    dq->front = (dq->front + 1) % MAX;
    (dq->size)--;
    return _data;
}

int pop_back(Deque *dq)
{
    if (IsEmpty(dq))
        return -1;
    int data_ = dq->array[dq->rear];
    dq->rear = (dq->rear - 1 + MAX) % MAX;
    (dq->size)--;
    return data_;
}

int main()
{
    int N;
    int data;
    char str[12];

    scanf("%d", &N);

    Deque dq;
    init(&dq);

    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);

        if(!strcmp(str, "push_back"))
        {
            scanf("%d", &data);
            push_back(&dq, data);
        }
        else if (!strcmp(str, "push_front"))
        {
            scanf("%d", &data);
            push_front(&dq, data);
        }
        else if(!strcmp(str, "pop_back"))
            printf("%d\n", pop_back(&dq));
        else if (!strcmp(str, "pop_front"))
            printf("%d\n", pop_front(&dq));
        else if(!strcmp(str, "size"))
            printf("%d\n", dq.size);
        else if(!strcmp(str, "empty"))
            printf("%d\n", IsEmpty(&dq));
        else if(!strcmp(str, "front"))
            printf("%d\n", getFront(&dq));
        else if(!strcmp(str, "back"))
            printf("%d\n", getRear(&dq));
    }
}