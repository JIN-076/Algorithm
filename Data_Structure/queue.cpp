#include <stdio.h>
#include <string.h>
using namespace std;

#define MAX 10000

typedef struct _queue
{
    int array[MAX];
    int front;
    int rear;
    int size;
} Queue;

void init(Queue *q)
{
    q->front = 0;
    q->rear = 0;
    q->size = 0;
}

int getNextIdx(int idx)
{
    if (idx + 1 >= MAX)
        return 0;
    return idx + 1;
}

void setNextIdx(int *idx)
{
    if (*idx + 1 >= MAX)
        *idx = 0;
    else
        (*idx)++;
}

int IsEmpty(Queue *q)
{
    if (q->front == q->rear)
        return 1;
    return 0;
}

int IsFull(Queue *q)
{
    if (getNextIdx(q->rear) == q->front)
        return 1;
    return 0;
}

int front(Queue *q)
{
    if (IsEmpty(q))
        return -1;
    return q->array[q->front];
}

int back(Queue *q)
{
    if (IsEmpty(q))
        return -1;
    return q->array[q->rear - 1];
}

void push(Queue *q, int data)
{
    if (IsFull(q))
        return;
    q->array[q->rear] = data;
    setNextIdx(&(q->rear));
    (q->size)++;
}

int pop(Queue *q)
{
    if (IsEmpty(q))
        return -1;
    int data = q->array[q->front];
    setNextIdx(&(q->front));
    (q->size)--;
    return data;
}

int main()
{
    int N;
    int data;
    char str[6];

    scanf("%d", &N);

    Queue q;
    init(&q);

    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);

        if(!strcmp(str, "push"))
        {
            scanf("%d", &data);
            push(&q, data);
        }
        else if(!strcmp(str, "pop"))
            printf("%d\n", pop(&q));
        else if(!strcmp(str, "size"))
            printf("%d\n", q.size);
        else if(!strcmp(str, "empty"))
            printf("%d\n", IsEmpty(&q));
        else if(!strcmp(str, "front"))
            printf("%d\n", front(&q));
        else if(!strcmp(str, "back"))
            printf("%d\n", back(&q));
    }
}