#include<stdio.h>

int main()
{
    FILE *fp = NULL;
    fp = fopen("/home/zqsheng/code/code/c/io/test.txt","w+");
    fprintf(fp,"THIS IS TESTING FPRINTF...\n");
    fputs("this is testing for fputs...\n",fp);
    fclose(fp);

}