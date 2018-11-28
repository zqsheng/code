#include<stdio.h>

int x = 0;
int y = 5;
int func1()
{
    extern p,q;
    printf("%d,%d",p,q);
    return 0;
}

int p = 8;
int q = 10;
int main()
{
    func1();
    printf("%d,%d",x,y);
}


