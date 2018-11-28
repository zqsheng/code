#include<stdio.h>

int factoril(unsigned int i)
{
    if(i = 1)
    {
        return 1;
    }
    return i * factoril(i - 1);
} 

int main()
{
    int i = 20;
    printf("%d factorial value is %f \n",i,factoril(i));
}