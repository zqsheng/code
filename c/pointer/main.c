#include<stdio.h>

int main()
{
    int var1;
    int var2[10];
    printf("var1 address:%p\n",&var1);
    printf("var2 address:%p\n",&var2);
    printf("var2[0] address:%p\n",&var2[0]);
    printf("var2[1] address:%p\n",&var2[1]);
}