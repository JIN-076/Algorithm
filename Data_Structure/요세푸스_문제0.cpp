#include <iostream>
using namespace std;

#define MAX 5002

typedef struct _circular_queue
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
    int K;

    cin >> N >> K;

    Queue q;
    init(&q);

    for (int i = 0; i < N; i++)
        push(&q, i + 1);

    cout << "<";
    for (int j = 0; j < N - 1; j++)
    {
        for (int k = 0; k < K - 1; k++)
        {
            push(&q, front(&q));
            pop(&q);
        }
        cout << front(&q) << ", ";
        pop(&q);
    }
    cout << front(&q) << ">\n";
    return 0;
}