#include <stdio.h>
#include <cstring>

using namespace std;

#define MAX 10001

typedef struct _stack {
    int array[MAX];
    int top;
} Stack;

void init(Stack *sp)
{
    sp->top = -1;
}

int IsEmpty(Stack *sp)
{
    if (sp->top == -1)
        return 1;
    return 0;
}

int size(Stack *sp)
{
    return sp->top + 1;
}

int IsFull(Stack *sp)
{
    if (sp->top + 1 >= MAX)
        return 1;
    return 0;
}

void push(Stack *sp, int data)
{
    if (IsFull(sp))
        return;
    sp->array[++(sp->top)] = data;
}

int pop(Stack *sp)
{
    if (IsEmpty(sp))
        return -1;
    return sp->array[(sp->top)--];
}

int peek(Stack *sp)
{
    if (IsEmpty(sp))
        return -1;
    return sp->array[sp->top];
}

int main()
{
    int N;
    int Num;
    char str[6];

    Stack stack;

    scanf("%d", &N);
    fgetc(stdin);

    init(&stack);

    for (int i = 0; i < N; i++)
    {
        scanf("%s", str);
        fgetc(stdin);

        if (!strcmp(str, "push"))
        {
            scanf("%d", &Num);
            fgetc(stdin);

            push(&stack, Num);
        }
        else if (!strcmp(str, "pop"))
            printf("%d\n", pop(&stack));
        else if (!strcmp(str, "empty"))
            printf("%d\n", IsEmpty(&stack));
        else if (!strcmp(str, "size"))
            printf("%d\n", size(&stack));
        else if (!strcmp(str, "top"))
            printf("%d\n", peek(&stack));
    }
}